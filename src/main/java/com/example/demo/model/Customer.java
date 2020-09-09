package com.example.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="customer")
public class Customer implements Serializable {

	private static final long serialVersionUID = 1L;

	
	@SequenceGenerator(name="customerSequence",allocationSize=1,initialValue=2,sequenceName="customer_sequence11")
	@Id
	@GeneratedValue(generator = "customerSequence")
	private long id;
	
	private String name;
	private int age;
	private int gender;
	private String address;
	private String phone_number;
	private String email;
	private String username;
	private String password;
//	private int token;
	private ArrayList<ShoppingCartItem> shoppingcart;
	

	public ArrayList<ShoppingCartItem> getShoppingcart() {
		return shoppingcart;
	}

	public void setShoppingcart(ArrayList<ShoppingCartItem> shoppingcart) {
		this.shoppingcart = shoppingcart;
	}

	@Column(name="id")
	public long getId() {
		return id;
	}
	
	public void setId(long id) {
		this.id = id;
	}
	

	@Column(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name="age")
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	@Column(name="gender")
	public int getGender() {
		return gender;
	}
	
	public void setGender(int gender) {
		this.gender = gender;
	}
	
	@Column(name="address")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name="phone_number")
	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}
	
	
	@Column(name="username")
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
	@Column(name="password")
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

//	public Customer(long id, String username,int i) {
//		super();
//		this.id = id;
//		this.username = username;
//		this.token=i;
//	}

	public Customer() {
		// TODO Auto-generated constructor stub
	}

	//public Customer(String name, Integer age, Integer gender, String address, String phone, String email,
	//		String username, String password) {
	//	this.name=name;
	//	this.age=age;
	//	this.gender=gender;
	//	this.address=address;
	//	this.phone_number=phone;
	//	this.email=email;
	//	this.username=username;
	//	this.password=password;
		// TODO Auto-generated constructor stub
	//}


	
}