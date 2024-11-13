package com.test.booking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.booking.interfaces.IPackagesService;
import com.test.booking.model.Packages;
import com.test.booking.model.PurchasePackages;
import com.test.booking.model.UserPackage;

@RestController
@RequestMapping("/packages")
public class PackageController {

	@Autowired
	private IPackagesService packagesService;

	@GetMapping()
	public List<Packages> getAllPackages() {
		return packagesService.getAllPackages();
	}

	@PostMapping("purchase")
	public UserPackage purchasePackage(@RequestBody PurchasePackages purchasePackages) {
		return packagesService.purchasePackage(purchasePackages);
	}
}
