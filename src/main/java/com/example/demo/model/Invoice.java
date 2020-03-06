package com.example.demo.model;

import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="invoices")
public class Invoice {

	@Id
	private long id;
	
	@Column(name="id")
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name="cid")
	public long getCid() {
		return cid;
	}
	public void setCid(long cid) {
		this.cid = cid;
	}
	
	@Column(name="pid")
	public ArrayList<Long> getPid() {
		return pid;
	}
	public void setPid(ArrayList<Long> pid) {
		this.pid = pid;
	}
	
	@Column(name="date")
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@Column(name="totalprice")
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}
	
	@Column(name="discount")
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	private long cid;
	private ArrayList<Long> pid;
	private Date date;
	private float totalprice;
	private float discount;
	
	
}
