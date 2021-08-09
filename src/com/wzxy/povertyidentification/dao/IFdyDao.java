package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Fdy;

public interface IFdyDao {

    /**
     * ������ݽ���fdyxx��
     * @param fdy
     * @return
     */
    int addFdy(Fdy fdy);

    /**
     * ɾ������
     * @param TeacherNo
     * @return
     */
    int deleteFdy(String TeacherNo);

    /**
     * �޸ĵ���
     * @param TeacherNo
     * @param fdy
     * @return
     */
    int updateFdy(String TeacherNo, Fdy fdy);

    /**
     * ��ѯ����
     * @return
     */
    List<Fdy> fdyList();

    /**
     * ��ѯ����
     * @param TeacherNo
     * @return
     */
    List<Fdy> findByTeacherNo(String TeacherNo);

    /**
     * �ж�����
     * @param TeacherNo
     * @return
     */
    boolean checkchongming(String TeacherNo);

}
