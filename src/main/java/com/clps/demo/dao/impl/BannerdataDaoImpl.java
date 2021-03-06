package com.clps.demo.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.demo.dao.BannerdataDao;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;



@Repository
public class BannerdataDaoImpl implements BannerdataDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public Bannerdata querybanner(String userid){
		
		
		Session session = sessionFactory.openSession();
		String hql="from Bannerdata where favcategory = (select favcategory from Profile where userid = ? )";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		List<Bannerdata> bannerdatalist = query.list();
		
		session.close();
		
		return bannerdatalist.get(0);
	}
	@Override
	public Bannerdata querybannerTwo(String userid){
		
		Session session = sessionFactory.openSession();
		
		String hql="from Bannerdata where favcategory = (select favcategory from Profile where userid = ? )";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		List<Bannerdata> bannerdatalist = query.list();
		
		session.close();
		
		return bannerdatalist.get(0);
	}
	@Override
	public Profile queryMyListOpf(String userid){
		
		Session session = sessionFactory.openSession();
		
		String hql="from Profile where userid = ? ";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		List<Profile> profilelist = query.list();
		
		session.close();
		
		return profilelist.get(0);
	}
	@Override
	public Profile queryMyList(String userid){
		
		Session session = sessionFactory.openSession();
		
		Profile profile = (Profile) session.get(Profile.class, userid);
		
		session.close();
		
		return profile;
	}

	
}
