package com.Quiz_server.entity;

import com.Quiz_server.Dto.LoginDto;
import com.Quiz_server.Dto.SignUpDto;
import com.Quiz_server.enums.UserRole;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import jakarta.persistence.Table;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "userdata")
public class User {
	
	@Id

	private String id ;
	
	
	private String email;
	private String password;
	private String name;
	private UserRole userRole;

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserRole getUserRole() {
		return userRole;
	}
	public void setUserRole(UserRole userRole) {
		this.userRole = userRole;
	}

	public SignUpDto getUserDto() {
		SignUpDto signUpDto = new SignUpDto();
		signUpDto.setId(this.id); // Ensure the ID is passed from User entity
		signUpDto.setName(this.name);
		signUpDto.setEmail(this.email);
		signUpDto.setPassword(this.password);
		signUpDto.setUserRole(this.userRole);
		return signUpDto;
	}



	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
