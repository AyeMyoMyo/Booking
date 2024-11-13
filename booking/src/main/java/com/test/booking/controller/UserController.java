package com.test.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.test.booking.interfaces.IUserPackageService;
import com.test.booking.interfaces.IUserService;
import com.test.booking.model.User;
import com.test.booking.model.UserPackage;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private IUserService usersService;

	@Autowired
	private IUserPackageService userPackageService;

	@PostMapping("/register")
	public User createUser(@Validated @RequestBody User user) {
		return usersService.save(user);
	}

	@GetMapping("/verify")
	public String verifyEmail(@RequestParam Long token) {
		// Logic to validate token and activate user
		boolean isVerified = usersService.verifyUserEmail(token);

		if (isVerified) {
			return "Email successfully verified!";
		} else {
			return "Invalid or expired token.";
		}
	}

	@GetMapping("/porfile/{id}")
	public ResponseEntity<User> getUserProfile(@PathVariable(value = "id") Long userId) {
		User user = usersService.findById(userId);

		return ResponseEntity.ok().body(user);
	}

	@PutMapping("/changepassword")
	User changePassword(@RequestBody User user) {

		return usersService.changePassword(user);
	}

	@GetMapping("/packages")
	public List<UserPackage> getAllUserPackages(@RequestParam Long userId) {
		return userPackageService.getAllUserPackage(userId);
	}

}
