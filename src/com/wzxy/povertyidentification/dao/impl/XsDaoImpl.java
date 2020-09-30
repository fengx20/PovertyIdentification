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

    public int addXs(Xs xs) {                        //���ѧ�����ݽ���xsxx��
        int result = 0;
        try {
            //ʵ����DbUtils�������ݿ�
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();//�����ഴ��statement����SQL���
            //����SQL���
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("INSERT INTO xsxx(stuNo,stuName,sex,className,xueyuan,grade,level,zhuangtai)");
            sqlBuffer.append("VALUES('" + xs.getStuNo() + "'," +
                    "'" + xs.getStuName() + "','" + xs.getSex() + "','" + xs.getClassName() + "'," +
                    "'" + xs.getXueyuan() + "','" + xs.getGrade() + "','" + xs.getLevel() + "','" + xs.getZhuangtai() + "')");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("���ѧ��ʧ��:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int delXs(String StuNo) {                 //ɾ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("DELETE FROM xsxx WHERE stuNo='" + StuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("ɾ��ѧ��ʧ��:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateXs(String StuNo, Xs xs) {      //�޸�
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE xsxx SET stuName='" + xs.getStuName() + "',sex='" + xs.getSex() + "',className='" + xs.getClassName() + "',xueyuan='" + xs.getXueyuan() + "',"
                    + "grade='" + xs.getGrade() + "',level='" + xs.getLevel() + "',zhuangtai='" + xs.getZhuangtai() + "' where stuNo='" + xs.getStuNo() + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸�ѧ����Ϣ����:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateXsZt(String StuNo) {            //�ύ���޸��ύ״̬
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE xsxx SET zhuangtai='���ύ' where stuNo='" + StuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸�ѧ���ύ�������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateXsZt1(String StuNo) {           //�޸�ѧ���ύ״̬Ϊδ�ύ
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE xsxx SET zhuangtai='δ�ύ' where stuNo='" + StuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸�ѧ���ύ�������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Xs> stuList() {                     //ѧ���б�
        List<Xs> list = new ArrayList<Xs>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
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
            System.out.print("��ѯ����ѧ������:" + e.getMessage());
            e.printStackTrace();
        }
        return list;
    }

    public List<Xs> findByStuNo(String StuNo) {     //��ѯ����
        List<Xs> result = new ArrayList<Xs>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
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
            System.out.print("��ѯ��ѧ������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkchongming(String StuNo) {    //�ж�����
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM xsxx WHERE stuNo='" + StuNo + "'");
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

    public boolean checkBjxzlevel(String StuNo) {    //�ж�С���Ա���
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM xsxx WHERE stuNo='" + StuNo + "' AND level='bjxzcy'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                result = rs.getInt("NUM");
            }
        } catch (Exception e) {
            System.out.print("����:" + e.getMessage());
            e.printStackTrace();
        }
        if (result > 0)
            return true;
        else
            return false;
    }

    public boolean checkXstj(String StuNo) {         //�ж�С���Ա���
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM xsxx WHERE stuNo='" + StuNo + "' AND zhuangtai='δ�ύ'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()) {
                result = rs.getInt("NUM");
            }
        } catch (Exception e) {
            System.out.print("����:" + e.getMessage());
            e.printStackTrace();
        }
        if (result > 0)
            return true;
        else
            return false;
    }

}

