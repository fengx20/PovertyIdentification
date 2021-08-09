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
            case 25: //学生填写申请表前判断(逻辑)
                String FullstuNo20 = request.getParameter("fullstuNo");
                if (DaoFactory.getXsDaoInstance().checkXstj(FullstuNo20)) {
                    request.getRequestDispatcher("/view/page/Xs/Pkrdsqb.jsp").forward(request, response);
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('你已提交申请表，请去查看审核状态！');");
                    out.print("history.go(-1);");
                    out.print("</script>");
                }
                return;
            case 1: //学生填写申请表提交功能(学生用户)
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
                if (!DaoFactory.getPkrdsqbDaoInstance().checkchongming(FullstuNo)) {     //判断pkrdsqbxx表有无此学号数据
                    DaoFactory.getPkrdsqbDaoInstance().addPkrdsqb(sqb);                          //第一次填写做添加数据操作
                    DaoFactory.getXsDaoInstance().updateXsZt(FullstuNo);                                 //提交更改学生提交状态
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('提交成功，请等待审核，期间不可再提交！');");
                    out.print("history.go(-2)");
                    out.print("</script>");
                } else {
                    DaoFactory.getPkrdsqbDaoInstance().updatePkrdsqb(FullstuNo, sqb);
                    DaoFactory.getXsDaoInstance().updateXsZt(FullstuNo);                            //被退回第二次提交做修改数据操作
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('提交成功，请等待审核，期间不可再提交！');");
                    out.print("history.go(-2)");
                    out.print("</script>");
                }
                break;
            case 2: //学生提交申请表后查看申请表审核状态功能(学生用户)
                String FullstuNo1 = request.getParameter("fullstuNo");
                if (DaoFactory.getPkrdsqbDaoInstance().checkchongming(FullstuNo1) == true) {   //该学号在申请表信息存在
                    List<Pkrdsqb> list = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo1); //根据学号找到数据
                    request.setAttribute("sqb", list);
                    request.getRequestDispatcher("/view/page/Xs/chakan.jsp").forward(request, response);
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('你还未填写贫困认定申请表，请去填写');");
                    out.print("history.back();");
                    out.print("</script>");
                }
                break;
            case 24: //学生查看消息(退回理由)功能(学生用户)
                String FullstuNo19 = request.getParameter("fullstuNo");
                List<Pkrdsqb> list14 = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo19);
                request.setAttribute("jutixx", list14);
                request.getRequestDispatcher("/view/page/Xs/jutixx.jsp").forward(request, response);
                break;
            case 4: //小组成员在toupiao表里查看同班已提交的（从pkrdsqbxx表里添加的）同学
                String ClassName2 = request.getParameter("className");
                String BjcystuNo = request.getParameter("bjcystuNo");
                List<Toupiao> list1 = DaoFactory.getToupiaoDaoInstance().bjxzcychakan(ClassName2, BjcystuNo);    //查与bjcy对应的班，该成员对本班进行投票，  用toupiao（双主键）的数据， 实现一人对多人投票
                request.setAttribute("bbxs_ytj", list1);
                request.setAttribute("bjcystuNo", BjcystuNo);
                request.getRequestDispatcher("/view/page/Bjxz/Chakan.jsp").forward(request, response);
                break;
            case 5: //小组成员查看该学生申请表
                String BjcystuNo1 = request.getParameter("bjcystuNo");
                String FullstuNo3 = request.getParameter("fullstuNo");
                List<Pkrdsqb> list3 = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo3);    //通过学号在pkrdsqbxx找该学号申请表
                request.setAttribute("cksqb", list3);
                request.setAttribute("bjcystuNo", BjcystuNo1);
                request.getRequestDispatcher("/view/page/Bjxz/Toupiao.jsp").forward(request, response);
                break;
            case 6: //小组成员投票传投票值到数据库　　　
                String FullstuNo4 = request.getParameter("fullstuNo");
                String BjcystuNo2 = request.getParameter("bjcystuNo");
                String Toupiao = request.getParameter("toupiao");
                if (DaoFactory.getToupiaoDaoInstance().checkzt(BjcystuNo2, FullstuNo4)) {   //判断该小组成员是否已投票，没投就可以投， 投了的就不能投
                    if ("tongguo".equals(Toupiao)) {
                        DaoFactory.getPkrdsqbDaoInstance().updatetongguo(FullstuNo4);             //修改通过投票数
                    } else {
                        DaoFactory.getPkrdsqbDaoInstance().updatefandui(FullstuNo4);              //修改反对投票数
                    }
                    DaoFactory.getToupiaoDaoInstance().updatezt(BjcystuNo2, FullstuNo4);  //进行了投票操作就要更改 toupiao 里学生被投票情况
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('投票成功！');");
                    out.print("window.history.go(-2);");
                    out.print("</script>");
                } else {
                    response.setContentType("text/html;charset=utf8");
                    PrintWriter out = response.getWriter();
                    out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                    out.print("alert('投票失败，此份申请你已投票！');");
                    out.print("window.history.go(-2);");
                    out.print("</script>");
                }
                break;
            case 7: //组长查看情况 并提交辅导员岗 或 退回学生
                String ClassName4 = request.getParameter("className");
                DaoFactory.getPkrdsqbDaoInstance().updateTgqingkuang(ClassName4); //对票数和为3并且通过大于反对数则改为  已通过   更新最新情况  组长登录点击查看看到的便是最新情况
                DaoFactory.getPkrdsqbDaoInstance().updateFdqingkuang(ClassName4); //相反
                List<Pkrdsqb> list2 = DaoFactory.getPkrdsqbDaoInstance().findbyClassName(ClassName4); ////查与小组组长同班的同学
                request.setAttribute("tpqingkuang", list2);
                request.getRequestDispatcher("/view/page/Bjxz/ZzChakan.jsp").forward(request, response);
                break;
            case 8: //组长提交已通过申请
                String FullstuNo5 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai(FullstuNo5); //班级小组组长用,更改审核状态，已通过
                response.setContentType("text/html;charset=utf8");
                PrintWriter out1 = response.getWriter();
                out1.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out1.print("alert('已提交！');");
                out1.print("window.history.go(-1);");
                out1.print("</script>");
                break;
            case 13: //班级小组组长退回申请表
                String FullstuNo9 = request.getParameter("fullstuNo");
                String Juti1 = request.getParameter("juti");
                DaoFactory.getPkrdsqbDaoInstance().updateJuti(FullstuNo9, Juti1); //更改（退回）具体内容
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai1(FullstuNo9);  //班级贫困小组组长用,更改审核状态，未通过
                DaoFactory.getXsDaoInstance().updateXsZt1(FullstuNo9);            //更改学生提交申请表情况
                response.setContentType("text/html;charset=utf8");
                PrintWriter out4 = response.getWriter();
                out4.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out4.print("alert('已退回！');");
                out4.print("window.opener.location.reload();");
                out4.print("window.close();");
                out4.print("</script>");
                break;
            case 9: //辅导员查看所带班级已通过的申请表
                String ClassName5 = request.getParameter("className");
                List<Pkrdsqb> list4 = DaoFactory.getPkrdsqbDaoInstance().fdychakan(ClassName5);  //在bjxx表（双主键）里找与该老师工号对应的班级
                request.setAttribute("bjchakan", list4);
                request.getRequestDispatcher("/view/page/Fdy/BjChakan.jsp").forward(request, response);
                break;
            case 26: //(公共)辅导员/系领导查看班级所有申请情况
                String ClassName26 = request.getParameter("className");
                List<Pkrdsqb> list26 = DaoFactory.getPkrdsqbDaoInstance().findbyClassName(ClassName26);  //在bjxx表（双主键）里找与该老师工号对应的班级 来找该班所有申请表
                request.setAttribute("bjchakan", list26);
                request.getRequestDispatcher("/ClassAll.jsp").forward(request, response);
                break;
            case 12: //(公共)小组组长/辅导员/系领导/学工处查看班级个人申请表
                String FullstuNo8 = request.getParameter("fullstuNo");
                List<Pkrdsqb> list5 = DaoFactory.getPkrdsqbDaoInstance().findByFullstuNo(FullstuNo8);
                request.setAttribute("cksqb", list5);
                request.getRequestDispatcher("/Cksqb.jsp").forward(request, response);
                break;
            case 11: //辅导员提交至学院处
                String FullstuNo7 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai2(FullstuNo7);  //修改审核状态
                response.setContentType("text/html;charset=utf8");
                PrintWriter out3 = response.getWriter();
                out3.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out3.print("alert('已提交至学院处！');");
                out3.print("window.history.go(-1);");
                out3.print("</script>");
                break;
            //13 14不一样，审核状态修改不一样
            case 14: //辅导员填写退回理由
                String FullstuNo0 = request.getParameter("fullstuNo");
                String Juti = request.getParameter("juti");
                DaoFactory.getPkrdsqbDaoInstance().updateJuti(FullstuNo0, Juti);  //更改具体内容（退回理由）
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai3(FullstuNo0);  //更该审核状态(审核状态与小组组长不一样)
                DaoFactory.getXsDaoInstance().updateXsZt1(FullstuNo0);            //更改学生提交情况为"未提交"
                response.setContentType("text/html;charset=utf8");
                PrintWriter out = response.getWriter();
                out.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out.print("alert('已办结！');");
                out.print("window.opener.location.reload();");
                out.print("window.close();");
                out.print("</script>");
                break;
            case 15: //系学院处领导查看已通过班级审核的申请表
                String ClassName6 = request.getParameter("className");
                List<Pkrdsqb> list6 = DaoFactory.getPkrdsqbDaoInstance().xxycchakan(ClassName6);  //查看已通过辅导员审核的同学
                request.setAttribute("bjchakan", list6);
                request.getRequestDispatcher("/view/page/Xxyc/Bjchakan.jsp").forward(request, response);
                break;
            case 17: //系学院处领导提交申请表
                String FullstuNo11 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai4(FullstuNo11);  //更改审核状态，系学院处已通过
                response.setContentType("text/html;charset=utf8");
                PrintWriter out5 = response.getWriter();
                out5.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out5.print("alert('已提交至学工处！');");
                out5.print("window.history.go(-1);");
                out5.print("</script>");
                break;
            case 18: //系学院处领导退回申请表
                String FullstuNo12 = request.getParameter("fullstuNo");
                String Juti2 = request.getParameter("juti");
                DaoFactory.getPkrdsqbDaoInstance().updateJuti(FullstuNo12, Juti2);   //更改具体内容（退回理由）
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai5(FullstuNo12);    //更改审核状态，系学院处已通过
                DaoFactory.getXsDaoInstance().updateXsZt1(FullstuNo12);              //更改学生提交状态
                response.setContentType("text/html;charset=utf8");
                PrintWriter out6 = response.getWriter();
                out6.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out6.print("alert('已退回！');");
                out6.print("window.opener.location.reload();");
                out6.print("window.close();");
                out6.print("</script>");
                break;
            case 22: //校学工处查看所有已通过系学院处审核的申请表
                List<Pkrdsqb> list11 = DaoFactory.getPkrdsqbDaoInstance().xxgcchakan(); //查看已通过系学院处审核的同学
                request.setAttribute("xgcchakan", list11);
                request.getRequestDispatcher("/view/page/Xxgc/xgcchakan.jsp").forward(request, response);
                break;
            case 23: //校学工处通过申请表
                String FullstuNo15 = request.getParameter("fullstuNo");
                DaoFactory.getPkrdsqbDaoInstance().updatezhuangtai6(FullstuNo15);  //更改审核状态
                response.setContentType("text/html;charset=utf8");
                PrintWriter out7 = response.getWriter();
                out7.print("<script type='text/javascript' charset='utf-8' language='javascript'>");
                out7.print("alert('已完成！');");
                out7.print("window.history.go(-1);");
                out7.print("</script>");
                break;
            case 27: //学工处查看所有已完成贫困认定学生
                List<Pkrdsqb> list20 = DaoFactory.getPkrdsqbDaoInstance().xxgcchakantg();
                request.setAttribute("xgcchakantg", list20);
                request.getRequestDispatcher("/view/page/Xxgc/xgcchakantg.jsp").forward(request, response);
                break;
            //主要业务结束
            case 19: //管理员查看所有申请表
                List<Pkrdsqb> list9 = DaoFactory.getPkrdsqbDaoInstance().allsqb();
                request.setAttribute("allsqb", list9);
                request.getRequestDispatcher("/view/page/Manager/Sqb/allsqb.jsp").forward(request, response);
                break;
            case 21: //管理员查该学号申请表信息
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
