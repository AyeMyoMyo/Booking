package com.test.booking.interfaces;

import com.test.booking.model.BookCancelation;
import com.test.booking.model.Booking;

public interface IBookService {
	Booking	cancelBook(BookCancelation bookCancelation);
}
