package com.Quiz_server.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Quiz_server.entity.Test;

@Repository
public interface TestRepository extends JpaRepository<Test, Long> {

}
