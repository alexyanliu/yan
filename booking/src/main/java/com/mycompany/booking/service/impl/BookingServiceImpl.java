package com.mycompany.booking.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import com.mycompany.booking.model.BookingDecorateInfo;
import com.mycompany.booking.model.BookingInfo;
import com.mycompany.booking.service.BookingPersistService;
import com.mycompany.booking.service.BookingService;

public class BookingServiceImpl implements BookingService {
	/**
	 * Reference to booking persist service.
	 */
	private BookingPersistService bookingPersistService;

	public BookingServiceImpl(BookingPersistService bookingPersistService) {
		super();

		this.bookingPersistService = bookingPersistService;
	}

	@Override
	public void addBookingInfo(BookingInfo bookingInfo) {
		bookingPersistService.saveBookingInfo(bookingInfo);
	}

	@Override
	public List<BookingDecorateInfo> getBookingInfoList() {
		return bookingPersistService.getgBookingInfoList().stream().map(r -> new BookingDecorateInfo(r))
				.collect(Collectors.toList());
	}
}
