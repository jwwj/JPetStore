package com.clps.demo.domain;
// Generated 2018-1-12 10:20:57 by Hibernate Tools 5.2.6.Final

/**
 * Inventory generated by hbm2java
 */
public class Inventory implements java.io.Serializable {

	private String itemid;
	private int qty;

	public Inventory() {
	}

	public Inventory(String itemid, int qty) {
		this.itemid = itemid;
		this.qty = qty;
	}

	public String getItemid() {
		return this.itemid;
	}

	public void setItemid(String itemid) {
		this.itemid = itemid;
	}

	public int getQty() {
		return this.qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

}
