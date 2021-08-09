package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Bj;

public interface IBjDao {

    /**
     * 在bjxx表（双主键）里找与该老师工号对应的班级
     * @param TeacherNo
     * @return
     */
    List<Bj> findClassName(String TeacherNo);

}
