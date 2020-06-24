package com.wzxy.povertyidentification.database;

import java.sql.*;

public class DbUtils {

	private String  className="com.mysql.cj.jdbc.Driver";
	private String  url="jdbc:mysql://localhost:3306/pkrd_db?useUnicode=true&characterEncoding=utf-8&serverTimezone=Asia/Shanghai&zeroDateTimeBehavior=CONVERT_TO_NULL";
	private String  user="root";
	private String  password="19971114abc";

	public Connection getConn(){
		Connection conn=null;
		try{
			Class.forName(className);
			conn =DriverManager.getConnection(url, user, password);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("连接数据库失败:"+e.getMessage());
		 }
		return conn;
	}

	public void close(ResultSet rs,Statement stmt,Connection conn){
		try{
			if(conn!=null){
				conn.close();
			}
			if(stmt!=null){
				stmt.close();
			}
			if(rs!=null){
				rs.close();
			}
		}catch(SQLException se){
			se.printStackTrace();
	 	 }
	}

	public void close(ResultSet rs){
		   close(rs,null,null);
	}

	public void close(Statement stmt){
		   close(null,stmt,null);
	}

	public void close(Connection conn){
		   close(null,null,conn);
	}

}
