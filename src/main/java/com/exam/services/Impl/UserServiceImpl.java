package com.exam.services.Impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.Repository.RoleRepository;
import com.exam.Repository.UserRepository;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	// creating user ...

	@Override
	public User createUser(User user, Set<UserRole> userRole) throws Exception {

		System.out.println(user.getUsername());

		User localUser = this.userRepository.findByUsername(user.getUsername());

		if (localUser != null) {

			System.out.println("user alredy exist....");
			throw new Exception("user alredy exist...");

		} else {

			for (UserRole ur : userRole) {

				roleRepository.save(ur.getRoles());
				user.getUserRoles().addAll(userRole);
				localUser = this.userRepository.save(user);

			}

			return localUser;
		}
	}

	public User getUser(String username) {

		User findByUsername = this.userRepository.findByUsername(username);

		return findByUsername;
	}

	@Override
	public void deleteUser(Long userId) {

		this.userRepository.deleteById(userId);
	}
}
