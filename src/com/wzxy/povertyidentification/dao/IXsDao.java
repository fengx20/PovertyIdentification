package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Xs;
	

public interface IXsDao {
		
		public int addXs(Xs xs);                    //添加学生(管理员)
		
		public int delXs(String StuNo);             //删除 (管理员)   
		
		public int updateXs(String StuNo,Xs xs);    //修改(管理员)
		
		public int updateXsZt(String StuNo);        //修改学生提交状态为已提交(学生用户)
		
		public int updateXsZt1(String StuNo);       //修改学生提交状态为未提交(组长、辅导员、系学院退回时)
		
		public List<Xs> findByStuNo(String StuNo);  //通过学号查询学生
		
		public List<Xs> stuList();                  //学生列表(管理员)
		
		public boolean checkchongming(String StuNo);//判断重名
		
		public boolean checkBjxzlevel(String StuNo);//判断小组成员身份
		
		public boolean checkXstj(String StuNo);     //学生填写申请表时判断学生是否已提交

}

