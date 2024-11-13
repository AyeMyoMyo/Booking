package com.test.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.booking.interfaces.IBookService;
import com.test.booking.model.BookCancelation;
import com.test.booking.model.Booking;

@RestController
@RequestMapping("/book")
public class BookController {

	@Autowired
	private IBookService bookService;

	@PostMapping("/cancel")
	Booking cancelBook(@RequestBody BookCancelation bookCancelation) {

		return bookService.cancelBook(bookCancelation);
	}
}
