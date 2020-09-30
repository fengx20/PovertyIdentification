package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Bj;

public interface IBjDao {

    public List<Bj> findClassName(String TeacherNo);  //在bjxx表（双主键）里找与该老师工号对应的班级


}
