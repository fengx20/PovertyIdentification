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

    public int addToupiao(Toupiao tp) {                                    //������ݽ�toupiao��
        int result = 0;
        try {
            //ʵ����DbUtils�������ݿ�
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();//�����ഴ��statement����SQL���
            //����SQL���
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("INSERT INTO toupiao(bjxzcy,xs,xsName,sex,className,xueyuan,zhuangtai)");
            sqlBuffer.append("VALUES('" + tp.getBjxzcy() + "'," +
                    "'" + tp.getXs() + "','" + tp.getXsName() + "','" + tp.getSex() + "','" + tp.getClassName() + "','" + tp.getXueyuan() + "','" + tp.getZhuangtai() + "')");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("���ͶƱ���ʧ��:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Toupiao> bjxzcychakan(String ClassName, String Bjxzcy) {    //С��鿴ͬ��ͬѧͶƱ
        List<Toupiao> result = new ArrayList<Toupiao>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM toupiao WHERE className='" + ClassName + "' AND bjxzcy='" + Bjxzcy + "'");  //pkrdsqbxx�п�����16xxxxx�࣬ ����Ա�����xsxx�п϶��Ǳ�׼��רҵ����
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
            System.out.print("�鿴�༶��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkzt(String Bjxzcy, String Xs) {                     //�жϸ�С���Ա�Ƿ���ͶƱ
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM toupiao WHERE bjxzcy='" + Bjxzcy + "' AND xs='" + Xs + "' AND zhuangtai='δͶƱ'");
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

    public boolean checkchongming(String Bjxzcy, String Xs) {              //�жϱ����Ƿ����˫������ͬ
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM toupiao WHERE bjxzcy='" + Bjxzcy + "' AND xs='" + Xs + "'");
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

    public int updatezt(String Bjxzcy, String Xs) {                        //���¸ó�Ա�Ը�ѧ��ͶƱ�Ƿ���ͶƱ
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE toupiao SET zhuangtai='��ͶƱ' WHERE bjxzcy='" + Bjxzcy + "' AND xs='" + Xs + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
	    
