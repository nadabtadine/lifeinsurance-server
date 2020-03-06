package com.example.demo.JWT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.AuthenticatedCustomer;
import com.example.demo.model.Customer;

public class JwtAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider{

	// uses jwtUtil because it requires to return customer details
	 @Autowired
	  private JwtUtil jwtUtil;

	    @Override
	    public boolean supports(Class<?> authentication) {
	        return (JwtAuthenticationToken.class.isAssignableFrom(authentication));
	    }
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		// TODO Auto-generated method stub
		JwtAuthenticationToken jwtAuthenticationToken = (JwtAuthenticationToken) authentication;
        String token = jwtAuthenticationToken.getToken();

        Customer parsedCustomer = jwtUtil.parseToken(token);

        if (parsedCustomer == null) {
            throw new JwtAuthenticationException("JWT token is not valid");
        }

 
        return new AuthenticatedCustomer(parsedCustomer.getUsername(), parsedCustomer.getId(), token);
    }
}


