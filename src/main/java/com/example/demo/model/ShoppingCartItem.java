package com.example.demo.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name="shoppingcart")
public class ShoppingCartItem implements Serializable  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private long cid;
	private long pid;
	
	@Column(name="cid")
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	@Column(name="pid")
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}

	public ShoppingCartItem() {
	}

	public ShoppingCartItem(long cid, long pid) {
		this.cid = cid;
		this.pid = pid;
	}
	
}
