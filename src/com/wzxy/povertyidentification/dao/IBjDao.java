package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Bj;

public interface IBjDao {

    /**
     * ��bjxx��˫���������������ʦ���Ŷ�Ӧ�İ༶
     * @param TeacherNo
     * @return
     */
    List<Bj> findClassName(String TeacherNo);

}
