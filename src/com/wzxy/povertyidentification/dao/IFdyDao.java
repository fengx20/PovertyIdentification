package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Fdy;

public interface IFdyDao {
	
	public int addFdy(Fdy fdy);                         //������ݽ���fdyxx��
	
	public int deleteFdy(String TeacherNo);             //ɾ������
	
	public int updateFdy(String TeacherNo,Fdy fdy);     //�޸�
	
	public List<Fdy>fdyList();                          //��ѯ���� 
	 
	public List<Fdy> findByTeacherNo(String TeacherNo); //��ѯ����
	
	public boolean checkchongming(String TeacherNo);    //�ж�����
	
	

}
