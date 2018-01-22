package com.clps.demo.dao.impl;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.demo.dao.RegisterDao;
import com.clps.demo.domain.Account;
import com.clps.demo.domain.Profile;
import com.clps.demo.domain.Signon;


@Repository
public class RegisterDaoImpl implements RegisterDao{
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void insertSigno(Signon signon){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(signon);
		
		
		tr.commit();
		session.close();
	}
	@Override
	public void insertProfile(Profile profile){
		
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(profile);
		
		tr.commit();
		session.close();
		
	}
	@Override
	public void insertAccount(Account account){
		Session session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		session.save(account);
		
		tr.commit();
		session.close();
		
	}
}
