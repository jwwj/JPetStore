package com.clps.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clps.demo.dao.CategoryDao;
import com.clps.demo.dao.impl.CategoryDaoImpl;
import com.clps.demo.domain.*;
import com.clps.demo.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService{
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public List<Product> query(Category category,int begin,int end){
		
		return categoryDao.query(category, begin, end);
	}
	@Override
	public List<Item> queryItem(String produceID){
		
		return categoryDao.queryItem(produceID);
	}
	@Override
	public long queryInventory(String itemid){
		
		return categoryDao.queryInventory(itemid);
	}
	@Override
	public Item queryItemTwo(String itemid){
		
		return categoryDao.queryItemTwo(itemid);
	}
	@Override
	public List<Product> queryLike(String value,int begin,int end){
		
		return categoryDao.queryLike(value,begin,end);
	}
	
	@Override
	public Profile queryProfile(String userid){
		return categoryDao.queryProfile(userid);
		
	}

	
	
}
