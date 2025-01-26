package com.Quiz_server.service.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quiz_server.Dto.LoginDto;
import com.Quiz_server.Dto.SignUpDto;
import com.Quiz_server.Repository.UserRepository;
import com.Quiz_server.entity.User;
import com.Quiz_server.enums.UserRole;

import java.util.Optional;
import java.util.regex.Pattern;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepository;

	private static final Pattern EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);

	private void createAdmin() {

		User user1 = userRepository.findByUserRole(UserRole.ADMIN);

		if(user1 == null) {

			User user = new User();
			user.setName("admin");
			user.setEmail("admin1985@gmail.com");
			user.setPassword("admin1985");
			user.setUserRole(UserRole.ADMIN);

			userRepository.save(user);
			System.out.println("Admin Created Successfully !!!!!");
		}
		System.out.println("Admin Already Exists !!!!!");
	}


	public boolean hasUserEmail(String email) {
		return userRepository.findByEmail(email) != null;
	}


	public static boolean isEmail(String s) {
		return EMAIL.matcher(s).matches();
	}
	@Override
	public SignUpDto signup(SignUpDto signUpDto) {
		// Check if the email is valid and not already taken
		if (isEmail(signUpDto.getEmail()) && !hasUserEmail(signUpDto.getEmail())) {

			// Create a new User object
			User user = new User();
			// Set the email, password, and name from the DTO
			user.setEmail(signUpDto.getEmail());
			user.setPassword(signUpDto.getPassword());
			user.setName(signUpDto.getName());
			// Dynamically assign user role based on the incoming request
			UserRole roleInput = signUpDto.getUserRole(); // Get the UserRole object
			if (roleInput != null) { // Check if it's not null
				user.setUserRole(roleInput); // Assign the role directly
			} else {
				user.setUserRole(UserRole.USER); // Default to USER if role is null
			}
			// Save the user and return the DTO
			User createdUser = userRepository.save(user);
			return createdUser.getUserDto(); // Return the created user DTO
		}
		// If email validation fails, print a message and return null
		System.out.println("This is Not Valid Email");
		return null;
	}








	@Override
	public User login(LoginDto loginDto) {
		System.out.println(loginDto.getEmail());
		User  user=  userRepository.findByEmail(loginDto.getEmail());
		if(user != null && (loginDto.getPassword().equals(user.getPassword()))) {
			return user;
		}
		System.out.println("User Not found");
		return null;
	}

}