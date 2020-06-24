package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Pkrdsqb;

public interface IPkrdsqbDao {
	
	public int addPkrdsqb(Pkrdsqb sqb);                      //������������(ѧ��)
	
	public List<Pkrdsqb>allsqb();                            //�鿴���������(����Ա)
	
	public List<Pkrdsqb> findByFullstuNo(String FullstuNo);  //ͨ��ѧ�Ų����������
	
	public List<Pkrdsqb> findbyClassName(String ClassName);  //ͨ���༶��ͬ��ѧ��
	
	public List<Pkrdsqb> fdychakan(String ClassName);        //(���״̬��ͬ)����Ա�鿴��ͨ��С����˵�ͬѧ
	
	public List<Pkrdsqb> xxycchakan(String ClassName);       //(���״̬��ͬ)ϵѧԺ���鿴��ͨ������Ա��˵�ͬѧ
	
	public List<Pkrdsqb> xxgcchakan();                       //(���״̬��ͬ)Уѧ�����鿴��ͨ��ϵѧԺ����˵�ͬѧ
	
	public List<Pkrdsqb> xxgcchakantg();                     //(���״̬��ͬ)ѧ�����鿴�����ƶ���϶���ͬѧ    
	
	public int updatePkrdsqb(String FullstuNo,Pkrdsqb sqb);  //�������������(ѧ��)
	
	public int updatetongguo(String FullstuNo);              //С���Ա�Ը�ѧ��ͶƱ  ͨ��+1
	
	public int updatefandui(String FullstuNo);               //С���Ա�Ը�ѧ��ͶƱ  ����+1
	
	public int updateTgqingkuang(String ClassName);          //����ͨ�������ͨ����>����������ͨ��
	
	public int updateFdqingkuang(String ClassName);          //���·��������ͨ����<��������δͨ��
	
	public int updatezhuangtai(String FullstuNo);            //�༶С���鳤��,�������״̬(���״̬��ͬ)����ͨ��
	
	public int updatezhuangtai1(String FullstuNo);           //�༶С���鳤��,�������״̬(���״̬��ͬ)��δͨ��
	
	public int updatezhuangtai2(String FullstuNo);           //����Ա��,�������״̬������Աͨ��
	
	public int updatezhuangtai3(String FullstuNo);           //����Ա��,�������״̬������Աδͨ��
	
	public int updatezhuangtai4(String FullstuNo);           //�������״̬��ϵѧԺ����ͨ��
	
	public int updatezhuangtai5(String FullstuNo);           //�������״̬��ϵѧԺ��δͨ��
	
    public int updatezhuangtai6(String FullstuNo);           //�������״̬��Уѧ������ͨ��
	
	public int updatezhuangtai7(String FullstuNo);           //�������״̬��Уѧ����δͨ��
	
	public int updatetoupiao(String FullstuNo);              //�˻غ�����ͶƱ
	
	public int updateJuti(String FullstuNo,String Juti);     //�༶С���鳤 �� ����Ա�����ľ������ݣ��˻����ɣ�
	
	public boolean checkchongming(String FullstuNo);         //�ж�ѧ���Ƿ��ظ������ڣ�
	
}
