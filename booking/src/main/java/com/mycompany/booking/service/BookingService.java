package com.mycompany.booking.service;

import java.util.List;

import com.mycompany.booking.model.BookingDecorateInfo;
import com.mycompany.booking.model.BookingInfo;

public interface BookingService {
	/**
	 * Add a new booking info.
	 * 
	 * @param bookingInfo the booking info
	 */
	public void addBookingInfo(BookingInfo bookingInfo);

	/**
	 * Retrieve the booking info list.
	 * 
	 * @return the booking info list.
	 */
	public List<BookingDecorateInfo> getBookingInfoList();

}
