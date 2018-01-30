package com.clps.demo.service;

import com.clps.demo.dao.LoginDao;
import com.clps.demo.dao.impl.LoginDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
/**
 * 用户登录接口
 * @author len
 *
 */
public interface LoginService {

	/**
	 * 用户登录
	 * @param userid
	 * @param password
	 * @return
	 */
	public long userLogin(String userid,String password);
	/**
	 * 用户登录信息
	 * @param userid
	 * @return
	 */
	public Signon querySignon(String userid);
	/**
	 * 用户详细信息
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	/**
	 * 获取喜爱的宠物
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
	/**
	 * 保存喜爱的宠物
	 * @param profile
	 */
	public void saveProfile(Profile profile);
	public LoginDao getLoginDao();
	public void setLoginDao(LoginDao loginDao);
}
