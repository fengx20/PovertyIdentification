package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Pkrdsqb;

public interface IPkrdsqbDao {

    int addPkrdsqb(Pkrdsqb sqb);                       //������������(ѧ��)

    List<Pkrdsqb> allsqb();                            //�鿴���������(����Ա)

    List<Pkrdsqb> findByFullstuNo(String FullstuNo);  //ͨ��ѧ�Ų����������

    List<Pkrdsqb> findbyClassName(String ClassName);  //ͨ���༶��ͬ��ѧ��

    List<Pkrdsqb> fdychakan(String ClassName);        //(���״̬��ͬ)����Ա�鿴��ͨ��С����˵�ͬѧ

    List<Pkrdsqb> xxycchakan(String ClassName);       //(���״̬��ͬ)ϵѧԺ���鿴��ͨ������Ա��˵�ͬѧ

    List<Pkrdsqb> xxgcchakan();                       //(���״̬��ͬ)Уѧ�����鿴��ͨ��ϵѧԺ����˵�ͬѧ

    List<Pkrdsqb> xxgcchakantg();                     //(���״̬��ͬ)ѧ�����鿴�����ƶ���϶���ͬѧ

    int updatePkrdsqb(String FullstuNo, Pkrdsqb sqb);  //�������������(ѧ��)

    int updatetongguo(String FullstuNo);              //С���Ա�Ը�ѧ��ͶƱ  ͨ��+1

    int updatefandui(String FullstuNo);               //С���Ա�Ը�ѧ��ͶƱ  ����+1

    int updateTgqingkuang(String ClassName);          //����ͨ�������ͨ����>����������ͨ��

    int updateFdqingkuang(String ClassName);          //���·��������ͨ����<��������δͨ��

    int updatezhuangtai(String FullstuNo);            //�༶С���鳤��,�������״̬(���״̬��ͬ)����ͨ��

    int updatezhuangtai1(String FullstuNo);           //�༶С���鳤��,�������״̬(���״̬��ͬ)��δͨ��

    int updatezhuangtai2(String FullstuNo);           //����Ա��,�������״̬������Աͨ��

    int updatezhuangtai3(String FullstuNo);           //����Ա��,�������״̬������Աδͨ��

    int updatezhuangtai4(String FullstuNo);           //�������״̬��ϵѧԺ����ͨ��

    int updatezhuangtai5(String FullstuNo);           //�������״̬��ϵѧԺ��δͨ��

    int updatezhuangtai6(String FullstuNo);           //�������״̬��Уѧ������ͨ��

    int updatezhuangtai7(String FullstuNo);           //�������״̬��Уѧ����δͨ��

    int updatetoupiao(String FullstuNo);              //�˻غ�����ͶƱ

    int updateJuti(String FullstuNo, String Juti);     //�༶С���鳤 �� ����Ա�����ľ������ݣ��˻����ɣ�

    boolean checkchongming(String FullstuNo);         //�ж�ѧ���Ƿ��ظ������ڣ�

}
