package com.test.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.booking.model.Packages;

@Repository
public interface PackagesRepository extends JpaRepository<Packages, Long> {

}
