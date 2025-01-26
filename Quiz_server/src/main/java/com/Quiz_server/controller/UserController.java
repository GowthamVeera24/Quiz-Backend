package com.Quiz_server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz_server.Dto.LoginDto;
import com.Quiz_server.Dto.SignUpDto;
import com.Quiz_server.entity.User;
import com.Quiz_server.service.user.UserService;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;

	
	@PostMapping("/signup")
	public ResponseEntity<?> signup(@RequestBody  SignUpDto signUpDto){
		
		if(userService.hasUserEmail(signUpDto.getEmail())) {
			return new ResponseEntity<>("This User Already exists with this Email : "+signUpDto.getEmail() , HttpStatus.NOT_ACCEPTABLE);
		}
		
		SignUpDto dto=userService.signup(signUpDto);
			
		if(dto== null)
			return new ResponseEntity<>("In Valid Email , try again" , HttpStatus.BAD_REQUEST);
		return  ResponseEntity.ok(dto);
	}


	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody LoginDto loginDto) {
		User user = userService.login(loginDto);
		if (user == null) {
			return new ResponseEntity<>("Bad Credentials ...", HttpStatus.NOT_ACCEPTABLE);
		}

		// Return only the user data without the userDto
		SignUpDto responseDto = new SignUpDto();
		responseDto.setId(user.getId());
		responseDto.setEmail(user.getEmail());
		responseDto.setPassword(user.getPassword());
		responseDto.setName(user.getName());
		responseDto.setUserRole(user.getUserRole());

		return ResponseEntity.ok(responseDto);
	}

}
