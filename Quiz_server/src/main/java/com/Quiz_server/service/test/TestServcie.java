package com.Quiz_server.service.test;

import java.util.List;

import com.Quiz_server.Dto.QuestionDto;
import com.Quiz_server.Dto.TestDto;

public interface TestServcie {

	TestDto createTest(TestDto dto);
	
	QuestionDto addQuestionTotest(String testId, QuestionDto dto);
	
	List<TestDto> getAllTests();
}
