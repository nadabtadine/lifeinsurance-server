package com.example.demo.model;

public class simulation4 {

	private int house;
	private int car;
	private boolean loan;
	private String marial;
	private int nchild;
	private float income;
	private String address;
	
	public simulation4(int house, int car, boolean loan, String marial, int nchild, float income, String address) {
		super();
		this.house = house;
		this.car = car;
		this.loan = loan;
		this.marial = marial;
		this.nchild = nchild;
		this.income = income;
		this.address = address;
	}
	public int getHouse() {
		return house;
	}
	public void setHouse(int house) {
		this.house = house;
	}
	public int getCar() {
		return car;
	}
	public void setCar(int car) {
		this.car = car;
	}
	public boolean isLoan() {
		return loan;
	}
	public void setLoan(boolean loan) {
		this.loan = loan;
	}
	public String getMarial() {
		return marial;
	}
	public void setMarial(String marial) {
		this.marial = marial;
	}
	public int getNchild() {
		return nchild;
	}
	public void setNchild(int nchild) {
		this.nchild = nchild;
	}
	public float getIncome() {
		return income;
	}
	public void setIncome(float income) {
		this.income = income;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
}
