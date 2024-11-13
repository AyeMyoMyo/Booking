package com.test.booking.interfaces;

import java.util.List;

import com.test.booking.model.Packages;
import com.test.booking.model.PurchasePackages;
import com.test.booking.model.UserPackage;

public interface IPackagesService {

	List<Packages> getAllPackages();
	
	UserPackage purchasePackage(PurchasePackages purchasePackages );

}
