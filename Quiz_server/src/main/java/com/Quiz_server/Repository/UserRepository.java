package com.Quiz_server.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quiz_server.entity.User;
import com.Quiz_server.enums.UserRole;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByEmail(String email);

	User  findByUserRole(UserRole admin);
	

}
