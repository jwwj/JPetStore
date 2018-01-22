package com.clps.demo.dao;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;

public interface RegisterDao {

	public void insertSigno(Signon signon);
	
	public void insertProfile(Profile profile);
	
	public void insertAccount(Account account);
}
