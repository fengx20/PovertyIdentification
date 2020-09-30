package com.wzxy.povertyidentification.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.wzxy.povertyidentification.bean.Pkrdsqb;
import com.wzxy.povertyidentification.bean.Toupiao;
import com.wzxy.povertyidentification.bean.Xs;
import com.wzxy.povertyidentification.factory.DaoFactory;

@SuppressWarnings("serial")
public class UserLoginServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response); //执行doPost方法
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
    	String action = request.getParameter("action");
		int _key = Integer.parseInt(action);
		switch(_key){
			case 1: //用户登录验证
				String User_no=request.getParameter("user_no");
				String Password=request.getParameter("password");
				String Actor=request.getParameter("actor");
				if(DaoFactory.getUserLoginDaoInstance().UserLogin(User_no, Password,Actor)==true){
					if("Root".equals(Actor)){   //管理员登录验证
						request.setAttribute("user_no",User_no);
						RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
						dispatcher.forward(request,response); //请求转发给index.jsp
					}else if("Xs".equals(Actor)){   //学生登录验证
						request.setAttribute("fullstuNo",User_no);
						RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Xs/XsSuccess.jsp");
						dispatcher.forward(request,response);
					}else if("Bjxz".equals(Actor)){   //班级小组登录验证
						if(DaoFactory.getXsDaoInstance().checkBjxzlevel(User_no)==true){ //判断是成员还是组长登录 true为成员
							request.setAttribute("fullstuNo",User_no);
							//以下操作是通过查小组成员班级然后找到与其同班的同学最后添加进双主键的toupiao表里去实现一对多投票
							String ClassName  ="";
							String Bjxzcy     =request.getParameter("user_no");
							String Xs         ="";
							String XsName     ="";
							String Sex        ="";
							String ClassName1 ="";
							String Xueyuan    ="";
							String Zhuangtai  ="未投票";
							//找与成员同一个班并且已提交申请的学生（ 因为pkrdsqbxx表里没有bjcy字段所以只能在xsxx表里找）
							List<Xs> list = DaoFactory.getXsDaoInstance().findByStuNo(Bjxzcy);
							if(list.size() != 0){
								for(int i = 0;i < list.size();i++){
									@SuppressWarnings("unused")
									Xs xs = list.get(i);
									ClassName = list.get(i).getClassName(); //找到的className值赋给ClassName
								}
							}
							List<Pkrdsqb> list1 = DaoFactory.getPkrdsqbDaoInstance().findbyClassName(ClassName); //在pkrdsqbxx里找同班的同学
							if(list1.size() != 0){
								for(int j = 0;j < list1.size();j++){
									@SuppressWarnings("unused")
									//调用方法找到的值都赋给全局变量，取pkrdsqbxx表里的本班的同学信息 ，加上bjcy字段添加到toupiao里， 实现一个bjcy对pkrdsqbxx里本班每位同学都有一次投票机会
									Pkrdsqb sqb = list1.get(j);
									Xs = list1.get(j).getFullstuNo();
									XsName = list1.get(j).getStuName();
									Sex = list1.get(j).getSex();
									ClassName1 = list1.get(j).getClassName();
									Xueyuan = list1.get(j).getXueyuan();
									Toupiao tp = new Toupiao();
									tp.setBjxzcy(Bjxzcy);
									tp.setXs(Xs);
									tp.setXsName(XsName);
									tp.setSex(Sex);
									tp.setClassName(ClassName1);
									tp.setXueyuan(Xueyuan);
									tp.setZhuangtai(Zhuangtai);
									//先判断toupiao表里是否有与bjcy，xs，重复的数据
									if(DaoFactory.getToupiaoDaoInstance().checkchongming(Bjxzcy, Xs) == true){
										//将在pkrdsqbxx表找到的小组成员与其同班同学添加进toupiao表
										DaoFactory.getToupiaoDaoInstance().addToupiao(tp);
									}
								}
							}
						}
						if(DaoFactory.getXsDaoInstance().checkBjxzlevel(User_no) == true){ //判断是成员还是组长 true: 成员
							//取班级成员的班别只能在xsxx表里取 ，找与组员同一个班的学生
							List<Xs> list3 = DaoFactory.getXsDaoInstance().findByStuNo(User_no);
							request.setAttribute("className",list3);
							RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Bjxz/BjxzCySuccess.jsp"); //跳转到成员页面
							dispatcher.forward(request,response);
						}else{
							request.setAttribute("fullstuNo",User_no);
							List<Xs> list2 = DaoFactory.getXsDaoInstance().findByStuNo(User_no); //找与组长同一个班的学生
							request.setAttribute("className",list2);
							RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Bjxz/BjxzZzSuccess.jsp"); //跳转到组长页面
							dispatcher.forward(request,response);
						}
					}else if("Fdy".equals(Actor)){     //辅导员登陆验证
						request.setAttribute("teacherNo",User_no);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/view/page/Fdy/FdySuccess.jsp");
						dispatcher.forward(request,response);
					}else if("Xxyc".equals(Actor)){    //系学院处登陆验证
						request.setAttribute("xxyc",User_no);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/view/page/Xxyc/XxycSuccess.jsp");
						dispatcher.forward(request,response);
					}else if("Xxgc".equals(Actor)){    //校学工处登录验证
						request.setAttribute("xxgc",User_no);
						RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Xxgc/XxgcSuccess.jsp");
						dispatcher.forward(request,response);
					}
				}else{
		  			RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp?error=yes");
		  			dispatcher.forward(request,response);
	 			}
				return;
			case 2: //用户修改密码
				String User_no1 = request.getParameter("user_no");
				String Password1 = request.getParameter("newpassword");
				DaoFactory.getUserLoginDaoInstance().updatePwd(User_no1, Password1);
				response.setContentType("text/html;charset=utf8");
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
				out.print("alert('修改成功！');");
				out.print("history.go(-2)");
				out.print("</script>");
				return;
		}
	}
}