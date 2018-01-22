package com.clps.demo.dao;

import java.util.List;

import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;

public interface CategoryDao {

	public List<Product> query(Category category, int begin, int end);
	
	public List<Item> queryItem(String produceID);
	
	public Item queryItemTwo(String itemid);
	
	public List<Product> queryLike(String value,int begin,int end);
	
	public Profile queryProfile(String userid);
	
	public long queryInventory(String itemid);
}
