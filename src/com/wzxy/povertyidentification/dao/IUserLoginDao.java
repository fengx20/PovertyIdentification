package com.wzxy.povertyidentification.dao;

public interface IUserLoginDao {
	
	public boolean UserLogin(String User_no,String Password,String Actor); //µÇÂ¼ÑéÖ¤
	
	public int updatePwd(String User_no,String Password); //ĞŞ¸ÄÃÜÂë
	

}
