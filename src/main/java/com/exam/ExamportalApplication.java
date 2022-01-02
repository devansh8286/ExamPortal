package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;
import com.exam.services.Impl.UserServiceImpl;

@SpringBootApplication
public class ExamportalApplication implements CommandLineRunner {

//	@Autowired
//	private UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(ExamportalApplication.class, args);
		System.out.println("examportal");
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
//
//		System.out.println("Started...........");
//
//		User user = new User();
//		Role role = new Role();
//		UserRole userRole = new UserRole();
//
//		user.setUsername("dev252sa111");
//		user.setLastName("gupta");
//		user.setFirstName("Devansh..");
//		user.setEmail("dev@123");
//		user.setPassword("tete");
//		user.setPhone("123311");
//
//		role.setId(01l);
//		role.setRoleName("ADMIN");
//
//		userRole.setRoles(role);
//		userRole.setUsers(user);
//
//		Set<UserRole> userRoleSet = new HashSet<>();
//		userRoleSet.add(userRole);
//
//		User createUser = this.userService.createUser(user, userRoleSet);
//
//		System.out.println(createUser.getFirstName().toString()+createUser.getProfile());

	}

}
