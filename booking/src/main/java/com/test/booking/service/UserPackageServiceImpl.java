package com.test.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.booking.interfaces.IUserPackageService;
import com.test.booking.model.UserPackage;
import com.test.booking.repository.UserPackageRepository;

import lombok.AllArgsConstructor;

@Service
@Qualifier("userPackageService")
@AllArgsConstructor
public class UserPackageServiceImpl implements IUserPackageService {

	@Autowired
	private UserPackageRepository userPackageRepository;

	@Override
	public List<UserPackage> getAllUserPackage(Long userId) {
		List<UserPackage> userPackagesList = userPackageRepository.findByUserId(userId);
		return userPackagesList;
	}

}
