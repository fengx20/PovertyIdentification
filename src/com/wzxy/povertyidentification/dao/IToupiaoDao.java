package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Toupiao;;

public interface IToupiaoDao {

    int addToupiao(Toupiao tp);                                 //С���¼ʱ���С��ѧ�ź�ѧ��ѧ�Ž���toupiao��

    List<Toupiao> bjxzcychakan(String ClassName, String Bjxzcy); //С����toupiao������ͬ��ͬѧ

    boolean checkzt(String Bjcy, String Xs);                     //�жϸ�С���Ա�Ƿ���ͶƱ

    boolean checkchongming(String Bjxzcy, String Xs);            //���ʱ�жϱ����Ƿ��Ѵ��� ˫��������ֹ��¼ʱ�ظ���ӣ�

    int updatezt(String Bjxzcy, String Xs);                      //���¸ó�Ա�Ը�ѧ��ͶƱ�Ƿ���ͶƱ
}
