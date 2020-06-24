package com.wzxy.povertyidentification.bean;

public class UserLogin {
	
	private String user_no;
	private String password;
	private String actor;
	
	public UserLogin(){
		
	}
	
	public String getUser_no(){
		return user_no;
	}
	
	public void setUser_no(String user_no) {
		this.user_no = user_no;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

}
