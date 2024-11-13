package com.test.booking.interfaces;

import java.util.List;

import com.test.booking.model.BookClassInfo;
import com.test.booking.model.Booking;
import com.test.booking.model.ClassInfo;

public interface IClassInfoService {
	List<ClassInfo> getAllClassInfo();
	
	Booking bookClassInfo(BookClassInfo bookClassInfo);
}
