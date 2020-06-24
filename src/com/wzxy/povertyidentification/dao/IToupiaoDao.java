package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Toupiao;;

public interface IToupiaoDao {
	
	public int addToupiao(Toupiao tp);                                 //小组登录时添加小组学号和学生学号进入toupiao表
	
	public List<Toupiao> bjxzcychakan(String ClassName,String Bjxzcy); //小组在toupiao表里找同班同学
	
	public boolean checkzt(String Bjcy,String Xs);                     //判断该小组成员是否已投票
	
	public boolean checkchongming(String Bjxzcy,String Xs);            //添加时判断表里是否已存在 双主键（防止登录时重复添加）
	
	public int updatezt(String Bjxzcy,String Xs);                      //更新该成员对该学生投票是否已投票
}
