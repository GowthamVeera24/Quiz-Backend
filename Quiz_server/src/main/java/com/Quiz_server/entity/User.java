package com.Quiz_server.entity;

import com.Quiz_server.Dto.LoginDto;
import com.Quiz_server.Dto.SignUpDto;
import com.Quiz_server.enums.UserRole;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	
	private String email;
	private String password;
	private String name;
	private UserRole userRole;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
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
		
		signUpDto.setId(id);
		signUpDto.setName(name);
		signUpDto.setEmail(email);
		signUpDto.setPassword(password);
		signUpDto.setUserRole(userRole);
		
		return signUpDto;
	}
	
	public LoginDto getLoginDto() {
		LoginDto loginDto =new LoginDto();
		
		loginDto.setEmail(email);
		loginDto.setPassword(password);
		
		return loginDto; 
	}

}
