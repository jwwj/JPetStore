package com.clps.demo.service;

import com.clps.demo.dao.RegisterDao;
import com.clps.demo.dao.impl.RegisterDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

/**
 * 用户注册接口
 * @author len
 *
 */
public interface RegisterService {

	/**
	 * 新建新用户的用户名、密码
	 * @param signon
	 */
	public void insertSigno(Signon signon);
	/**
	 * 新建新用户的喜好信息
	 * @param profile
	 */
	public void insertProfile(Profile profile);
	/**
	 * 新建新用户的详细信息
	 * @param account
	 */
	public void insertAccount(Account account);
	public RegisterDao getRegisterDao();
	public void setRegisterDao(RegisterDao registerDao);
}
