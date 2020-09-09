package com.example.demo.model;

public class simulation2 {

	private int age;
	private String marial;
	private int nchildren;
	private float income;
	private String address;
	private boolean loans;
	private String empstatus;
	public simulation2(int age, String marial, int nchildren, float income, String address, boolean loans,
			String empstatus) {
		super();
		this.age = age;
		this.marial = marial;
		this.nchildren = nchildren;
		this.income = income;
		this.address = address;
		this.loans = loans;
		this.empstatus = empstatus;
		
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getMarial() {
		return marial;
	}

	public void setMarial(String marial) {
		this.marial = marial;
	}

	public int getNchildren() {
		return nchildren;
	}

	public void setNchildren(int nchildren) {
		this.nchildren = nchildren;
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

	public boolean isLoans() {
		return loans;
	}

	public void setLoans(boolean loans) {
		this.loans = loans;
	}

	public String getEmpstatus() {
		return empstatus;
	}

	public void setEmpstatus(String empstatus) {
		this.empstatus = empstatus;
	}



}
