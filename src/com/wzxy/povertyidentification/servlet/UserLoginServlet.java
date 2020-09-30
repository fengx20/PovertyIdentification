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
		doPost(request, response); //ִ��doPost����
	}
	public void doPost(HttpServletRequest request,HttpServletResponse response) 
			throws ServletException,IOException{
    	String action = request.getParameter("action");
		int _key = Integer.parseInt(action);
		switch(_key){
			case 1: //�û���¼��֤
				String User_no=request.getParameter("user_no");
				String Password=request.getParameter("password");
				String Actor=request.getParameter("actor");
				if(DaoFactory.getUserLoginDaoInstance().UserLogin(User_no, Password,Actor)==true){
					if("Root".equals(Actor)){   //����Ա��¼��֤
						request.setAttribute("user_no",User_no);
						RequestDispatcher dispatcher=request.getRequestDispatcher("/index.jsp");
						dispatcher.forward(request,response); //����ת����index.jsp
					}else if("Xs".equals(Actor)){   //ѧ����¼��֤
						request.setAttribute("fullstuNo",User_no);
						RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Xs/XsSuccess.jsp");
						dispatcher.forward(request,response);
					}else if("Bjxz".equals(Actor)){   //�༶С���¼��֤
						if(DaoFactory.getXsDaoInstance().checkBjxzlevel(User_no)==true){ //�ж��ǳ�Ա�����鳤��¼ trueΪ��Ա
							request.setAttribute("fullstuNo",User_no);
							//���²�����ͨ����С���Ա�༶Ȼ���ҵ�����ͬ���ͬѧ�����ӽ�˫������toupiao����ȥʵ��һ�Զ�ͶƱ
							String ClassName  ="";
							String Bjxzcy     =request.getParameter("user_no");
							String Xs         ="";
							String XsName     ="";
							String Sex        ="";
							String ClassName1 ="";
							String Xueyuan    ="";
							String Zhuangtai  ="δͶƱ";
							//�����Աͬһ���ಢ�����ύ�����ѧ���� ��Ϊpkrdsqbxx����û��bjcy�ֶ�����ֻ����xsxx�����ң�
							List<Xs> list = DaoFactory.getXsDaoInstance().findByStuNo(Bjxzcy);
							if(list.size() != 0){
								for(int i = 0;i < list.size();i++){
									@SuppressWarnings("unused")
									Xs xs = list.get(i);
									ClassName = list.get(i).getClassName(); //�ҵ���classNameֵ����ClassName
								}
							}
							List<Pkrdsqb> list1 = DaoFactory.getPkrdsqbDaoInstance().findbyClassName(ClassName); //��pkrdsqbxx����ͬ���ͬѧ
							if(list1.size() != 0){
								for(int j = 0;j < list1.size();j++){
									@SuppressWarnings("unused")
									//���÷����ҵ���ֵ������ȫ�ֱ�����ȡpkrdsqbxx����ı����ͬѧ��Ϣ ������bjcy�ֶ���ӵ�toupiao� ʵ��һ��bjcy��pkrdsqbxx�ﱾ��ÿλͬѧ����һ��ͶƱ����
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
									//���ж�toupiao�����Ƿ�����bjcy��xs���ظ�������
									if(DaoFactory.getToupiaoDaoInstance().checkchongming(Bjxzcy, Xs) == true){
										//����pkrdsqbxx���ҵ���С���Ա����ͬ��ͬѧ��ӽ�toupiao��
										DaoFactory.getToupiaoDaoInstance().addToupiao(tp);
									}
								}
							}
						}
						if(DaoFactory.getXsDaoInstance().checkBjxzlevel(User_no) == true){ //�ж��ǳ�Ա�����鳤 true: ��Ա
							//ȡ�༶��Ա�İ��ֻ����xsxx����ȡ ��������Աͬһ�����ѧ��
							List<Xs> list3 = DaoFactory.getXsDaoInstance().findByStuNo(User_no);
							request.setAttribute("className",list3);
							RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Bjxz/BjxzCySuccess.jsp"); //��ת����Աҳ��
							dispatcher.forward(request,response);
						}else{
							request.setAttribute("fullstuNo",User_no);
							List<Xs> list2 = DaoFactory.getXsDaoInstance().findByStuNo(User_no); //�����鳤ͬһ�����ѧ��
							request.setAttribute("className",list2);
							RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Bjxz/BjxzZzSuccess.jsp"); //��ת���鳤ҳ��
							dispatcher.forward(request,response);
						}
					}else if("Fdy".equals(Actor)){     //����Ա��½��֤
						request.setAttribute("teacherNo",User_no);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/view/page/Fdy/FdySuccess.jsp");
						dispatcher.forward(request,response);
					}else if("Xxyc".equals(Actor)){    //ϵѧԺ����½��֤
						request.setAttribute("xxyc",User_no);
						RequestDispatcher dispatcher = request.getRequestDispatcher("/view/page/Xxyc/XxycSuccess.jsp");
						dispatcher.forward(request,response);
					}else if("Xxgc".equals(Actor)){    //Уѧ������¼��֤
						request.setAttribute("xxgc",User_no);
						RequestDispatcher dispatcher=request.getRequestDispatcher("/view/page/Xxgc/XxgcSuccess.jsp");
						dispatcher.forward(request,response);
					}
				}else{
		  			RequestDispatcher dispatcher=request.getRequestDispatcher("/login.jsp?error=yes");
		  			dispatcher.forward(request,response);
	 			}
				return;
			case 2: //�û��޸�����
				String User_no1 = request.getParameter("user_no");
				String Password1 = request.getParameter("newpassword");
				DaoFactory.getUserLoginDaoInstance().updatePwd(User_no1, Password1);
				response.setContentType("text/html;charset=utf8");
				PrintWriter out = response.getWriter();
				out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
				out.print("alert('�޸ĳɹ���');");
				out.print("history.go(-2)");
				out.print("</script>");
				return;
		}
	}
}