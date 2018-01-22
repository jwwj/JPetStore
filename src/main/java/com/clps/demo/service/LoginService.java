package com.clps.demo.service;

import com.clps.demo.dao.LoginDao;
import com.clps.demo.dao.impl.LoginDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

public interface LoginService {

	/**
	 * 
	 * @param userid
	 * @param password
	 * @return
	 */
	public long userLogin(String userid,String password);
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Signon querySignon(String userid);
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
	/**
	 * 
	 * @param profile
	 */
	public void saveProfile(Profile profile);
	/**
	 * 
	 * @return
	 */
	public LoginDao getLoginDao();
	/**
	 * 
	 * @param loginDao
	 */
	public void setLoginDao(LoginDao loginDao);
}
