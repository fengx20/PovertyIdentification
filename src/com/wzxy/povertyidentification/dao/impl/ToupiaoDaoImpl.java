package com.wzxy.povertyidentification.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wzxy.povertyidentification.bean.Toupiao;
import com.wzxy.povertyidentification.dao.IToupiaoDao;
import com.wzxy.povertyidentification.database.DbUtils;

public class ToupiaoDaoImpl implements IToupiaoDao {

    private DbUtils dbUtils;

    public ToupiaoDaoImpl() {
        this.dbUtils = new DbUtils();
    }

    public int addToupiao(Toupiao tp) {                                    //添加数据进toupiao表
        int result = 0;
        try {
            //实例化DbUtils连接数据库
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();//连接类创建statement创建SQL语句
            //构造SQL语句
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("INSERT INTO toupiao(bjxzcy,xs,xsName,sex,className,xueyuan,zhuangtai)");
            sqlBuffer.append("VALUES('" + tp.getBjxzcy() + "'," +
                    "'" + tp.getXs() + "','" + tp.getXsName() + "','" + tp.getSex() + "','" + tp.getClassName() + "','" + tp.getXueyuan() + "','" + tp.getZhuangtai() + "')");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("添加投票情况失败:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Toupiao> bjxzcychakan(String ClassName, String Bjxzcy) {    //小组查看同班同学投票
        List<Toupiao> result = new ArrayList<Toupiao>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM toupiao WHERE className='" + ClassName + "' AND bjxzcy='" + Bjxzcy + "'");  //pkrdsqbxx中可能是16xxxxx班， 管理员导入的xsxx中肯定是标准的专业名称
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Toupiao tp = new Toupiao();
                tp.setXs(rs.getString("xs"));
                tp.setXsName(rs.getString("xsName"));
                tp.setSex(rs.getString("sex"));
                tp.setClassName(rs.getString("className"));
                tp.setXueyuan(rs.getString("xueyuan"));
                tp.setZhuangtai(rs.getString("zhuangtai"));
                result.add(tp);
            }
        } catch (Exception e) {
            System.out.print("查看班级申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkzt(String Bjxzcy, String Xs) {                     //判断该小组成员是否已投票
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM toupiao WHERE bjxzcy='" + Bjxzcy + "' AND xs='" + Xs + "' AND zhuangtai='未投票'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                result = rs.getInt("NUM");
            }
        } catch (Exception e) {
            System.out.print("出错:" + e.getMessage());
            e.printStackTrace();
        }
        if (result > 0)
            return true;
        else
            return false;
    }

    public boolean checkchongming(String Bjxzcy, String Xs) {              //判断表中是否存在双主键相同
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM toupiao WHERE bjxzcy='" + Bjxzcy + "' AND xs='" + Xs + "'");
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
            return false;
        else
            return true;

    }

    public int updatezt(String Bjxzcy, String Xs) {                        //更新该成员对该学生投票是否已投票
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE toupiao SET zhuangtai='已投票' WHERE bjxzcy='" + Bjxzcy + "' AND xs='" + Xs + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
	    
