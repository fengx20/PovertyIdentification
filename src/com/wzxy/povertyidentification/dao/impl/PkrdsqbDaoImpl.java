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

    public int addPkrdsqb(Pkrdsqb sqb) {                      //�������(ѧ��)
        int result = 0;
        try {
            //ʵ����DbUtils�������ݿ�
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();//�����ഴ��statement����SQL���
            //����SQL���
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
            System.out.print("��������ʧ��:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> allsqb() {                            //�鿴�������ݣ�������������(����Ա)
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
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
            System.out.print("�鿴��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    public List<Pkrdsqb> findByFullstuNo(String FullstuNo) {  //��ѯ�����ֶ����ݣ�������ѧ��
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
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
            System.out.print("�鿴��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;

    }

    public List<Pkrdsqb> findbyClassName(String ClassName) {  //��ѯ�����ֶ����ݣ��������༶     ��ѯ�����ֶ���Ա��(�鳤����Ա������ֶβ�ͬ)
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE className='" + ClassName + "'");  //pkrdsqbxx�п�����16xxxxx�࣬ ����Ա�����xsxx�п϶��Ǳ�׼��רҵ����
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
            System.out.print("�鿴�༶��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> fdychakan(String ClassName) {        //����Ա�鿴��ͨ��С����˵�ͬѧ
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE className='" + ClassName + "' AND zhuangtai='�༶С��ͨ�������ύ������Ա�����'");  //pkrdsqbxx�п�����16xxxxx�࣬ ����Ա�����xsxx�п϶��Ǳ�׼��רҵ����
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
            System.out.print("�鿴�༶��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> xxycchakan(String ClassName) {       //ϵѧԺ���鿴��ͨ������Ա��˵�ͬѧ
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE className='" + ClassName + "' AND zhuangtai='����Ա��ͨ������ʾ���գ��ύѧԺ�����'");  //pkrdsqbxx�п�����16xxxxx�࣬ ����Ա�����xsxx�п϶��Ǳ�׼��רҵ����
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
            System.out.print("�鿴�༶��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> xxgcchakan() {                       //ѧ�����鿴��ͨ��ϵѧԺ����˵�ͬѧ
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE zhuangtai='ϵѧԺ����ͨ����Уѧ���������'");
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
            System.out.print("�鿴�༶��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public List<Pkrdsqb> xxgcchakantg() {                     //ѧ�����鿴�����ƶ���϶���ͬѧ
        List<Pkrdsqb> result = new ArrayList<Pkrdsqb>();
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM pkrdsqbxx WHERE zhuangtai='ѧ������ͨ�������ƶ���϶�'");
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
            System.out.print("�鿴�༶��������:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatePkrdsqb(String FullstuNo, Pkrdsqb sqb) {  //ѧ���޸������
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET stuName='" + sqb.getStuName() + "',sex='" + sqb.getSex() + "',birth='" + sqb.getBirth() + "'," +
                    "idNo='" + sqb.getIdNo() + "',money='" + sqb.getMoney() + "',xueyuan='" + sqb.getXueyuan() + "',className='" + sqb.getClassName() + "'" +
                    ",phoneNum='" + sqb.getPhoneNum() + "',reason='" + sqb.getReason() + "',zhuangtai='" + sqb.getZhuangtai() + "',tongguo='" + sqb.getTongguo() + "',fandui='" + sqb.getFandui() + "',qingkuang='" + sqb.getQingkuang() + "',juti='" + sqb.getJuti() + "' WHERE fullstuNo='" + sqb.getFullstuNo() + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatetongguo(String FullstuNo) {              //�޸�ͨ��ͶƱ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET tongguo=tongguo+1 WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatefandui(String FullstuNo) {               //�޸ķ���ͶƱ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET fandui=fandui+1 WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateTgqingkuang(String ClassName) {          //����ͨ�������ͨ����>����������ͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET qingkuang='��ͨ��' WHERE className='" + ClassName + "' AND tongguo+fandui=3 AND tongguo>fandui");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateFdqingkuang(String ClassName) {          //���·��������ͨ����<��������δͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET qingkuang='δͨ��' WHERE className='" + ClassName + "' AND tongguo+fandui=3 AND tongguo<fandui");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai(String FullstuNo) {            //�༶С���鳤��,�������״̬
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='�༶С��ͨ�������ύ������Ա�����' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai1(String FullstuNo) {           //�༶ƶ��С���鳤��,�������״̬��δͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='�༶С��δͨ�����˻�' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai2(String FullstuNo) {           //����Ա��,����Ա��ͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='����Ա��ͨ������ʾ���գ��ύѧԺ�����' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai3(String FullstuNo) {           //����Ա�ã�δͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='����Աδͨ�������˻�' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai4(String FullstuNo) {           //ϵѧԺ���ã���ͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='ϵѧԺ����ͨ����Уѧ���������' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai5(String FullstuNo) {           //ϵѧԺ���ã�δͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='ϵѧԺ��δͨ�������˻ظ���Ա��' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai6(String FullstuNo) {           //�������״̬��Уѧ������ͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='ѧ������ͨ�������ƶ���϶�' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatezhuangtai7(String FullstuNo) {           //�������״̬��Уѧ����δͨ��
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET zhuangtai='ѧ����δͨ�����Ѱ��' WHERE fullstuNo='" + FullstuNo + "' ");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updatetoupiao(String FullstuNo) {              //�˻غ�����ͶƱ
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET tongguo=0,fandui=0 WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public int updateJuti(String FullstuNo, String Juti) {     //�༶С���鳤 �� ����Ա�����ľ������ݣ��˻����ɣ�
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("UPDATE pkrdsqbxx SET juti='" + Juti + "' WHERE fullstuNo='" + FullstuNo + "'");
            String sql = sqlBuffer.toString();
            int c = stmt.executeUpdate(sql);
            result = c;
        } catch (Exception e) {
            System.out.print("�޸ĳ���:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }

    public boolean checkchongming(String FullstuNo) {         //�ж�������Ƿ��ظ�
        int result = 0;
        try {
            Connection conn = dbUtils.getConn();//������ݿ�����
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT count(*) AS NUM FROM pkrdsqbxx WHERE fullstuNo='" + FullstuNo + "'");
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
            return true;
        else
            return false;
    }

}
