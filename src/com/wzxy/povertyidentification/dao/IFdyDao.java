package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Fdy;

public interface IFdyDao {
	
	public int addFdy(Fdy fdy);                         //添加数据进入fdyxx表
	
	public int deleteFdy(String TeacherNo);             //删除单个
	
	public int updateFdy(String TeacherNo,Fdy fdy);     //修改
	
	public List<Fdy>fdyList();                          //查询所有 
	 
	public List<Fdy> findByTeacherNo(String TeacherNo); //查询单个
	
	public boolean checkchongming(String TeacherNo);    //判断重名
	
	

}
