package com.clps.demo.service;

import com.clps.demo.dao.BannerdataDao;
import com.clps.demo.dao.impl.BannerdataDaoImpl;
import com.clps.demo.domain.Bannerdata;
import com.clps.demo.domain.Profile;
/**
 * ����ͼƬ�ӿ�
 * @author len
 *
 */
public interface BannerdataService {
	/**
	 * ��ȡ����ͼƬ
	 * @param userid
	 * @return
	 */
	public Bannerdata querybanner(String userid);
	/**
	 * ��ȡ����ͼƬ
	 * @param userid
	 * @return
	 */
	public Bannerdata querybannerTwo(String userid);
	/**
	 * ��ȡ�û�ϲ��
	 * @param userid
	 * @return
	 */
	public Profile queryMyListOpf(String userid);
	/**
	 * ��ȡ�û�ϲ�ó����ͼƬ
	 * @param userid
	 * @return
	 */
	public Profile queryMyList(String userid);
	public BannerdataDao getBannerdataDao();
	public void setBannerdataDao(BannerdataDao bannerdataDao);
	
}
