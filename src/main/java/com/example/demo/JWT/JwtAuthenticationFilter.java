package com.example.demo.JWT;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;


//The filter extracts the JWT token from the request headers 
//and delegates authentication to the injected AuthenticationManager
public class JwtAuthenticationFilter extends AbstractAuthenticationProcessingFilter{

	public JwtAuthenticationFilter() {

		super("/api/**");
	}
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException, IOException, ServletException {
		// TODO Auto-generated method stub
		String header = request.getHeader("Authorization");

        if (header == null || !header.startsWith("Bearer ")) {
            throw new JwtAuthenticationException("No JWT token found in request headers");
        }

        String authToken = header.substring(7);

        JwtAuthenticationToken authRequest = new JwtAuthenticationToken(authToken);

        return getAuthenticationManager().authenticate(authRequest);
	}
	
	 @Override
	    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult)
	            throws IOException, ServletException {
	        super.successfulAuthentication(request, response, chain, authResult);

	        // As this authentication is in HTTP header, after success we need to continue the request normally
	        // and return the response as if the resource was not secured at all
	        chain.doFilter(request, response);
	    }
	}

