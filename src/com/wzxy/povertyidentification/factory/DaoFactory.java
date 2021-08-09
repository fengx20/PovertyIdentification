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
 * 进行工厂类的封装，调用直接通过工厂类取得其实例化（工厂模式）
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