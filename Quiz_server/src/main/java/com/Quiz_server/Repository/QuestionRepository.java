package com.Quiz_server.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Quiz_server.entity.Question;

@Repository
public interface QuestionRepository extends MongoRepository<Question, String> {

}
