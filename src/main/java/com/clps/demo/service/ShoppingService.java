package com.clps.demo.service;

import java.util.List;

import com.clps.demo.dao.ShoppingDao;
import com.clps.demo.dao.impl.ShoppingDaoImpl;
import com.clps.demo.domain.Cart;
/**
 * ���ﳵ�ӿ�
 * @author len
 *
 */
public interface ShoppingService {

	/**
	 * 
	 * ���湺�ﳵ
	 * @param cart
	 */
	public void saveShopping(Cart cart);
	/**
	 * ��ѯ�û��Ĺ��ﳵ�б�
	 * @param userid
	 * @param begin
	 * @param end
	 * @return
	 */
	public List<Cart> queryShopping(String userid,int begin,int end);
	/**
	 * ɾ�����ﳵ�ڵ���Ʒ
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int deleteShopping(String itemid,String userid);
	/**
	 * ���¿��
	 * @param quantity
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public int updateQuantity(int quantity,String itemid,String userid);
	/**
	 * ��ѯ��Ʒ����
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long queryCountShopping(String itemid,String userid);
	/**
	 * ��ȡ���ﳵ�ڵ�һ����Ʒ
	 * @param userid
	 * @param itemid
	 * @return
	 */
	public Cart queryOneShopping(String userid,String itemid);
	/**
	 * ���ﳵ�ڵ���Ʒ����
	 * @param itemid
	 * @param userid
	 * @return
	 */
	public long count(String itemid,String userid);
	public ShoppingDao getShoppingDao();
	public void setShoppingDao(ShoppingDao shoppingDao);
}
