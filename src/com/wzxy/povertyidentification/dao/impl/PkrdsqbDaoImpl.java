package com.wzxy.povertyidentification.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wzxy.povertyidentification.bean.Pkrdsqb;
import com.wzxy.povertyidentification.dao.IPkrdsqbDao;
import com.wzxy.povertyidentification.database.DbUtils;

public class PkrdsqbDaoImpl implements IPkrdsqbDao {

    private DbUtils dbUtils;

    public PkrdsqbDaoImpl() {
        this.dbUtils = new DbUtils();
    }

    public int addPkrdsqb(Pkrdsqb sqb) {                      //添加数据(学生)
        int result = 0;
        try {
            //实例化DbUtils连接数据库
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();//连接类创建statement创建SQL语句
            //构造SQL语句
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("INSERT INTO pkrdsqbxx(fullstuNo,stuName,sex,birth,idNo,money,xueyuan,className,phoneNum,reason,zhuangtai,tongguo,fandui,qingkuang,juti)");
            sqlBuffer.append("VALUES('" + sqb.getFullstuNo() + "'," +
                    "'" + sqb.getStuName() + "','" + sqb.getSex() + "','" + sqb.getBirth() + "'," +
                    "'" + sqb.getIdNo() + "','" + sqb.getMoney() + "','" + sqb.getXueyuan() + "','" + sqb.getClassName() + "'" +
                    ",'" + sqb.getPhoneNum() + "','" + sqb.getReason() + "','" + sqb.getZhuangtai() + "','" + sqb.getTongguo() + "','" + sqb.getFandui() + "','" + sqb.getQingkuang() + "','" + sqb.getJuti() + "')");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("添加申请表失败:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> allsqb() {                            //查看所有数据，条件：无条件(管理员)
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx ORDER BY fullstuNo");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(rs.getString("fullstuNo"));
                sqb.setStuName(rs.getString("stuName"));
                sqb.setSex(rs.getString("sex"));
                sqb.setBirth(rs.getString("birth"));
                sqb.setIdNo(rs.getString("idNo"));
                sqb.setMoney(rs.getString("money"));
                sqb.setXueyuan(rs.getString("xueyuan"));
                sqb.setClassName(rs.getString("className"));
                sqb.setPhoneNum(rs.getString("phoneNum"));
                sqb.setReason(rs.getString("reason"));
                sqb.setZhuangtai(rs.getString("zhuangtai"));
                result.add(sqb);
            }
        } catch (Exception e) {
            System.out.print("查看申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    public List<Pkrdsqb> findByFullstuNo(String FullstuNo) {  //查询所有字段数据，条件：学号
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(rs.getString("fullstuNo"));
                sqb.setStuName(rs.getString("stuName"));
                sqb.setSex(rs.getString("sex"));
                sqb.setBirth(rs.getString("birth"));
                sqb.setIdNo(rs.getString("idNo"));
                sqb.setMoney(rs.getString("money"));
                sqb.setXueyuan(rs.getString("xueyuan"));
                sqb.setClassName(rs.getString("className"));
                sqb.setPhoneNum(rs.getString("phoneNum"));
                sqb.setReason(rs.getString("reason"));
                sqb.setZhuangtai(rs.getString("zhuangtai"));
                sqb.setTongguo(rs.getInt("tongguo"));
                sqb.setFandui(rs.getInt("fandui"));
                sqb.setQingkuang(rs.getString("qingkuang"));
                sqb.setJuti(rs.getString("juti"));
                result.add(sqb);
            }
        } catch (Exception e) {
            System.out.print("查看申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    public List<Pkrdsqb> findbyClassName(String ClassName) {  //查询所有字段数据，条件：班级     查询以下字段组员查(组长和组员所查的字段不同)
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE className='" + ClassName + "'");  //pkrdsqbxx中可能是16xxxxx班， 管理员导入的xsxx中肯定是标准的专业名称
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(rs.getString("fullstuNo"));
                sqb.setStuName(rs.getString("stuName"));
                sqb.setSex(rs.getString("sex"));
                sqb.setBirth(rs.getString("birth"));
                sqb.setIdNo(rs.getString("idNo"));
                sqb.setMoney(rs.getString("money"));
                sqb.setXueyuan(rs.getString("xueyuan"));
                sqb.setClassName(rs.getString("className"));
                sqb.setPhoneNum(rs.getString("phoneNum"));
                sqb.setReason(rs.getString("reason"));
                sqb.setZhuangtai(rs.getString("zhuangtai"));
                sqb.setTongguo(rs.getInt("tongguo"));
                sqb.setFandui(rs.getInt("fandui"));
                sqb.setQingkuang(rs.getString("qingkuang"));
                sqb.setJuti(rs.getString("juti"));
                result.add(sqb);
            }
        } catch (Exception e) {
            System.out.print("查看班级申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> fdychakan(String ClassName) {        //辅导员查看已通过小组审核的同学
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE className='" + ClassName + "' AND zhuangtai='班级小组通过并已提交，辅导员审核中'");  //pkrdsqbxx中可能是16xxxxx班， 管理员导入的xsxx中肯定是标准的专业名称
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(rs.getString("fullstuNo"));
                sqb.setStuName(rs.getString("stuName"));
                sqb.setXueyuan(rs.getString("xueyuan"));
                sqb.setClassName(rs.getString("className"));
                sqb.setZhuangtai(rs.getString("zhuangtai"));
                result.add(sqb);
            }
        } catch (Exception e) {
            System.out.print("查看班级申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> xxycchakan(String ClassName) {       //系学院处查看已通过辅导员审核的同学
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE className='" + ClassName + "' AND zhuangtai='辅导员已通过，公示五日，提交学院处审核'");  //pkrdsqbxx中可能是16xxxxx班， 管理员导入的xsxx中肯定是标准的专业名称
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(rs.getString("fullstuNo"));
                sqb.setStuName(rs.getString("stuName"));
                sqb.setXueyuan(rs.getString("xueyuan"));
                sqb.setClassName(rs.getString("className"));
                sqb.setZhuangtai(rs.getString("zhuangtai"));
                result.add(sqb);
            }
        } catch (Exception e) {
            System.out.print("查看班级申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> xxgcchakan() {                       //学工处查看已通过系学院处审核的同学
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE zhuangtai='系学院处已通过，校学工处审核中'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(rs.getString("fullstuNo"));
                sqb.setStuName(rs.getString("stuName"));
                sqb.setXueyuan(rs.getString("xueyuan"));
                sqb.setClassName(rs.getString("className"));
                sqb.setZhuangtai(rs.getString("zhuangtai"));
                result.add(sqb);
            }
        } catch (Exception e) {
            System.out.print("查看班级申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> xxgcchakantg() {                     //学工处查看已完成贫困认定的同学
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE zhuangtai='学工处已通过，完成贫困认定'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Pkrdsqb sqb = new Pkrdsqb();
                sqb.setFullstuNo(rs.getString("fullstuNo"));
                sqb.setStuName(rs.getString("stuName"));
                sqb.setXueyuan(rs.getString("xueyuan"));
                sqb.setClassName(rs.getString("className"));
                sqb.setZhuangtai(rs.getString("zhuangtai"));
                result.add(sqb);
            }
        } catch (Exception e) {
            System.out.print("查看班级申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatePkrdsqb(String FullstuNo, Pkrdsqb sqb) {  //学生修改申请表
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET stuName='" + sqb.getStuName() + "',sex='" + sqb.getSex() + "',birth='" + sqb.getBirth() + "'," +
                    "idNo='" + sqb.getIdNo() + "',money='" + sqb.getMoney() + "',xueyuan='" + sqb.getXueyuan() + "',className='" + sqb.getClassName() + "'" +
                    ",phoneNum='" + sqb.getPhoneNum() + "',reason='" + sqb.getReason() + "',zhuangtai='" + sqb.getZhuangtai() + "',tongguo='" + sqb.getTongguo() + "',fandui='" + sqb.getFandui() + "',qingkuang='" + sqb.getQingkuang() + "',juti='" + sqb.getJuti() + "' WHERE fullstuNo='" + sqb.getFullstuNo() + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatetongguo(String FullstuNo) {              //修改通过投票数
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET tongguo=tongguo+1 WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatefandui(String FullstuNo) {               //修改反对投票数
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET fandui=fandui+1 WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateTgqingkuang(String ClassName) {          //更新通过情况，通过数>反对数：已通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET qingkuang='已通过' WHERE className='" + ClassName + "' AND tongguo+fandui=3 AND tongguo>fandui");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateFdqingkuang(String ClassName) {          //更新反对情况，通过数<反对数：未通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET qingkuang='未通过' WHERE className='" + ClassName + "' AND tongguo+fandui=3 AND tongguo<fandui");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai(String FullstuNo) {            //班级小组组长用,更改审核状态
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='班级小组通过并已提交，辅导员审核中' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai1(String FullstuNo) {           //班级贫困小组组长用,更改审核状态，未通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='班级小组未通过已退回' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai2(String FullstuNo) {           //辅导员用,辅导员已通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='辅导员已通过，公示五日，提交学院处审核' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai3(String FullstuNo) {           //辅导员用，未通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='辅导员未通过，已退回' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai4(String FullstuNo) {           //系学院处用，已通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='系学院处已通过，校学工处审核中' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai5(String FullstuNo) {           //系学院处用，未通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='系学院处未通过，已退回辅导员岗' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai6(String FullstuNo) {           //更改审核状态，校学工处已通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='学工处已通过，完成贫困认定' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai7(String FullstuNo) {           //更改审核状态，校学工处未通过
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='学工处未通过，已办结' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatetoupiao(String FullstuNo) {              //退回后重置投票
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET tongguo=0,fandui=0 WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateJuti(String FullstuNo, String Juti) {     //班级小组组长 、 辅导员，更改具体内容（退回理由）
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET juti='" + Juti + "' WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkchongming(String FullstuNo) {         //判断申请表是否重复
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM pkrdsqbxx WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                result = rs.getInt("NUM");
            }
        } catch (Exception e) {
            System.out.print("查重出错:" + e.getMessage());
            e.printStackTrace();
        }
        if (result > 0)
            return true;
        else
            return false;
    }

}
