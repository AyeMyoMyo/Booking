package com.test.booking.service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.test.booking.enumation.BookingStatus;
import com.test.booking.enumation.UserPackageStatus;
import com.test.booking.interfaces.IClassInfoService;
import com.test.booking.model.BookClassInfo;
import com.test.booking.model.Booking;
import com.test.booking.model.ClassInfo;
import com.test.booking.model.UserPackage;
import com.test.booking.repository.BookingRepository;
import com.test.booking.repository.ClassInfoRepository;
import com.test.booking.repository.UserPackageRepository;

import lombok.AllArgsConstructor;

@Service
@Qualifier("classInfoService")
@AllArgsConstructor
public class ClassInfoServiceImpl implements IClassInfoService {
	@Autowired
	private ClassInfoRepository classInfoRepository;

	@Autowired
	private UserPackageRepository userPackageRepository;

	@Autowired
	private BookingRepository bookingRepository;

	@Override
	public List<ClassInfo> getAllClassInfo() {
		List<ClassInfo> classInfoList = classInfoRepository.findAll();
		return classInfoList;
	}

	@Override
	public Booking bookClassInfo(BookClassInfo bookClassInfo) {
		Booking booking = null;
		if (bookClassInfo.getClassInfoId() != null && bookClassInfo.getUserId() != null) {
			ClassInfo classInfo = null;
			boolean isBook = false;

			List<UserPackage> userPackageList = userPackageRepository.findByUserId(bookClassInfo.getUserId());

			Optional<ClassInfo> queryClassInfo = classInfoRepository.findById(bookClassInfo.getClassInfoId());
			if (queryClassInfo != null) {
				classInfo = queryClassInfo.get();
			}
			if (userPackageList != null && userPackageList.size() > 0)
				for (UserPackage userPackage : userPackageList) {
					if (userPackage.getCountryId() != null
							&& userPackage.getCountryId().equals(classInfo.getCountryId())
							&& userPackage.getUserPackageStatus().equals(UserPackageStatus.ACTIVE)
							&& userPackage.getRemainedCredit() != null
							&& userPackage.getRemainedCredit() >= classInfo.getRequireCredit()) {
						isBook = true;

						userPackage.setRemainedCredit(userPackage.getRemainedCredit() - classInfo.getRequireCredit());

						userPackageRepository.save(userPackage);

						break;
					}
				}
			if (isBook) {
				booking = new Booking();
				if (classInfo.getRemainedSlots() != null && classInfo.getRemainedSlots() >= 1) {

					booking.setBookingStatus(BookingStatus.BOOK);
					booking.setBookingDate(new Date());
				} else {
					booking.setBookingStatus(BookingStatus.WAITE);
					booking.setCreatedAt(new Date());
				}
				booking.setUserId(bookClassInfo.getUserId());
				booking.setClassInfoId(bookClassInfo.getClassInfoId());
				booking.setStartTime(classInfo.getStartTime());
				booking.setEndTime(classInfo.getEndTime());

				bookingRepository.save(booking);
			}
		}
		return booking;
	}

}
