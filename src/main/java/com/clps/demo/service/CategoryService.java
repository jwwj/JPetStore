package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;
/**
 *商品接口
 * @author len
 *
 */
public interface CategoryService {
	/**
	 * 获取商品列表
	 * @param category
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> query(Category category,int begin,int end);
	/**
	 * 获取商品种类列表
	 * @param produceID
	 * @return
	 */
	public List<Item> queryItem(String produceID);
	/**
	 * 获取商品个数
	 * @param itemid
	 * @return
	 */
	public long queryInventory(String itemid);
	/**
	 * 获取商品种类
	 * @param itemid
	 * @return
	 */
	public Item queryItemTwo(String itemid);
	/**
	 * 模糊查询商品
	 * @param value
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> queryLike(String value,int begin,int end);
	/**
	 * 根据用户喜好查询
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
}
