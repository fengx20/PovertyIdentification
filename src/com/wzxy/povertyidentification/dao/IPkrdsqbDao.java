package com.wzxy.povertyidentification.dao;

import java.util.List;

import com.wzxy.povertyidentification.bean.Pkrdsqb;

public interface IPkrdsqbDao {

    public int addPkrdsqb(Pkrdsqb sqb);                      //添加申请表数据(学生)

    public List<Pkrdsqb> allsqb();                            //查看所有申请表(管理员)

    public List<Pkrdsqb> findByFullstuNo(String FullstuNo);  //通过学号查申请表数据

    public List<Pkrdsqb> findbyClassName(String ClassName);  //通过班级查同班学生

    public List<Pkrdsqb> fdychakan(String ClassName);        //(审核状态不同)辅导员查看已通过小组审核的同学

    public List<Pkrdsqb> xxycchakan(String ClassName);       //(审核状态不同)系学院处查看已通过辅导员审核的同学

    public List<Pkrdsqb> xxgcchakan();                       //(审核状态不同)校学工处查看已通过系学院处审核的同学

    public List<Pkrdsqb> xxgcchakantg();                     //(审核状态不同)学工处查看已完成贫困认定的同学

    public int updatePkrdsqb(String FullstuNo, Pkrdsqb sqb);  //更新申请表数据(学生)

    public int updatetongguo(String FullstuNo);              //小组成员对该学号投票  通过+1

    public int updatefandui(String FullstuNo);               //小组成员对该学号投票  反对+1

    public int updateTgqingkuang(String ClassName);          //更新通过情况，通过数>反对数：已通过

    public int updateFdqingkuang(String ClassName);          //更新反对情况，通过数<反对数：未通过

    public int updatezhuangtai(String FullstuNo);            //班级小组组长用,更改审核状态(审核状态不同)，已通过

    public int updatezhuangtai1(String FullstuNo);           //班级小组组长用,更改审核状态(审核状态不同)，未通过

    public int updatezhuangtai2(String FullstuNo);           //辅导员用,更改审核状态，辅导员通过

    public int updatezhuangtai3(String FullstuNo);           //辅导员用,更改审核状态，辅导员未通过

    public int updatezhuangtai4(String FullstuNo);           //更改审核状态，系学院处已通过

    public int updatezhuangtai5(String FullstuNo);           //更改审核状态，系学院处未通过

    public int updatezhuangtai6(String FullstuNo);           //更改审核状态，校学工处已通过

    public int updatezhuangtai7(String FullstuNo);           //更改审核状态，校学工处未通过

    public int updatetoupiao(String FullstuNo);              //退回后重置投票

    public int updateJuti(String FullstuNo, String Juti);     //班级小组组长 、 辅导员，更改具体内容（退回理由）

    public boolean checkchongming(String FullstuNo);         //判断学号是否重复（存在）

}
