package com.exam.examserver;

import com.exam.examserver.Service.UserService;
import com.exam.examserver.entity.Role;
import com.exam.examserver.entity.User;
import com.exam.examserver.entity.UserRole;
import com.exam.examserver.helper.UserFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.sql.SQLOutput;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner {

	@Autowired
	private UserService userService;


	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);



	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Running the Server!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		try {
			User user = new User();

			user.setFirstName("Prabesh");
			user.setLastName("lama");
			user.setUserName("pralam3");
			user.setEmail("prabeshlama0@gmail.com");
			user.setPassword(this.bCryptPasswordEncoder.encode("admin"));
			user.setPhone("8373938377");
			user.setProfile("prabesh.png");

			Role role1 = new Role();
			role1.setRoleId(44L);
			role1.setRoleName("ADMIN");

			Set<UserRole> userRoleSet = new HashSet<>();
			UserRole userRole = new UserRole();
			userRole.setRole(role1);
			userRole.setUser(user);
			userRoleSet.add(userRole);

			User user1 = this.userService.createUser(user, userRoleSet);
			System.out.println(user1.getUserName());
		}
		catch (UserFoundException e){
			e.printStackTrace();
		}

	}
}
