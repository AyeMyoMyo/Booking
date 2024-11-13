package com.test.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.booking.interfaces.IBookService;
import com.test.booking.model.BookCancelation;
import com.test.booking.model.Booking;
import com.test.booking.repository.BookingRepository;

import lombok.AllArgsConstructor;

@Service
@Qualifier("bookService")
@AllArgsConstructor
public class BookServiceImpl implements IBookService {
	@Autowired
	private BookingRepository bookRepository;

	@Override
	public Booking cancelBook(BookCancelation bookCancelation) {
		BookCancelation bookCancelation2 = null;

		Optional<Booking> booking = bookRepository.findById(bookCancelation.getBookingId());
		if (booking != null) {
			Booking oldBooking = booking.get();
			if (oldBooking.getUserId().equals(bookCancelation.getUserId())) {
				//oldBooking.getStartTime().get
			}
		}

		// TODO Auto-generated method stub
		return null;
	}

}
