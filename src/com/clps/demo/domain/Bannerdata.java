package com.clps.demo.domain;
// Generated 2018-1-12 10:20:57 by Hibernate Tools 5.2.6.Final

/**
 * Bannerdata generated by hbm2java
 */
public class Bannerdata implements java.io.Serializable {

	private String favcategory;
	private String bannername;

	public Bannerdata() {
	}

	public Bannerdata(String favcategory) {
		this.favcategory = favcategory;
	}

	public Bannerdata(String favcategory, String bannername) {
		this.favcategory = favcategory;
		this.bannername = bannername;
	}

	public String getFavcategory() {
		return this.favcategory;
	}

	public void setFavcategory(String favcategory) {
		this.favcategory = favcategory;
	}

	public String getBannername() {
		return this.bannername;
	}

	public void setBannername(String bannername) {
		this.bannername = bannername;
	}

}
