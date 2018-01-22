package com.clps.demo.service;

import com.clps.demo.dao.BannerdataDao;
import com.clps.demo.dao.impl.BannerdataDaoImpl;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;

public interface BannerdataService {
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Bannerdata querybanner(String userid);
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Bannerdata querybannerTwo(String userid);
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Profile queryMyListOpf(String userid);
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Profile queryMyList(String userid);
	/**
	 * 
	 * @return
	 */
	public BannerdataDao getBannerdataDao();
	/**
	 * 
	 * @param bannerdataDao
	 */
	public void setBannerdataDao(BannerdataDao bannerdataDao);
	
}
