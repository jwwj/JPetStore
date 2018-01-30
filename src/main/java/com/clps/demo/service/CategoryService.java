package com.clps.demo.service;

import java.util.List;

import com.clps.demo.domain.Category;
import com.clps.demo.domain.Item;
import com.clps.demo.domain.Product;
import com.clps.demo.domain.Profile;
/**
 *��Ʒ�ӿ�
 * @author len
 *
 */
public interface CategoryService {
	/**
	 * ��ȡ��Ʒ�б�
	 * @param category
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> query(Category category,int begin,int end);
	/**
	 * ��ȡ��Ʒ�����б�
	 * @param produceID
	 * @return
	 */
	public List<Item> queryItem(String produceID);
	/**
	 * ��ȡ��Ʒ����
	 * @param itemid
	 * @return
	 */
	public long queryInventory(String itemid);
	/**
	 * ��ȡ��Ʒ����
	 * @param itemid
	 * @return
	 */
	public Item queryItemTwo(String itemid);
	/**
	 * ģ����ѯ��Ʒ
	 * @param value
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Product> queryLike(String value,int begin,int end);
	/**
	 * �����û�ϲ�ò�ѯ
	 * @param userid
	 * @return
	 */
	public Profile queryProfile(String userid);
}
