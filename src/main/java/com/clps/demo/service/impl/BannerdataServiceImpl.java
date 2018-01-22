package com.clps.demo.service.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.BannerdataDao;
import com.clps.demo.dao.impl.BannerdataDaoImpl;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;
import com.clps.demo.service.BannerdataService;

@Service
public class BannerdataServiceImpl implements BannerdataService{

	@Autowired
	private BannerdataDao bannerdataDao;
	
	@Override
	public Bannerdata querybanner(String userid){
		return bannerdataDao.querybanner(userid);
		
		
	}
	@Override
	public Bannerdata querybannerTwo(String userid){
		return bannerdataDao.querybanner(userid);
		
		
	}
	@Override
	public Profile queryMyListOpf(String userid){
		
		return bannerdataDao.queryMyListOpf(userid);
	}
	@Override
	public Profile queryMyList(String userid){
		
		return bannerdataDao.queryMyList(userid);
	}
	@Override
	public BannerdataDao getBannerdataDao() {
		return bannerdataDao;
	}
	@Override
	public void setBannerdataDao(BannerdataDao bannerdataDao) {
		this.bannerdataDao = bannerdataDao;
	}
	
	
}
