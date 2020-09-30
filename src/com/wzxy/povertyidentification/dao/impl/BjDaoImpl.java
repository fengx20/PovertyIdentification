package com.wzxy.povertyidentification.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.wzxy.povertyidentification.bean.Bj;
import com.wzxy.povertyidentification.dao.IBjDao;
import com.wzxy.povertyidentification.database.DbUtils;

public class BjDaoImpl implements IBjDao {

    private DbUtils dbUtils;

    public BjDaoImpl() {
        this.dbUtils = new DbUtils();
    }

    public List<Bj> findClassName(String TeacherNo) {    //在bjxx表（双主键）里找与该老师工号对应的班级
        List<Bj> result = new ArrayList<Bj>();
        try {
            Connection conn = dbUtils.getConn();//获得数据库连接
            Statement stmt = conn.createStatement();
            StringBuffer sqlBuffer = new StringBuffer();
            sqlBuffer.append("SELECT * FROM bjxx WHERE teacherNo='" + TeacherNo + "'");
            String sql = sqlBuffer.toString();
            ResultSet rs = stmt.executeQuery(sql);
            while (rs != null && rs.next()) {
                Bj bj = new Bj();
                bj.setXueyuan(rs.getString("xueyuan"));
                bj.setClassName(rs.getString("className"));
                result.add(bj);
            }
        } catch (Exception e) {
            System.out.print("查看班级申请表出错:" + e.getMessage());
            e.printStackTrace();
        }
        return result;
    }
}
