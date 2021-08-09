package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Xs;


public interface IXsDao {

    int addXs(Xs xs);                    //���ѧ��(����Ա)

    int delXs(String StuNo);             //ɾ�� (����Ա)

    int updateXs(String StuNo, Xs xs);    //�޸�(����Ա)

    int updateXsZt(String StuNo);        //�޸�ѧ���ύ״̬Ϊ���ύ(ѧ���û�)

    int updateXsZt1(String StuNo);       //�޸�ѧ���ύ״̬Ϊδ�ύ(�鳤������Ա��ϵѧԺ�˻�ʱ)

    List<Xs> findByStuNo(String StuNo);  //ͨ��ѧ�Ų�ѯѧ��

    List<Xs> stuList();                  //ѧ���б�(����Ա)

    boolean checkchongming(String StuNo);//�ж�����

    boolean checkBjxzlevel(String StuNo);//�ж�С���Ա���

    boolean checkXstj(String StuNo);     //ѧ����д�����ʱ�ж�ѧ���Ƿ����ύ

}

