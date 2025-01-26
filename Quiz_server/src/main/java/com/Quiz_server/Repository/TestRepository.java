package com.Quiz_server.Repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Quiz_server.entity.Test;

@Repository
public interface TestRepository extends MongoRepository<Test, String> {

}
