package com.clps.demo.dao;

import com.clps.demo.dao.impl.BannerdataDaoImpl;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;

public interface BannerdataDao {

	
	public Bannerdata querybanner(String userid);
	
	public Bannerdata querybannerTwo(String userid);
	
	public Profile queryMyListOpf(String userid);
	
	public Profile queryMyList(String userid);


}
