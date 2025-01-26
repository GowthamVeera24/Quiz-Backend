package com.Quiz_server.entity;

import com.Quiz_server.Dto.TestDto;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "testdata") // MongoDB collection for tests
public class Test {

    @Id
    private String id; // MongoDB ID
    private String title;
    private String description;
    private long time; // Duration for the test in seconds

    private List<String> questionIds; // References to Question IDs

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public List<String> getQuestionIds() {
        return questionIds;
    }

    public void setQuestionIds(List<String> questionIds) {
        this.questionIds = questionIds;
    }

    public TestDto getDto() {
        TestDto dto = new TestDto();
        dto.setId(this.id);
        dto.setTitle(this.title);
        dto.setDescription(this.description);
        dto.setTime(this.time);
        return dto;
    }
}
