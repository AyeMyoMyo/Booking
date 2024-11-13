package com.test.booking.interfaces;

import java.util.List;

import com.test.booking.model.UserPackage;

public interface IUserPackageService {
	List<UserPackage> getAllUserPackage(Long userId);
}
