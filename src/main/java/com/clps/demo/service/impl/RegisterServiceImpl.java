package com.clps.demo.service.impl;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.RegisterDao;
import com.clps.demo.dao.impl.RegisterDaoImpl;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.RegisterService;

@Service
public class RegisterServiceImpl implements RegisterService{
	@Autowired
	private RegisterDao registerDao;

	@Override
	public void insertSigno(Signon signon){
		registerDao.insertSigno(signon);
	}
	@Override
	public void insertProfile(Profile profile){
		registerDao.insertProfile(profile);
		
		
	}
	@Override
	public void insertAccount(Account account){
		registerDao.insertAccount(account);
		
	}
	
	@Override
	public RegisterDao getRegisterDao() {
		return registerDao;
	}
	@Override
	public void setRegisterDao(RegisterDao registerDao) {
		this.registerDao = registerDao;
	}
	
	
}
