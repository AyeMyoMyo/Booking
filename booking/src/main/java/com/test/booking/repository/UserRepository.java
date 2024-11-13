package com.test.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.booking.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	 User findByEmail(String username);
}

	
