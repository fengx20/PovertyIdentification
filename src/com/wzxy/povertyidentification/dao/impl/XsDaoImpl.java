package com.wzxy.povertyidentification.dao.impl;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;


import com.wzxy.povertyidentification.bean.Xs;
import com.wzxy.povertyidentification.dao.IXsDao;
import com.wzxy.povertyidentification.database.DbUtils;


public class XsDaoImpl implements IXsDao {

    private DbUtils dbUtils;

    public XsDaoImpl() {
        this.dbUtils = new DbUtils();
    }

    public int addXs(Xs xs) {                        //添加学生数据进入xsxx表
        int result = 0;
        try {
            //实例化DbUtils连接数据库
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();//连接类创建statement创建SQL语句
            //构造SQL语句
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("INSERT INTO xsxx(stuNo,stuName,sex,className,xueyuan,grade,level,zhuangtai)");
            sqlBuffer.append("VALUES('" + xs.getStuNo() + "'," +
                    "'" + xs.getStuName() + "','" + xs.getSex() + "','" + xs.getClassName() + "'," +
                    "'" + xs.getXueyuan() + "','" + xs.getGrade() + "','" + xs.getLevel() + "','" + xs.getZhuangtai() + "')");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("添加学生失败:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int delXs(String StuNo) {                 //删除
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("DELETE FROM xsxx WHERE stuNo='" + StuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("删除学生失败:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateXs(String StuNo, Xs xs) {      //修改
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE xsxx SET stuName='" + xs.getStuName() + "',sex='" + xs.getSex() + "',className='" + xs.getClassName() + "',xueyuan='" + xs.getXueyuan() + "',"
                    + "grade='" + xs.getGrade() + "',level='" + xs.getLevel() + "',zhuangtai='" + xs.getZhuangtai() + "' where stuNo='" + xs.getStuNo() + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改学生信息出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateXsZt(String StuNo) {            //提交后修改提交状态
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE xsxx SET zhuangtai='已提交' where stuNo='" + StuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改学生提交情况出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateXsZt1(String StuNo) {           //修改学生提交状态为未提交
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE xsxx SET zhuangtai='未提交' where stuNo='" + StuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改学生提交情况出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Xs> stuList() {                     //学生列表
        List<Xs> list = new ArrayList<Xs>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM xsxx");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Xs xs = new Xs();
                xs.setStuNo(rs.getString("stuNo"));
                xs.setStuName(rs.getString("stuName"));
                xs.setSex(rs.getString("sex"));
                xs.setClassName(rs.getString("className"));
                xs.setXueyuan(rs.getString("xueyuan"));
                xs.setGrade(rs.getString("grade"));
                xs.setLevel(rs.getString("level"));
                xs.setZhuangtai(rs.getString("zhuangtai"));
                list.add(xs);
            }
        } catch (Exception e) {
            System.out.print("查询所有学生出错:" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<Xs> findByStuNo(String StuNo) {     //查询个人
        List<Xs> result = new ArrayList<Xs>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM xsxx WHERE stuNo='" + StuNo + "'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Xs xs = new Xs();
                xs.setStuNo(rs.getString("stuNo"));
                xs.setStuName(rs.getString("stuName"));
                xs.setSex(rs.getString("sex"));
                xs.setClassName(rs.getString("className"));
                xs.setXueyuan(rs.getString("xueyuan"));
                xs.setGrade(rs.getString("grade"));
                xs.setLevel(rs.getString("level"));
                xs.setZhuangtai(rs.getString("zhuangtai"));
                result.add(xs);
            }
        } catch (Exception e) {
            System.out.print("查询该学生出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkchongming(String StuNo) {    //判断重名
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM xsxx WHERE stuNo='" + StuNo + "'");
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

    public boolean checkBjxzlevel(String StuNo) {    //判断小组成员身份
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM xsxx WHERE stuNo='" + StuNo + "' AND level='bjxzcy'");
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

    public boolean checkXstj(String StuNo) {         //判断小组成员身份
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM xsxx WHERE stuNo='" + StuNo + "' AND zhuangtai='未提交'");
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

}

