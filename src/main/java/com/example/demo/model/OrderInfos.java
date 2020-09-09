package com.example.demo.model;

public class OrderInfos {

	public String firstname;
	public String lastname;
    public String email;
    public String address;
    public String phone;
    public String country;
    public String state;
    public String zip;
    public String payment;
    
 
	public OrderInfos(String firstname, String lastname, String email, String address, String phone, String country,
			String state, String zip, String payment) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.address = address;
		this.phone = phone;
		this.country = country;
		this.state = state;
		this.zip = zip;
		this.payment = payment;
	}

	public OrderInfos() {
		// TODO Auto-generated constructor stub
	}

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
}
