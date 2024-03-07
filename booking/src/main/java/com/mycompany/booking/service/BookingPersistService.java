package com.mycompany.booking.service;

import java.util.List;

import com.mycompany.booking.model.BookingInfo;

public interface BookingPersistService {
	/**
	 * Save booking info.
	 * 
	 * @param bookingInfo the booking info.
	 */
	public void saveBookingInfo(BookingInfo bookingInfo);

	/**
	 * Get booking info list.
	 * 
	 * @return the booking info list.
	 */
	public List<BookingInfo> getgBookingInfoList();

}
