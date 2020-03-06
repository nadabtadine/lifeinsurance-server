package com.example.demo.JWT;

public class JwtCustomerDetails {

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	private String username;
    private String token;
    private Long id;
    
	 public JwtCustomerDetails(String username, long id, String token) {

	        this.username = username;
	        this.id = id;
	        this.token= token;

	    }
}
