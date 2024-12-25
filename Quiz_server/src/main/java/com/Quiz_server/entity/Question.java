package com.Quiz_server.entity;

import com.Quiz_server.Dto.QuestionDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "question")
public class Question {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String QuestionText;
	
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String correctOption;
	
	@ManyToOne
	@JoinColumn(name = "test_id")
	private Test test;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getQuestionText() {
		return QuestionText;
	}

	public void setQuestionText(String questionText) {
		QuestionText = questionText;
	}

	public String getOptionA() {
		return optionA;
	}

	public void setOptionA(String optionA) {
		this.optionA = optionA;
	}

	public String getOptionB() {
		return optionB;
	}

	public void setOptionB(String optionB) {
		this.optionB = optionB;
	}

	public String getOptionC() {
		return optionC;
	}

	public void setOptionC(String optionC) {
		this.optionC = optionC;
	}

	public String getOptionD() {
		return optionD;
	}

	public void setOptionD(String optionD) {
		this.optionD = optionD;
	}

	public String getCorrectOption() {
		return correctOption;
	}

	public void setCorrectOption(String correctOption) {
		this.correctOption = correctOption;
	}

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public QuestionDto getDto() {
		
		QuestionDto dto = new QuestionDto();
		
		dto.setId(id);
		dto.setQuestionText(QuestionText);
		dto.setOptionA(optionA);
		dto.setOptionB(optionB);
		dto.setOptionB(optionB);
		dto.setOptionC(optionC);
		dto.setOptionD(optionD);
		dto.setCorrectOption(correctOption);
		dto.setTest_id(test.getId());
		
		return dto;
	}
	
	

}
