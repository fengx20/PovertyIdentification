package com.wzxy.povertyidentification.dao;

public interface IUserLoginDao {
	
	public boolean UserLogin(String User_no,String Password,String Actor); //��¼��֤
	
	public int updatePwd(String User_no,String Password); //�޸�����
	

}
