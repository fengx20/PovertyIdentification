package com.wzxy.povertyidentification.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzxy.povertyidentification.bean.Xs;
import com.wzxy.povertyidentification.factory.DaoFactory;

@SuppressWarnings("serial")
public class XsServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int _key = Integer.parseInt(action);
        switch (_key) {
            case 1: //添加
                String StuNo1 = request.getParameter("stuNo");
                String StuName = request.getParameter("stuName");
                String Sex = request.getParameter("sex");
                String ClassName = request.getParameter("className");
                String Xueyuan = request.getParameter("xueyuan");
                String Grade = request.getParameter("grade");
                String Level = request.getParameter("level");
                String Zhuangtai = request.getParameter("zhuangtai");

                Xs xs = new Xs();

                xs.setStuNo(StuNo1);
                xs.setStuName(StuName);
                xs.setSex(Sex);
                xs.setClassName(ClassName);
                xs.setXueyuan(Xueyuan);
                xs.setGrade(Grade);
                xs.setLevel(Level);
                xs.setZhuangtai(Zhuangtai);

                if (DaoFactory.getXsDaoInstance().checkchongming(StuNo1) == true) {
                    DaoFactory.getXsDaoInstance().addXs(xs);
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
                    out.print("alert('添加成功！！');");
                    out.print("history.go(-1);");
                    out.print("</script>");
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('学号已存在，请重新输入！');");
                    out.print("history.go(-1);");
                    out.print("</script>");
                }

                break;

            case 10: //窗口添加
                String StuNo5 = request.getParameter("stuNo");
                String StuName10 = request.getParameter("stuName");
                String Sex10 = request.getParameter("sex");
                String ClassName10 = request.getParameter("className");
                String Xueyuan10 = request.getParameter("xueyuan");
                String Grade10 = request.getParameter("grade");
                String Level1 = request.getParameter("level");
                String Zhuangtai1 = request.getParameter("zhuangtai");

                Xs xs1 = new Xs();

                xs1.setStuNo(StuNo5);
                xs1.setStuName(StuName10);
                xs1.setSex(Sex10);
                xs1.setClassName(ClassName10);
                xs1.setXueyuan(Xueyuan10);
                xs1.setGrade(Grade10);
                xs1.setLevel(Level1);
                xs1.setZhuangtai(Zhuangtai1);

                if (DaoFactory.getXsDaoInstance().checkchongming(StuNo5) == true) {
                    DaoFactory.getXsDaoInstance().addXs(xs1);
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript' >");
                    out.print("alert('添加成功！！');");
                    out.print("window.opener.location.reload();");
                    out.print("window.close();");
                    out.print("</script>");
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('学号已存在，请重新输入！');");
                    out.print("history.go(-1);");
                    out.print("</script>");
                }

                break;

            case 2: //删除
                String StuNo2 = request.getParameter("stuNo");

                DaoFactory.getXsDaoInstance().delXs(StuNo2);

                response.setContentType("text/html;charset=utf8");

                PrintWriter out = response.getWriter();
                out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out.print("alert('已删除！');");
                out.print("history.go(-1);");
                out.print("</script>");

                break;

            case 3: //查询所有
                List<Xs> list = DaoFactory.getXsDaoInstance().stuList();

                request.setAttribute("list", list);

                request.getRequestDispatcher("/view/page/Manager/Xs/query/queryallSuccess.jsp").forward(request, response);

                break;

            case 4: //查询个人
                String StuNo3 = request.getParameter("stuNo");

                List<Xs> list1 = DaoFactory.getXsDaoInstance().findByStuNo(StuNo3);

                request.setAttribute("xs1", list1);

                request.getRequestDispatcher("/view/page/Manager/Xs/query/queryoneSuccess.jsp").forward(request, response);

                break;

            case 5: //修改学生信息
                String StuNo4 = request.getParameter("stuNo");

                request.setAttribute("result", DaoFactory.getXsDaoInstance().findByStuNo(StuNo4));

                request.getRequestDispatcher("/view/page/Manager/Xs/update/updateXs.jsp").forward(request, response);

                break;
            case 6: //修改完成
                String StuNo = request.getParameter("stuNo");
                String StuName1 = request.getParameter("stuName");
                String Sex1 = request.getParameter("sex");
                String ClassName1 = request.getParameter("className");
                String Xueyuan1 = request.getParameter("xueyuan");
                String Grade1 = request.getParameter("grade");

                Xs xs2 = new Xs();

                xs2.setStuNo(StuNo);
                xs2.setStuName(StuName1);
                xs2.setSex(Sex1);
                xs2.setClassName(ClassName1);
                xs2.setXueyuan(Xueyuan1);
                xs2.setGrade(Grade1);

                DaoFactory.getXsDaoInstance().updateXs(StuNo, xs2);

                response.setContentType("text/html;charset=utf8");
                PrintWriter out2 = response.getWriter();
                out2.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out2.print("alert('修改成功！');");
                out2.print("history.go(-2);");
                out2.print("</script>");

                break;
        }
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }
}
