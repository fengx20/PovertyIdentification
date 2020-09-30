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

    public int addFdy(Fdy fdy) {                                  //��Ӹ���Ա��Ϣ
        int result = 0;
        try {
            //ʵ����DbUtils�������ݿ�
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();//�����ഴ��statement����SQL���
            //����SQL���
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("INSERT INTO fdyxx(teacherNo,teacherName,xueyuan,phoneNum)");
            sqlBuffer.append("VALUES('" + fdy.getTeacherNo() + "'," +
                    "'" + fdy.getTeacherName() + "','" + fdy.getXueyuan() + "','" + fdy.getPhoneNum() + "')");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {

            System.out.print("��Ӹ���Աʧ��:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int deleteFdy(String TeacherNo) {                      //ɾ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("DELETE FROM fdyxx WHERE teacherNo='" + TeacherNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("ɾ������Աʧ��:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateFdy(String TeacherNo, Fdy fdy) {              //�޸�
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE fdyxx SET teacherName='" + fdy.getTeacherName() + "',xueyuan='" + fdy.getXueyuan() + "',phoneNum='" + fdy.getPhoneNum() + "' WHERE teacherNo='" + TeacherNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĸ���Ա����:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Fdy> fdyList() {                                   //��ѯ����
        List<Fdy> list = new ArrayList<Fdy>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
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
            System.out.print("��ѯ���и���Ա����:" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<Fdy> findByTeacherNo(String TeacherNo) {          //������ѯ
        List<Fdy> result = new ArrayList<Fdy>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
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
            System.out.print("��ѯ�ø���Ա����:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkchongming(String TeacherNo) {             //�ж�����
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM fdyxx WHERE teacherNo='" + TeacherNo + "'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                result = rs.getInt("NUM");
            }
        } catch (Exception e) {
            System.out.print("���س���:" + e.getMessage());
            e.printStackTrace();
        }
        if (result > 0)
            return false;
        else
            return true;

    }

}
