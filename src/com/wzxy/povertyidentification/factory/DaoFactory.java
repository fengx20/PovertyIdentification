package com.wzxy.povertyidentification.factory;

import com.wzxy.povertyidentification.dao.impl.BjDaoImpl;
import com.wzxy.povertyidentification.dao.impl.PkrdsqbDaoImpl;
import com.wzxy.povertyidentification.dao.impl.ToupiaoDaoImpl;
import com.wzxy.povertyidentification.dao.impl.UserLoginImpl;
import com.wzxy.povertyidentification.dao.impl.XsDaoImpl;
import com.wzxy.povertyidentification.dao.impl.FdyDaoImpl;
import com.wzxy.povertyidentification.dao.IBjDao;
import com.wzxy.povertyidentification.dao.IPkrdsqbDao;
import com.wzxy.povertyidentification.dao.IToupiaoDao;
import com.wzxy.povertyidentification.dao.IUserLoginDao;
import com.wzxy.povertyidentification.dao.IXsDao;
import com.wzxy.povertyidentification.dao.IFdyDao;

/**
 * ���й�����ķ�װ������ֱ��ͨ��������ȡ����ʵ����������ģʽ��
 */
public class DaoFactory {
	public static IXsDao getXsDaoInstance(){
		return new XsDaoImpl();
	}

	public static IUserLoginDao getUserLoginDaoInstance(){
		return new UserLoginImpl();
	}

	public static IFdyDao getFdyDaoInstance(){
		return new FdyDaoImpl();
	}

	public static IPkrdsqbDao getPkrdsqbDaoInstance(){
		return new PkrdsqbDaoImpl();
	}

	public static IBjDao getBjDaoInstance(){
		return new BjDaoImpl();
	}

	public static IToupiaoDao getToupiaoDaoInstance(){
		return new ToupiaoDaoImpl();
	}

}