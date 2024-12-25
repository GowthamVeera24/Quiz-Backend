package com.Quiz_server.service.user;

import com.Quiz_server.Dto.LoginDto;
import com.Quiz_server.Dto.SignUpDto;
import com.Quiz_server.entity.User;

public interface UserService {

	SignUpDto signup(SignUpDto signUpDto);
	 
	 boolean hasUserEmail(String email);
	 
	 User login(LoginDto loginDto) ;
}
