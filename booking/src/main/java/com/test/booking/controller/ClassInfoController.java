package com.test.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.booking.interfaces.IClassInfoService;
import com.test.booking.interfaces.IPackagesService;
import com.test.booking.model.BookClassInfo;
import com.test.booking.model.Booking;
import com.test.booking.model.ClassInfo;
import com.test.booking.model.Packages;
import com.test.booking.model.PurchasePackages;
import com.test.booking.model.UserPackage;

@RestController
@RequestMapping("/classinfo")
public class ClassInfoController {
	@Autowired
	private IClassInfoService classInfoService;

	@GetMapping()
	public List<ClassInfo> getAllClassIndo() {
		return classInfoService.getAllClassInfo();
	}
	
	@PostMapping("book")
	public Booking purchasePackage(@RequestBody BookClassInfo bookClassInfo) {
		return classInfoService.bookClassInfo(bookClassInfo);
	}
}
