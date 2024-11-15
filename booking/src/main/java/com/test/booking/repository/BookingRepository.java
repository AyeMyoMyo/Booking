package com.test.booking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.booking.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

}