package com.wzxy.povertyidentification.dao;

public interface IUserLoginDao {

    boolean UserLogin(String User_no, String Password, String Actor); //µÇÂ¼ÑéÖ¤

    int updatePwd(String User_no, String Password); //ĞŞ¸ÄÃÜÂë

}
