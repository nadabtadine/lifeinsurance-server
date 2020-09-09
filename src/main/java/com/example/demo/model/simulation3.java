package com.example.demo.model;

public class simulation3 {

	private int age;
	private String ld;
	private String el;
	private boolean abroad;
	private String major;
	private boolean volunteer;
	private boolean clubm;
	private float income;
	
	public simulation3(int age, String ld, String el, boolean abroad, String major, boolean volunteer, boolean clubm,
			float income) {
		super();
		this.age = age;
		this.ld = ld;
		this.el = el;
		this.abroad = abroad;
		this.major = major;
		this.volunteer = volunteer;
		this.clubm = clubm;
		this.income = income;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getLd() {
		return ld;
	}

	public void setLd(String ld) {
		this.ld = ld;
	}

	public String getEl() {
		return el;
	}

	public void setEl(String el) {
		this.el = el;
	}

	public boolean isAbroad() {
		return abroad;
	}

	public void setAbroad(boolean abroad) {
		this.abroad = abroad;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public boolean isVolunteer() {
		return volunteer;
	}

	public void setVolunteer(boolean volunteer) {
		this.volunteer = volunteer;
	}

	public boolean isClubm() {
		return clubm;
	}

	public void setClubm(boolean clubm) {
		this.clubm = clubm;
	}

	public float getIncome() {
		return income;
	}

	public void setIncome(float income) {
		this.income = income;
	}

	
}
