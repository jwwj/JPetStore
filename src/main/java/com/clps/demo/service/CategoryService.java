package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;

public interface CategoryService {
	/**
	 * 
	 * @param category
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> query(Category category,int begin,int end);
	/**
	 * 
	 * @param produceID
	 * @return
	 */
	public List<Item> queryItem(String produceID);
	/**
	 * 
	 * @param itemid
	 * @return
	 */
	public long queryInventory(String itemid);
	/**
	 * 
	 * @param itemid
	 * @return
	 */
	public Item queryItemTwo(String itemid);
	/**
	 * 
	 * @param value
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> queryLike(String value,int begin,int end);
	/**
	 * 
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
}
