package com.Quiz_server.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Quiz_server.Dto.QuestionDto;
import com.Quiz_server.Dto.TestDto;
import com.Quiz_server.service.test.TestServcie;

@RestController
@RequestMapping("/api/test")
@CrossOrigin("*")
public class TestController {

	@Autowired
	private TestServcie testServcie;
	
	
	@PostMapping()
	public ResponseEntity<?> createTest(@RequestBody TestDto testDto){
		
		TestDto dto = testServcie.createTest(testDto);
		
		if(dto == null)
			return new ResponseEntity<>("Something went wrong ..." , HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(dto ,HttpStatus.CREATED);
	}
	
	@GetMapping("/getAllTests")
	public ResponseEntity<?> getAllTests(){
		
		List<TestDto> dtoList = testServcie.getAllTests();
		
		if(dtoList == null)
			return new ResponseEntity<>("Something went wrong ..." , HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(dtoList ,HttpStatus.CREATED);
	}
	
	
	
	@PostMapping("/question/{taskId}")
	public ResponseEntity<?> addQuestion(@PathVariable long taskId,@RequestBody QuestionDto dto ){
		
		QuestionDto questionDto = testServcie.addQuestionTotest(taskId,dto);
		
		if(questionDto == null)
			return new ResponseEntity<>("Test Not Be Found Anu more ..." , HttpStatus.BAD_REQUEST);
		return new ResponseEntity<>(questionDto ,HttpStatus.CREATED);
	}
}
