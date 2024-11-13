package com.test.booking.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.booking.interfaces.IUserService;

@RestController
public class LoginController {

	@Autowired
	private IUserService usersService;

	@PostMapping("/login")
	public String login(@RequestParam String username, @RequestParam String password) {
		boolean isAuthenticated = usersService.authenticateUser(username, password);
		if (isAuthenticated) {
			return "Login successful";
		} else {
			return "Invalid username or password";
		}
	}
}
