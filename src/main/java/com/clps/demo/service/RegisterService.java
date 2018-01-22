package com.clps.demo.service;

import com.clps.demo.dao.RegisterDao;
import com.clps.demo.dao.impl.RegisterDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

public interface RegisterService {

	/**
	 * 
	 * @param signon
	 */
	public void insertSigno(Signon signon);
	/**
	 * 
	 * @param profile
	 */
	public void insertProfile(Profile profile);
	/**
	 * 
	 * @param account
	 */
	public void insertAccount(Account account);
	/**
	 * 
	 * @return
	 */
	public RegisterDao getRegisterDao();
	/**
	 * 
	 * @param registerDao
	 */
	public void setRegisterDao(RegisterDao registerDao);
}
