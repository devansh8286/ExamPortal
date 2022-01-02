package com.exam.config;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.exam.services.Impl.UserDetailServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	@Autowired
	private UserDetailServiceImpl userDetailServiceImpl;

	@Autowired
	private JwtUtils jwtUtils;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		

		Enumeration headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement();
            
            System.out.println("Key Value ..  "+key);
            
            String value = request.getHeader(key);
        
            System.out.println("Value is .. "+value );
            
        }
		
		String header = request.getHeader("Authorization");
		System.out.println("headerr.." + header);

		String username = null;
		String jwtToken = null;

		if (header != null && header.startsWith("Bearer ")) {
			System.out.println("Bearer....");
			jwtToken = header.substring(7);
			try {
				username = this.jwtUtils.extractUsername(jwtToken);
			} catch (ExpiredJwtException e) {
				e.printStackTrace();
				System.out.println("jwt token expire");
			} catch (Exception e) {

				e.printStackTrace();
			}

			// validate token
			if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
				final UserDetails userDetail = this.userDetailServiceImpl.loadUserByUsername(username);

				if (this.jwtUtils.validateToken(jwtToken, userDetail)) {

					UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
							userDetail, null, userDetail.getAuthorities());

					usernamePasswordAuthenticationToken
							.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

					SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
				}
				

			}
			else {
				System.out.println("token is not valid..");
			}
			

		}

		filterChain.doFilter(request, response);

	}

}
