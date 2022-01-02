package com.exam.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.exam.Repository.UserRepository;
import com.exam.model.User;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		System.out.println("Under loadUserByUsername method... ");
		
		User findByUsername = userRepository.findByUsername(username);
		if(findByUsername == null) {
			System.out.println("User Not Found !!");
			throw new UsernameNotFoundException("user not found....");
		}
		
		return findByUsername;
	}

}
