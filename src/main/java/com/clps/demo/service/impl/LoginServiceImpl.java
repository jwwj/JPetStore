package com.clps.demo.service.impl;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.service.LoginService;
import com.clps.demo.dao.*;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	private LoginDao loginDao;

	@Override
	public long userLogin(String userid,String password){
		return loginDao.userLogin(userid, password);
	}
	@Override
	public Signon querySignon(String userid){
		
		
		return loginDao.querySignon(userid);
		
	}
	@Override
	public Account queryAccount(String userid){
		
	
		return loginDao.queryAccount(userid);
		
	}
	@Override
	public Profile queryProfile(String userid){
		
		
		return loginDao.queryProfile(userid);
		
	}
	@Override
	public void saveProfile(Profile profile){
		
		loginDao.saveProfile(profile);
	}
	
	@Override
	public LoginDao getLoginDao() {
		return loginDao;
	}
	@Override
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}
	
	
	
}
