package com.wzxy.povertyidentification.servlet;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wzxy.povertyidentification.bean.Bj;
import com.wzxy.povertyidentification.factory.DaoFactory;

public class BjServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int _key = Integer.parseInt(action);
        switch (_key) {
            case 1: //����Աͨ����ְ���Ų��Ҷ�Ӧ�����İ༶
                String TeacherNo = request.getParameter("teacherNo");
                List<Bj> list = DaoFactory.getBjDaoInstance().findClassName(TeacherNo);  //������ý�ְ���Ŷ�Ӧ�����İ༶
                request.setAttribute("suodaibj", list);
                request.getRequestDispatcher("/view/page/Fdy/fdyChakan.jsp").forward(request, response);
                break;
            case 2: //ϵѧԺ����ѯ��ѧԺ���а༶
                String TeacherNo1 = request.getParameter("teacherNo");
                List<Bj> list1 = DaoFactory.getBjDaoInstance().findClassName(TeacherNo1);  //����ý�ְ���Ŷ�Ӧ�İ༶
                request.setAttribute("xybj", list1);
                request.getRequestDispatcher("/view/page/Xxyc/Xxycchakan.jsp").forward(request, response);
                break;
        }
    }
}