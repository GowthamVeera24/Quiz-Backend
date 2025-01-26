package com.Quiz_server.service.test;

import java.util.List;
import java.util.stream.Collectors;

import com.Quiz_server.Dto.QuestionDto;
import com.Quiz_server.Dto.TestDto;
import com.Quiz_server.Repository.QuestionRepository;
import com.Quiz_server.Repository.TestRepository;
import com.Quiz_server.entity.Question;
import com.Quiz_server.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TestServiceImpl implements TestServcie {

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private QuestionRepository questionRepository;

	// Create a Test
	public TestDto createTest(TestDto dto) {
		Test test = new Test();
		test.setTitle(dto.getTitle());
		test.setDescription(dto.getDescription());
		test.setTime(dto.getTime());
		return testRepository.save(test).getDto();
	}


	// Get All Tests
	public List<TestDto> getAllTests() {
		return testRepository.findAll().stream()
				.collect(Collectors.toList())
				.stream()
				.map(Test::getDto)
				.collect(Collectors.toList());
	}

	// Add a Question to a Test
	@Override
	public QuestionDto addQuestionTotest(String testId, QuestionDto dto) {
		// Fetch the Test
		Test test = testRepository.findById(testId)
				.orElseThrow(() -> new EntityNotFoundException("Test Not Found"));

		// Create the Question
		Question question = new Question();
		question.setQuestionText(dto.getQuestionText());
		question.setOptionA(dto.getOptionA());
		question.setOptionB(dto.getOptionB());
		question.setOptionC(dto.getOptionC());
		question.setOptionD(dto.getOptionD());
		question.setCorrectOption(dto.getCorrectOption());
		question.setTestId(test.getId()); // Store reference to the Test ID

			// Save and return the DTO
			return questionRepository.save(question).getDto();
		}
	}