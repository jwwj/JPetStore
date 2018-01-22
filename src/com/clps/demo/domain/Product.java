package com.clps.demo.domain;
// Generated 2018-1-12 10:20:57 by Hibernate Tools 5.2.6.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private String productid;
	private Category category;
	private String name;
	private String descn;
	private Set items = new HashSet(0);

	public Product() {
	}

	public Product(String productid, Category category) {
		this.productid = productid;
		this.category = category;
	}

	public Product(String productid, Category category, String name, String descn, Set items) {
		this.productid = productid;
		this.category = category;
		this.name = name;
		this.descn = descn;
		this.items = items;
	}

	public String getProductid() {
		return this.productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescn() {
		return this.descn;
	}

	public void setDescn(String descn) {
		this.descn = descn;
	}

	public Set getItems() {
		return this.items;
	}

	public void setItems(Set items) {
		this.items = items;
	}

}
