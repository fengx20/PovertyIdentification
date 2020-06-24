package com.wzxy.povertyidentification.dao.impl;


import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;

import com.wzxy.povertyidentification.dao.IUserLoginDao;
import com.wzxy.povertyidentification.database.DbUtils;


	
public class UserLoginImpl implements IUserLoginDao{
		
		private DbUtils dbUtils;
		
		public UserLoginImpl(){
			this.dbUtils=new DbUtils();
		}
		
		public boolean UserLogin(String User_no, String Password,String Actor) { //登录验证
			boolean flag=false;
			try{
			Connection conn=dbUtils.getConn();
			Statement stmt =conn.createStatement();
			StringBuffer sqlBuffer=new StringBuffer(); 
			sqlBuffer.append("SELECT * FROM user_login WHERE actor='"+Actor+"'AND password='"+Password+"' AND user_no='"+User_no+"' ");
			String sql=sqlBuffer.toString();
			ResultSet rs=stmt.executeQuery(sql);
			if(rs.next()){
				flag=true;
			}	 	
			}catch(Exception e){
				  System.out.print("登录出错:"+e.getMessage());
				  e.printStackTrace();
			 }
			return flag;
		}
		
		public int updatePwd(String User_no,String Password){   //用户修改密码
			int result=0;
			try{
				Connection conn=dbUtils.getConn();//获得数据库连接
				Statement stmt =conn.createStatement();
				StringBuffer sqlBuffer=new StringBuffer(); 
				sqlBuffer.append("UPDATE user_login SET password='"+Password+"' WHERE user_no='"+User_no+"'");
				String sql=sqlBuffer.toString();
				int c=stmt.executeUpdate(sql);
	            result=c;    
			}catch(Exception e){
				System.out.print("修改出错:"+e.getMessage());
				e.printStackTrace();
			 }
			return result;
		}
}

