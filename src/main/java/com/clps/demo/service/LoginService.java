package com.clps.demo.service;

import com.clps.demo.dao.LoginDao;
import com.clps.demo.dao.impl.LoginDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
/**
 * �û���¼�ӿ�
 * @author len
 *
 */
public interface LoginService {

	/**
	 * �û���¼
	 * @param userid
	 * @param password
	 * @return
	 */
	public long userLogin(String userid,String password);
	/**
	 * �û���¼��Ϣ
	 * @param userid
	 * @return
	 */
	public Signon querySignon(String userid);
	/**
	 * �û���ϸ��Ϣ
	 * @param userid
	 * @return
	 */
	public Account queryAccount(String userid);
	/**
	 * ��ȡϲ���ĳ���
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
	/**
	 * ����ϲ���ĳ���
	 * @param profile
	 */
	public void saveProfile(Profile profile);
	public LoginDao getLoginDao();
	public void setLoginDao(LoginDao loginDao);
}
