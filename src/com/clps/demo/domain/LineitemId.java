package com.clps.demo.domain;
// Generated 2018-1-12 10:20:57 by Hibernate Tools 5.2.6.Final

/**
 * LineitemId generated by hbm2java
 */
public class LineitemId implements java.io.Serializable {

	private int orderid;
	private int linenum;

	public LineitemId() {
	}

	public LineitemId(int orderid, int linenum) {
		this.orderid = orderid;
		this.linenum = linenum;
	}

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getLinenum() {
		return this.linenum;
	}

	public void setLinenum(int linenum) {
		this.linenum = linenum;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof LineitemId))
			return false;
		LineitemId castOther = (LineitemId) other;

		return (this.getOrderid() == castOther.getOrderid()) && (this.getLinenum() == castOther.getLinenum());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getOrderid();
		result = 37 * result + this.getLinenum();
		return result;
	}

}
