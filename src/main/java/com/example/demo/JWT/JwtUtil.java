package com.example.demo.JWT;

import org.springframework.beans.factory.annotation.Value;

import com.example.demo.model.Customer;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//The JwtUtil class is in charge of parsing the token into customer object and generating the token from the Customer object.
//we store username and id
public class JwtUtil {

	@Value("${jwt.secret}")
    private static String secret;
	
	 public Customer parseToken(String token) {
	        try {
	            Claims body = Jwts.parser()
	                    .setSigningKey(secret)
	                    .parseClaimsJws(token)
	                    .getBody();

	            Customer c = new Customer();
	            c.setUsername(body.getSubject());
	            c.setId(Long.parseLong((String) body.get("id")));
	            return c;

	        } catch (JwtException | ClassCastException e) {
	            return null;
	        }
	    }
	 
	 
	 //generates the token that will be returned to the clients, based on the customer.
	  public static String generateToken(Customer c) {
	        Claims claims = Jwts.claims().setSubject(c.getUsername());
	        claims.put("id", c.getId() + "");

	        return Jwts.builder()
	                .setClaims(claims)
	                .signWith(SignatureAlgorithm.HS512, secret)
	                .compact();
	    }

}
