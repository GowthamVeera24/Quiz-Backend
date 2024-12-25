package com.Quiz_server.service.test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Quiz_server.Dto.QuestionDto;
import com.Quiz_server.Dto.TestDto;
import com.Quiz_server.Repository.QuestionRepository;
import com.Quiz_server.Repository.TestRepository;
import com.Quiz_server.entity.Question;
import com.Quiz_server.entity.Test;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TestServiceImpl  implements TestServcie{
	
	@Autowired
	private TestRepository testRepository;
	
	@Autowired
	private QuestionRepository questionRepository;
	
	public TestDto createTest(TestDto dto) {
		
		Test test= new  Test();
		
		test.setTitle(dto.getTitle());
		test.setDescription(dto.getDescription());
		test.setTime(dto.getTime());
		
		return testRepository.save(test).getDto();
	}
	
	
	public List<TestDto> getAllTests(){
		
		return testRepository.findAll().stream()
				.peek(test -> test.setTime(test.getQuestions().size() * test.getTime()))
				.collect(Collectors.toList())
				.stream().map(Test::getDto).collect(Collectors.toList());
	}
	
	///////////////////////  Question  ///////////////////////
	
	public QuestionDto addQuestionTotest(Long testId, QuestionDto dto) {
		
		Test test= testRepository.findById(testId).get();
		
		if(test !=null) {
			
			Question question=new Question();
			question.setQuestionText(dto.getQuestionText());
			question.setOptionA(dto.getOptionA());
			question.setOptionB(dto.getOptionB());
			question.setOptionC(dto.getOptionC());
			question.setOptionD(dto.getOptionD());
			question.setCorrectOption(dto.getCorrectOption());
			question.setTest(test);
			
			return questionRepository.save(question).getDto();
		}
		throw new EntityNotFoundException("Test Not found Yet ..");
	}

}
