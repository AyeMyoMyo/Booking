package com.test.booking.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.booking.enumation.UserPackageStatus;
import com.test.booking.interfaces.IPackagesService;
import com.test.booking.model.Packages;
import com.test.booking.model.PurchasePackages;
import com.test.booking.model.UserPackage;
import com.test.booking.repository.PackagesRepository;
import com.test.booking.repository.UserPackageRepository;

import lombok.AllArgsConstructor;

@Service
@Qualifier("packagesService")
@AllArgsConstructor
public class PackagesServiceImpl implements IPackagesService {
	@Autowired
	private PackagesRepository packagesRepository;

	@Autowired
	private UserPackageRepository usePackageRepository;

	@Override
	public List<Packages> getAllPackages() {
		List<Packages> packageList = packagesRepository.findAll();
		return packageList;
	}

	@Override
	public UserPackage purchasePackage(PurchasePackages purchasePackages) {
		UserPackage newUserPackage = null;
		Optional<Packages> queryPackages = packagesRepository.findById(purchasePackages.getPackageId());
		if (queryPackages != null) {
			Packages packages = queryPackages.get();
			UserPackage userPackage = new UserPackage();
			userPackage.setPackageId(purchasePackages.getPackageId());
			userPackage.setUserId(purchasePackages.getUserId());
			userPackage.setCountryId(packages.getCountryId());
			userPackage.setPurchasedCredit(packages.getCreditCount());
			userPackage.setRemainedCredit(packages.getCreditCount());
			userPackage.setUserPackageStatus(UserPackageStatus.ACTIVE);
			userPackage.setPurchasedDate(new Date());
			userPackage.setExpireDate(packages.getExpireDate());

			newUserPackage = usePackageRepository.save(userPackage);
		}
		return newUserPackage;
	}

}
