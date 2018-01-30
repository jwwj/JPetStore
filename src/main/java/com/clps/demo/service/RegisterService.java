package com.clps.demo.service;

import com.clps.demo.dao.RegisterDao;
import com.clps.demo.dao.impl.RegisterDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

/**
 * �û�ע��ӿ�
 * @author len
 *
 */
public interface RegisterService {

	/**
	 * �½����û����û���������
	 * @param signon
	 */
	public void insertSigno(Signon signon);
	/**
	 * �½����û���ϲ����Ϣ
	 * @param profile
	 */
	public void insertProfile(Profile profile);
	/**
	 * �½����û�����ϸ��Ϣ
	 * @param account
	 */
	public void insertAccount(Account account);
	public RegisterDao getRegisterDao();
	public void setRegisterDao(RegisterDao registerDao);
}
