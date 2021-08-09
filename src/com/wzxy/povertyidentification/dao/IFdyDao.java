package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Fdy;

public interface IFdyDao {

    /**
     * 添加数据进入fdyxx表
     * @param fdy
     * @return
     */
    int addFdy(Fdy fdy);

    /**
     * 删除单个
     * @param TeacherNo
     * @return
     */
    int deleteFdy(String TeacherNo);

    /**
     * 修改单个
     * @param TeacherNo
     * @param fdy
     * @return
     */
    int updateFdy(String TeacherNo, Fdy fdy);

    /**
     * 查询所有
     * @return
     */
    List<Fdy> fdyList();

    /**
     * 查询单个
     * @param TeacherNo
     * @return
     */
    List<Fdy> findByTeacherNo(String TeacherNo);

    /**
     * 判断重名
     * @param TeacherNo
     * @return
     */
    boolean checkchongming(String TeacherNo);

}
