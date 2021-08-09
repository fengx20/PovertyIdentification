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
import com.wzxy.povertyidentification.factory.DaoFactory;

public class PkrdsqbServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        doPost(request, response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        int _key = Integer.parseInt(action);
        switch (_key) {
            case 25: //ѧ����д�����ǰ�ж�(�߼�)
                String FullstuNo20 = request.getParameter("fullstuNo");
                if (DaoFactory.getXsDaoInstance().checkXstj(FullstuNo20)) {
                    request.getRequestDispatcher("/view/page/Xs/Pkrdsqb.jsp").forward(request, response);
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('�����ύ�������ȥ�鿴���״̬��');");
                    out.print("history.go(-1);");
                    out.print("</script>");
                }
                return;
            case 1: //ѧ����д������ύ����(ѧ���û�)
                String FullstuNo = request.getParameter("fullstuNo");
                String StuName = request.getParameter("stuName");
                String Sex = request.getParameter("sex");
                String Birth = request.getParameter("birth");
                String IdNo = request.getParameter("idNo");
                String Money = request.getParameter("money");
                String Xueyuan = request.getParameter("xueyuan");
                String ClassName = request.getParameter("className");
                String PhoneNum = request.getParameter("phoneNum");
                String Reason = request.getParameter("reason");
                String Zhuangtai = request.getParameter("zhuangtai");
                int Tongguo = Integer.parseInt(request.getParameter("tongguo"));
                int Fandui = Integer.parseInt(request.getParameter("fandui"));
                String Qingkuang = request.getParameter("qingkuang");
                String Juti5 = request.getParameter("juti");
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(FullstuNo);
                sqb.setStuName(StuName);
                sqb.setSex(Sex);
                sqb.setBirth(Birth);
                sqb.setIdNo(IdNo);
                sqb.setMoney(Money);
                sqb.setXueyuan(Xueyuan);
                sqb.setClassName(ClassName);
                sqb.setPhoneNum(PhoneNum);
                sqb.setReason(Reason);
                sqb.setZhuangtai(Zhuangtai);
                sqb.setTongguo(Tongguo);
                sqb.setFandui(Fandui);
                sqb.setQingkuang(Qingkuang);
                sqb.setJuti(Juti5);
                if (!DaoFactory.getPkrdsqbDaoInstance().checkchongming(FullstuNo)) {     //�ж�pkrdsqbxx�����޴�ѧ������
                    DaoFactory.getPkrdsqbDaoInstance().addPkrdsqb(sqb);                          //��һ����д��������ݲ���
                    DaoFactory.getXsDaoInstance().updateXsZt(FullstuNo);                                 //�ύ����ѧ���ύ״̬
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('�ύ�ɹ�����ȴ���ˣ��ڼ䲻�����ύ��');");
                    out.print("history.go(-2)");
                    out.print("</script>");
                } else {
                    DaoFactory.getPkrdsqbDaoInstance().updatePkrdsqb(FullstuNo, sqb);
                    DaoFactory.getXsDaoInstance().updateXsZt(FullstuNo);                            //���˻صڶ����ύ���޸����ݲ���
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('�ύ�ɹ�����ȴ���ˣ��ڼ䲻�����ύ��');");
                    out.print("history.go(-2)");
                    out.print("</script>");
                }
                break;
            case 2: //ѧ���ύ������鿴��������״̬����(ѧ���û�)
                String FullstuNo1 = request.getParameter("fullstuNo");
                if (DaoFactory.getPkrdsqbDaoInstance().checkchongming(FullstuNo1) == true) {   //��ѧ�����������Ϣ����
                    List<Pkrdsqb> list = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo1); //����ѧ���ҵ�����
                    request.setAttribute("sqb", list);
                    request.getRequestDispatcher("/view/page/Xs/chakan.jsp").forward(request, response);
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('�㻹δ��дƶ���϶��������ȥ��д');");
                    out.print("history.back();");
                    out.print("</script>");
                }
                break;
            case 24: //ѧ���鿴��Ϣ(�˻�����)����(ѧ���û�)
                String FullstuNo19 = request.getParameter("fullstuNo");
                List<Pkrdsqb> list14 = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo19);
                request.setAttribute("jutixx", list14);
                request.getRequestDispatcher("/view/page/Xs/jutixx.jsp").forward(request, response);
                break;
            case 4: //С���Ա��toupiao����鿴ͬ�����ύ�ģ���pkrdsqbxx������ӵģ�ͬѧ
                String ClassName2 = request.getParameter("className");
                String BjcystuNo = request.getParameter("bjcystuNo");
                List<Toupiao> list1 = DaoFactory.getToupiaoDaoInstance().bjxzcychakan(ClassName2, BjcystuNo);    //����bjcy��Ӧ�İ࣬�ó�Ա�Ա������ͶƱ��  ��toupiao��˫�����������ݣ� ʵ��һ�˶Զ���ͶƱ
                request.setAttribute("bbxs_ytj", list1);
                request.setAttribute("bjcystuNo", BjcystuNo);
                request.getRequestDispatcher("/view/page/Bjxz/Chakan.jsp").forward(request, response);
                break;
            case 5: //С���Ա�鿴��ѧ�������
                String BjcystuNo1 = request.getParameter("bjcystuNo");
                String FullstuNo3 = request.getParameter("fullstuNo");
                List<Pkrdsqb> list3 = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo3);    //ͨ��ѧ����pkrdsqbxx�Ҹ�ѧ�������
                request.setAttribute("cksqb", list3);
                request.setAttribute("bjcystuNo", BjcystuNo1);
                request.getRequestDispatcher("/view/page/Bjxz/Toupiao.jsp").forward(request, response);
                break;
            case 6: //С���ԱͶƱ��ͶƱֵ�����ݿ⡡����
                String FullstuNo4 = request.getParameter("fullstuNo");
                String BjcystuNo2 = request.getParameter("bjcystuNo");
                String Toupiao = request.getParameter("toupiao");
                if (DaoFactory.getToupiaoDaoInstance().checkzt(BjcystuNo2, FullstuNo4)) {   //�жϸ�С���Ա�Ƿ���ͶƱ��ûͶ�Ϳ���Ͷ�� Ͷ�˵ľͲ���Ͷ
                    if ("tongguo".equals(Toupiao)) {
                        DaoFactory.getPkrdsqbDaoInstance().updatetongguo(FullstuNo4);             //�޸�ͨ��ͶƱ��
                    } else {
                        DaoFactory.getPkrdsqbDaoInstance().updatefandui(FullstuNo4);              //�޸ķ���ͶƱ��
                    }
                    DaoFactory.getToupiaoDaoInstance().updatezt(BjcystuNo2, FullstuNo4);  //������ͶƱ������Ҫ���� toupiao ��ѧ����ͶƱ���
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('ͶƱ�ɹ���');");
                    out.print("window.history.go(-2);");
                    out.print("</script>");
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('ͶƱʧ�ܣ��˷���������ͶƱ��');");
                    out.print("window.history.go(-2);");
                    out.print("</script>");
                }
                break;
            case 7: //�鳤�鿴��� ���ύ����Ա�� �� �˻�ѧ��
                String ClassName4 = request.getParameter("className");
                DaoFactory.getPkrdsqbDaoInstance().updateTgqingkuang(ClassName4); //��Ʊ����Ϊ3����ͨ�����ڷ��������Ϊ  ��ͨ��   �����������  �鳤��¼����鿴�����ı����������
                DaoFactory.getPkrdsqbDaoInstance().updateFdqingkuang(ClassName4); //�෴
                List<Pkrdsqb> list2 = DaoFactory.getPkrdsqbDaoInstance().findbyClassName(ClassName4); ////����С���鳤ͬ���ͬѧ
                request.setAttribute("tpqingkuang", list2);
                request.getRequestDispatcher("/view/page/Bjxz/ZzChakan.jsp").forward(request, response);
                break;
            case 8: //�鳤�ύ��ͨ������
                String FullstuNo5 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai(FullstuNo5); //�༶С���鳤��,�������״̬����ͨ��
                response.setContentType("text/html;charset=utf8");
                PrintWriter out1 = response.getWriter();
                out1.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out1.print("alert('���ύ��');");
                out1.print("window.history.go(-1);");
                out1.print("</script>");
                break;
            case 13: //�༶С���鳤�˻������
                String FullstuNo9 = request.getParameter("fullstuNo");
                String Juti1 = request.getParameter("juti");
                DaoFactory.getPkrdsqbDaoInstance().updateJuti(FullstuNo9, Juti1); //���ģ��˻أ���������
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai1(FullstuNo9);  //�༶ƶ��С���鳤��,�������״̬��δͨ��
                DaoFactory.getXsDaoInstance().updateXsZt1(FullstuNo9);            //����ѧ���ύ��������
                response.setContentType("text/html;charset=utf8");
                PrintWriter out4 = response.getWriter();
                out4.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out4.print("alert('���˻أ�');");
                out4.print("window.opener.location.reload();");
                out4.print("window.close();");
                out4.print("</script>");
                break;
            case 9: //����Ա�鿴�����༶��ͨ���������
                String ClassName5 = request.getParameter("className");
                List<Pkrdsqb> list4 = DaoFactory.getPkrdsqbDaoInstance().fdychakan(ClassName5);  //��bjxx��˫���������������ʦ���Ŷ�Ӧ�İ༶
                request.setAttribute("bjchakan", list4);
                request.getRequestDispatcher("/view/page/Fdy/BjChakan.jsp").forward(request, response);
                break;
            case 26: //(����)����Ա/ϵ�쵼�鿴�༶�����������
                String ClassName26 = request.getParameter("className");
                List<Pkrdsqb> list26 = DaoFactory.getPkrdsqbDaoInstance().findbyClassName(ClassName26);  //��bjxx��˫���������������ʦ���Ŷ�Ӧ�İ༶ ���Ҹð����������
                request.setAttribute("bjchakan", list26);
                request.getRequestDispatcher("/ClassAll.jsp").forward(request, response);
                break;
            case 12: //(����)С���鳤/����Ա/ϵ�쵼/ѧ�����鿴�༶���������
                String FullstuNo8 = request.getParameter("fullstuNo");
                List<Pkrdsqb> list5 = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo8);
                request.setAttribute("cksqb", list5);
                request.getRequestDispatcher("/Cksqb.jsp").forward(request, response);
                break;
            case 11: //����Ա�ύ��ѧԺ��
                String FullstuNo7 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai2(FullstuNo7);  //�޸����״̬
                response.setContentType("text/html;charset=utf8");
                PrintWriter out3 = response.getWriter();
                out3.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out3.print("alert('���ύ��ѧԺ����');");
                out3.print("window.history.go(-1);");
                out3.print("</script>");
                break;
            //13 14��һ�������״̬�޸Ĳ�һ��
            case 14: //����Ա��д�˻�����
                String FullstuNo0 = request.getParameter("fullstuNo");
                String Juti = request.getParameter("juti");
                DaoFactory.getPkrdsqbDaoInstance().updateJuti(FullstuNo0, Juti);  //���ľ������ݣ��˻����ɣ�
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai3(FullstuNo0);  //�������״̬(���״̬��С���鳤��һ��)
                DaoFactory.getXsDaoInstance().updateXsZt1(FullstuNo0);            //����ѧ���ύ���Ϊ"δ�ύ"
                response.setContentType("text/html;charset=utf8");
                PrintWriter out = response.getWriter();
                out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out.print("alert('�Ѱ�ᣡ');");
                out.print("window.opener.location.reload();");
                out.print("window.close();");
                out.print("</script>");
                break;
            case 15: //ϵѧԺ���쵼�鿴��ͨ���༶��˵������
                String ClassName6 = request.getParameter("className");
                List<Pkrdsqb> list6 = DaoFactory.getPkrdsqbDaoInstance().xxycchakan(ClassName6);  //�鿴��ͨ������Ա��˵�ͬѧ
                request.setAttribute("bjchakan", list6);
                request.getRequestDispatcher("/view/page/Xxyc/Bjchakan.jsp").forward(request, response);
                break;
            case 17: //ϵѧԺ���쵼�ύ�����
                String FullstuNo11 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai4(FullstuNo11);  //�������״̬��ϵѧԺ����ͨ��
                response.setContentType("text/html;charset=utf8");
                PrintWriter out5 = response.getWriter();
                out5.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out5.print("alert('���ύ��ѧ������');");
                out5.print("window.history.go(-1);");
                out5.print("</script>");
                break;
            case 18: //ϵѧԺ���쵼�˻������
                String FullstuNo12 = request.getParameter("fullstuNo");
                String Juti2 = request.getParameter("juti");
                DaoFactory.getPkrdsqbDaoInstance().updateJuti(FullstuNo12, Juti2);   //���ľ������ݣ��˻����ɣ�
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai5(FullstuNo12);    //�������״̬��ϵѧԺ����ͨ��
                DaoFactory.getXsDaoInstance().updateXsZt1(FullstuNo12);              //����ѧ���ύ״̬
                response.setContentType("text/html;charset=utf8");
                PrintWriter out6 = response.getWriter();
                out6.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out6.print("alert('���˻أ�');");
                out6.print("window.opener.location.reload();");
                out6.print("window.close();");
                out6.print("</script>");
                break;
            case 22: //Уѧ�����鿴������ͨ��ϵѧԺ����˵������
                List<Pkrdsqb> list11 = DaoFactory.getPkrdsqbDaoInstance().xxgcchakan(); //�鿴��ͨ��ϵѧԺ����˵�ͬѧ
                request.setAttribute("xgcchakan", list11);
                request.getRequestDispatcher("/view/page/Xxgc/xgcchakan.jsp").forward(request, response);
                break;
            case 23: //Уѧ����ͨ�������
                String FullstuNo15 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai6(FullstuNo15);  //�������״̬
                response.setContentType("text/html;charset=utf8");
                PrintWriter out7 = response.getWriter();
                out7.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out7.print("alert('����ɣ�');");
                out7.print("window.history.go(-1);");
                out7.print("</script>");
                break;
            case 27: //ѧ�����鿴���������ƶ���϶�ѧ��
                List<Pkrdsqb> list20 = DaoFactory.getPkrdsqbDaoInstance().xxgcchakantg();
                request.setAttribute("xgcchakantg", list20);
                request.getRequestDispatcher("/view/page/Xxgc/xgcchakantg.jsp").forward(request, response);
                break;
            //��Ҫҵ�����
            case 19: //����Ա�鿴���������
                List<Pkrdsqb> list9 = DaoFactory.getPkrdsqbDaoInstance().allsqb();
                request.setAttribute("allsqb", list9);
                request.getRequestDispatcher("/view/page/Manager/Sqb/allsqb.jsp").forward(request, response);
                break;
            case 21: //����Ա���ѧ���������Ϣ
                String FullstuNo14 = request.getParameter("fullstuNo");
                List<Pkrdsqb> list10 = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo14);
                request.setAttribute("querysqb", list10);
                request.getRequestDispatcher("/view/page/Manager/Sqb/queryonesqb.jsp").forward(request, response);
                break;
        }
    }

    protected void forward(HttpServletRequest request, HttpServletResponse response, String url) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher(url);
        rd.forward(request, response);
    }

}
