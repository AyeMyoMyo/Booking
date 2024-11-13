package com.test.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.booking.model.ClassInfo;

@Repository
public interface ClassInfoRepository extends JpaRepository<ClassInfo, Long> {

}
