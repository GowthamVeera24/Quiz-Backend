package com.Quiz_server.entity;

import com.Quiz_server.Dto.QuestionDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "questiondata")
public class Question {

	@Id
	private String id;

	private String questionText;
	private String optionA;
	private String optionB;
	private String optionC;
	private String optionD;
	private String correctOption;

	private String testId; // Reference to the Test ID

	// Getters and Setters
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getQuestionText() {
		return questionText;
	}

	public void setQuestionText(String questionText) {
		this.questionText = questionText;
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

	public String getTestId() {
		return testId;
	}

	public void setTestId(String testId) {
		this.testId = testId;
	}

	// Method to convert Question to QuestionDto
	public QuestionDto getDto() {
		QuestionDto dto = new QuestionDto();
		dto.setId(this.id); // id is a String
		dto.setQuestionText(this.questionText);
		dto.setOptionA(this.optionA);
		dto.setOptionB(this.optionB);
		dto.setOptionC(this.optionC);
		dto.setOptionD(this.optionD);
		dto.setCorrectOption(this.correctOption);
		dto.setTestId(this.testId); // testId is a String
		return dto;
	}

}
