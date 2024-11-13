package com.test.booking.interfaces;

import org.springframework.stereotype.Component;

import com.test.booking.model.User;

@Component
public interface IUserService {

	public User save(User user);
	
	public User findById(Long userId);
	
	public User changePassword(User user);

	public boolean verifyUserEmail(Long token);

	public boolean authenticateUser(String userName, String password);
}
