package com.exam.controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

	@Autowired
	UserService userService;

	@PostMapping
	public User createUser(@RequestBody User user) throws Exception {

		Role role = new Role();
		role.setId(11l);
		role.setRoleName("setting");

		UserRole userRole = new UserRole();
		userRole.setRoles(role);
		userRole.setUsers(user);
		Set<UserRole> setUserRole = new HashSet<>();
		setUserRole.add(userRole);
		User createUser = this.userService.createUser(user, setUserRole);
		return createUser;
	}

	@GetMapping("/{username}")
	public User getUser(@PathVariable String username) {
		return this.userService.getUser(username);
	}

	@DeleteMapping("/{userId}")
	public void deleteUser(@PathVariable Long userId) {

		this.userService.deleteUser(userId);
	}

}
