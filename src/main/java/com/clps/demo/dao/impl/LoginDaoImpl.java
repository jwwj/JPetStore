package com.clps.demo.dao.impl;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;
import com.clps.demo.*;
import com.clps.demo.dao.LoginDao;

@Repository
public class LoginDaoImpl implements LoginDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long userLogin(String userid,String password){
		
		Session session = sessionFactory.openSession();
		
		String hql = "select count(*) from Signon where userid = ? and password = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, userid);
		query.setParameter(1, password);
		long result = (long)query.uniqueResult();
		System.out.println(result);
		session.close();
		return result;
	}
	@Override
	public Signon querySignon(String userid){
		
		Session session = sessionFactory.openSession();
		
		Signon signon = (Signon) session.get(Signon.class, userid);
		
		session.close();
		return signon;
		
	}
	@Override
	public Account queryAccount(String userid){
		
		Session session = sessionFactory.openSession();
		
		Account account = (Account) session.get(Account.class, userid);
		
		
		session.close();
		return account;
		
	}
	@Override
	public Profile queryProfile(String userid){
		
		Session session = sessionFactory.openSession();
		
		Profile profile = (Profile) session.get(Profile.class, userid);
		
		
		session.close();
		return profile;
		
	}
	@Override
	public void saveProfile(Profile profile){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.update(profile);
		
		tr.commit();
		session.close();
	}
	
}
