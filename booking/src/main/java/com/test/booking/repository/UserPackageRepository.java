package com.test.booking.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.booking.model.UserPackage;
@Repository
public interface UserPackageRepository extends JpaRepository<UserPackage, Long> {
	List<UserPackage> findByUserId(Long UserId);

}
