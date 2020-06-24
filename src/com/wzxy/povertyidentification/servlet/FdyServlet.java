package com.wzxy.povertyidentification.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzxy.povertyidentification.bean.Fdy;
import com.wzxy.povertyidentification.factory.DaoFactory;

@SuppressWarnings("serial")
public class FdyServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		doPost(request, response);
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		String action = request.getParameter("action");
		int _key = Integer.parseInt(action);
		switch(_key){
		case 1: //管理员添加辅导员
			String TeacherNo     =request.getParameter("teacherNo");
			String TeacherName   =request.getParameter("teacherName");
			String Xueyuan       =request.getParameter("xueyuan");
			String PhoneNum      =request.getParameter("phoneNum");
			
			Fdy fdy=new Fdy();
			
			fdy.setTeacherNo(TeacherNo);
			fdy.setTeacherName(TeacherName);
			fdy.setXueyuan(Xueyuan);
			fdy.setPhoneNum(PhoneNum);
			
			if(DaoFactory.getFdyDaoInstance().checkchongming(TeacherNo)==true){
		         DaoFactory.getFdyDaoInstance().addFdy(fdy);                 
		         response.setContentType("text/html;charset=utf8");
				 PrintWriter out = response.getWriter();
		         out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
		         out.print("alert('添加成功！！');");
		         out.print("history.go(-1);");
		         out.print("</script>");
			}else{
				response.setContentType("text/html;charset=utf8");
				PrintWriter out = response.getWriter();
	            out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
	            out.print("alert('教师工号已存在，请重新输入！');");
	            out.print("history.go(-1);");
	            out.print("</script>");
			}
			
			break;
			
		case 10: //管理员添加辅导员（窗口）
			String TeacherNo10     =request.getParameter("teacherNo");
			String TeacherName10   =request.getParameter("teacherName");
			String Xueyuan10       =request.getParameter("xueyuan");
			String PhoneNum10      =request.getParameter("phoneNum");
			
			Fdy fdy10=new Fdy();
			
			fdy10.setTeacherNo(TeacherNo10);
			fdy10.setTeacherName(TeacherName10);
			fdy10.setXueyuan(Xueyuan10);
			fdy10.setPhoneNum(PhoneNum10);
			
			if(DaoFactory.getFdyDaoInstance().checkchongming(TeacherNo10)==true){
		         DaoFactory.getFdyDaoInstance().addFdy(fdy10);                 
		         response.setContentType("text/html;charset=utf8");
				 PrintWriter out = response.getWriter();
		         out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
		         out.print("alert('添加成功！！');");
		         out.print("window.opener.location.reload();");
		         out.print("window.close();");
		         out.print("</script>");
			}else{
				response.setContentType("text/html;charset=utf8");
				PrintWriter out = response.getWriter();
	            out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
	            out.print("alert('教师工号已存在，请重新输入！');");
	            out.print("history.go(-1);");
	            out.print("</script>");
			}
			
			break;
			
		case 2: //删除辅导员
			String TeacherNo1 =request.getParameter("teacherNo");
			
			DaoFactory.getFdyDaoInstance().deleteFdy(TeacherNo1);
			
			response.setContentType("text/html;charset=utf8");
			PrintWriter out = response.getWriter();
            out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
            out.print("alert('已删除！');");
            out.print("history.go(-1);");
            out.print("</script>");
	        
			break;
			
		case 3: //查询所有辅导员
			List<Fdy>list=DaoFactory.getFdyDaoInstance().fdyList();
			
			request.setAttribute("list",list); 
			
			request.getRequestDispatcher("/view/page/Manager/Fdy/query/queryallFdySuccess.jsp").forward(request, response);
				
			break;
			
		case 4: //查询单个
			String TeacherNo2 =request.getParameter("teacherNo");
			
			List<Fdy>list1=DaoFactory.getFdyDaoInstance().findByTeacherNo(TeacherNo2);
			
			request.setAttribute("fdy1",list1);
			
			request.getRequestDispatcher("/view/page/Manager/Fdy/query/queryoneFdySuccess.jsp").forward(request, response);
			
			break;
			
		case 5: //进入修改
			String TeacherNo3 =request.getParameter("teacherNo");  //通过findByTeacherNo(TeacherNo3)方法将主键信息传值过来
			
			request.setAttribute("result",DaoFactory.getFdyDaoInstance().findByTeacherNo(TeacherNo3));
			
			request.getRequestDispatcher("/view/page/Manager/Fdy/update/updateFdy.jsp").forward(request, response);
			
			break;
			 
		case 6: //修改完成       
			String TeacherNo4     =request.getParameter("teacherNo");
			String TeacherName4   =request.getParameter("teacherName");
			String Xueyuan4       =request.getParameter("xueyuan");
			String PhoneNum4      =request.getParameter("phoneNum");
			
			Fdy fdy1=new Fdy();
			
			fdy1.setTeacherNo(TeacherNo4);
			fdy1.setTeacherName(TeacherName4);
			fdy1.setXueyuan(Xueyuan4);
			fdy1.setPhoneNum(PhoneNum4);
			
			DaoFactory.getFdyDaoInstance().updateFdy(TeacherNo4, fdy1);
			 
			response.setContentType("text/html;charset=utf8");
			PrintWriter out2 = response.getWriter();
            out2.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
            out2.print("alert('修改成功！');");
            out2.print("history.go(-2);");
            out2.print("</script>");
			
			break;
		}
	}
	
	protected void forward(HttpServletRequest request, HttpServletResponse response,String url)throws ServletException, IOException{
		  RequestDispatcher rd =request.getRequestDispatcher(url);
		  rd.forward(request, response);
	 }

}
