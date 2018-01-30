package com.clps.demo.service;

import com.clps.demo.dao.BannerdataDao;
import com.clps.demo.dao.impl.BannerdataDaoImpl;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;
/**
 * 宠物图片接口
 * @author len
 *
 */
public interface BannerdataService {
	/**
	 * 获取宠物图片
	 * @param userid
	 * @return
	 */
	public Bannerdata querybanner(String userid);
	/**
	 * 获取宠物图片
	 * @param userid
	 * @return
	 */
	public Bannerdata querybannerTwo(String userid);
	/**
	 * 获取用户喜好
	 * @param userid
	 * @return
	 */
	public Profile queryMyListOpf(String userid);
	/**
	 * 获取用户喜好宠物的图片
	 * @param userid
	 * @return
	 */
	public Profile queryMyList(String userid);
	public BannerdataDao getBannerdataDao();
	public void setBannerdataDao(BannerdataDao bannerdataDao);
	
}
