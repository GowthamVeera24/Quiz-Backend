package com.Quiz_server.Dto;

import org.springframework.data.annotation.Id;

public class LoginDto {

	@Id
	private String id;
	private String email;
	
	private String password;

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


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
