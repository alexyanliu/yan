package com.mycompany.booking.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.mycompany.booking.Exception.DuplicateBookingException;
import com.mycompany.booking.model.BookingInfo;
import com.mycompany.booking.service.BookingPersistService;

public class BookingPersistInMemoryService implements BookingPersistService {
	/**
	 * List of booking info.
	 */
	private List<BookingInfo> bookingInfoList;

	@Override
	public synchronized void saveBookingInfo(BookingInfo bookingInfo) throws DuplicateBookingException {
		if (bookingInfoList == null) {
			bookingInfoList = new ArrayList<>();
		}

		if (bookingInfoList.contains(bookingInfo)) {
			throw new DuplicateBookingException("Duplicate booking");
		}
		
		bookingInfoList.add(bookingInfo);
	}

	@Override
	public List<BookingInfo> getgBookingInfoList() {
		return bookingInfoList;
	}
}
