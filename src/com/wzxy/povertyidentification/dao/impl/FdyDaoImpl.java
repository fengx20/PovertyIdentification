package com.wzxy.povertyidentification.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import com.wzxy.povertyidentification.bean.Fdy;
import com.wzxy.povertyidentification.dao.IFdyDao;
import com.wzxy.povertyidentification.database.DbUtils;

public class FdyDaoImpl implements IFdyDao {

    private DbUtils dbUtils;

    public FdyDaoImpl() {
        this.dbUtils = new DbUtils();
    }

    public int addFdy(Fdy fdy) {                                  //添加辅导员信息
        int result = 0;
        try {
            //实例化DbUtils连接数据库
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();//连接类创建statement创建SQL语句
            //构造SQL语句
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("INSERT INTO fdyxx(teacherNo,teacherName,xueyuan,phoneNum)");
            sqlBuffer.append("VALUES('" + fdy.getTeacherNo() + "'," +
                    "'" + fdy.getTeacherName() + "','" + fdy.getXueyuan() + "','" + fdy.getPhoneNum() + "')");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {

            System.out.print("添加辅导员失败:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int deleteFdy(String TeacherNo) {                      //删除
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("DELETE FROM fdyxx WHERE teacherNo='" + TeacherNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("删除辅导员失败:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateFdy(String TeacherNo, Fdy fdy) {              //修改
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE fdyxx SET teacherName='" + fdy.getTeacherName() + "',xueyuan='" + fdy.getXueyuan() + "',phoneNum='" + fdy.getPhoneNum() + "' WHERE teacherNo='" + TeacherNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("修改辅导员出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Fdy> fdyList() {                                   //查询所有
        List<Fdy> list = new ArrayList<Fdy>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM fdyxx ORDER BY teacherNo");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Fdy fdy = new Fdy();
                fdy.setTeacherNo(rs.getString("teacherNo"));
                fdy.setTeacherName(rs.getString("teacherName"));
                fdy.setXueyuan(rs.getString("xueyuan"));
                fdy.setPhoneNum(rs.getString("phoneNum"));
                list.add(fdy);
            }
        } catch (Exception e) {
            System.out.print("查询所有辅导员出错:" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<Fdy> findByTeacherNo(String TeacherNo) {          //单个查询
        List<Fdy> result = new ArrayList<Fdy>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM fdyxx WHERE teacherNo='" + TeacherNo + "'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Fdy fdy = new Fdy();
                fdy.setTeacherNo(rs.getString("teacherNo"));
                fdy.setTeacherName(rs.getString("teacherName"));
                fdy.setXueyuan(rs.getString("xueyuan"));
                fdy.setPhoneNum(rs.getString("phoneNum"));
                result.add(fdy);
            }
        } catch (Exception e) {
            System.out.print("查询该辅导员出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkchongming(String TeacherNo) {             //判断重名
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM fdyxx WHERE teacherNo='" + TeacherNo + "'");
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

}
