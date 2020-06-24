package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Xs;
	

public interface IXsDao {
		
		public int addXs(Xs xs);                    //���ѧ��(����Ա)
		
		public int delXs(String StuNo);             //ɾ�� (����Ա)   
		
		public int updateXs(String StuNo,Xs xs);    //�޸�(����Ա)
		
		public int updateXsZt(String StuNo);        //�޸�ѧ���ύ״̬Ϊ���ύ(ѧ���û�)
		
		public int updateXsZt1(String StuNo);       //�޸�ѧ���ύ״̬Ϊδ�ύ(�鳤������Ա��ϵѧԺ�˻�ʱ)
		
		public List<Xs> findByStuNo(String StuNo);  //ͨ��ѧ�Ų�ѯѧ��
		
		public List<Xs> stuList();                  //ѧ���б�(����Ա)
		
		public boolean checkchongming(String StuNo);//�ж�����
		
		public boolean checkBjxzlevel(String StuNo);//�ж�С���Ա���
		
		public boolean checkXstj(String StuNo);     //ѧ����д�����ʱ�ж�ѧ���Ƿ����ύ

}

