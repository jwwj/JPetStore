package com.clps.demo.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clps.demo.dao.CategoryDao;
import com.clps.demo.domain.Category;
import com.clps.demo.domain.Inventory;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;
import com.clps.demo.service.CategoryService;

@Repository
public class CategoryDaoImpl implements CategoryDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Product> query(Category category, int begin, int end) {
		Session session = sessionFactory.openSession();
		String hql = "from Product where category = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0,category);
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List<Product> productlist= query.list();
		for(Product p : productlist){
			System.out.println(p.getName());
		}
		session.close();
		return productlist;
	}
	@Override
	public List<Item> queryItem(String produceID) {
		Session session = sessionFactory.openSession();

		Product product = (Product) session.get(Product.class, produceID);
		Set<Item> set = product.getItems();
		List<Item> itemlist = new ArrayList<Item>();
		for(Item p : set){
			itemlist.add(p);
			
		}
		session.close();
		return itemlist;
	}
	@Override
	public Item queryItemTwo(String itemid){
		
		Session session = sessionFactory.openSession();
		//Item Item = (Item) session.get(Item.class, itemid);
		String hql="from Item where itemid = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, itemid);
		List<Item> itemlist = query.list();
		
		//session.close();
		return itemlist.get(0);
		
	}
	@Override
	public List<Product> queryLike(String value,int begin,int end){
		Session session = sessionFactory.openSession();
		
		String hql = "FROM  Product WHERE name LIKE ? OR descn LIKE ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, "%" + value + "%");
		query.setParameter(1, "%" + value + "%");
		query.setFirstResult(begin);
		query.setMaxResults(end);
		List<Product> productList = query.list();
		
		session.close();
		return  productList;
		
		
		
	}
	@Override
	public Profile queryProfile(String userid){
		Session session = sessionFactory.openSession();
	
		Profile profile = (Profile) session.get(Profile.class, userid);
		session.close();
		return  profile;
		
		
	}
	@Override
	public long queryInventory(String itemid){
		Session session = sessionFactory.openSession();
		Inventory inventory = (Inventory) session.get(Inventory.class, itemid);
		long qty = inventory.getQty();
		
		session.close();
		return qty;
	}

}
