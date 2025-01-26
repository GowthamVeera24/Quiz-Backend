package com.Quiz_server.controller;

import java.util.List;

import com.Quiz_server.Dto.QuestionDto;
import com.Quiz_server.Dto.TestDto;
import com.Quiz_server.service.test.TestServcie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/test")
@CrossOrigin("*")
public class TestController {

	@Autowired
	private TestServcie testServcie;

	// Create a Test
	@PostMapping
	public ResponseEntity<?> createTest(@RequestBody TestDto testDto) {
		TestDto dto = testServcie.createTest(testDto);
		if (dto == null) {
			return new ResponseEntity<>("Something went wrong ...", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(dto, HttpStatus.CREATED);
	}

	// Get All Tests
	@GetMapping("/getAllTests")
	public ResponseEntity<?> getAllTests() {
		List<TestDto> dtoList = testServcie.getAllTests();
		if (dtoList == null) {
			return new ResponseEntity<>("Something went wrong ...", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(dtoList, HttpStatus.OK);
	}

	// Add Question to a Test
	@PostMapping("/question/{testId}")
	public ResponseEntity<?> addQuestion(@PathVariable String testId, @RequestBody QuestionDto dto) {
		QuestionDto questionDto = testServcie.addQuestionTotest(testId, dto);
		if (questionDto == null) {
			return new ResponseEntity<>("Test Not Found ...", HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(questionDto, HttpStatus.CREATED);
	}
}
