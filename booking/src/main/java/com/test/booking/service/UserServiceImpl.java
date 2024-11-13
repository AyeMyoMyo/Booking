package com.test.booking.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.test.booking.interfaces.IUserService;
import com.test.booking.model.User;
import com.test.booking.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@Qualifier("usersService")
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
	@Autowired
	private UserRepository userRepository;

	// @Autowired
	// private PasswordEncoder passwordEncoder;

	@Override
	public User save(User user) {

		// String hashedPassword = passwordEncoder.encode(user.getPassword());

		// user.setPassword(hashedPassword);
		User newUser = userRepository.save(user);

		sendVerifyEmail(user.getEmail(), newUser.getId());
		return newUser;
	}

	public boolean sendVerifyEmail(String mail, Long token) {
		String subject = "Email Verification";
		String confirmationUrl = "http://localhost:8080/user/verify?token=" + token;
		String message = "Click the link to verify your email address: " + confirmationUrl;

//    SimpleMailMessage  mailMessage = new SimpleMailMessage();
//    mailMessage.setTo(toEmail);
//    mailMessage.setSubject(subject);
//    mailMessage.setText(message);
//    
//    mailSender.send(mailMessage);

		return true;
	}

	@Override
	public boolean verifyUserEmail(Long token) {
		Optional<User> user = userRepository.findById(token);

		if (user != null) {
			User queryUser = user.get();
			queryUser.setIsEmailVerified(true);
			userRepository.save(queryUser);
			return true;
		}

		return false;
	}

	@Override
	public boolean authenticateUser(String userName, String rawPassword) {
		User user = userRepository.findByEmail(userName);

		// String hashedPassword = passwordEncoder.encode(user.getPassword());

		if (user != null) {
			// return passwordEncoder.matches(rawPassword, user.getPassword());
		}
		return false;
	}

	@Override
	public User findById(Long userId) {
		User queryUser = null;

		Optional<User> user = userRepository.findById(userId);
		if (user != null) {
			queryUser = user.get();

			return queryUser;
		}

		return queryUser;
	}

	@Override
	public User changePassword(User user) {

		Optional<User> queryUser = userRepository.findById(user.getId());
		if (queryUser != null) {
			User oldUser = queryUser.get();
			oldUser.setPassword(user.getPassword());
			user=	userRepository.save(oldUser);
			user.setPassword(null);
			
		}
		return user;
	}

}
