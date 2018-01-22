package com.clps.demo.dao;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

public interface LoginDao {

	public long userLogin(String userid,String password);
	
	public Signon querySignon(String userid);
	
	public Account queryAccount(String userid);
	
	public Profile queryProfile(String userid);
	
	public void saveProfile(Profile profile);
}
