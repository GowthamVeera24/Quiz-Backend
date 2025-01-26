package com.Quiz_server.Repository;



import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.Quiz_server.entity.User;
import com.Quiz_server.enums.UserRole;

@Repository
public interface UserRepository extends MongoRepository<User, String> {

	User findByEmail(String email);

	User  findByUserRole(UserRole admin);
	

}
