package com.mycompany.booking.service;

import java.util.List;

import com.mycompany.booking.Exception.DuplicateBookingException;
import com.mycompany.booking.model.BookingDecorateInfo;
import com.mycompany.booking.model.BookingInfo;

public interface BookingService {
	/**
	 * Add a new booking info.
	 * 
	 * @param bookingInfo the booking info
	 * @throws DuplicateBookingException throws Exception if there is.
	 */
	public void addBookingInfo(BookingInfo bookingInfo) throws DuplicateBookingException;

	/**
	 * Retrieve the booking info list.
	 * 
	 * @return the booking info list.
	 */
	public List<BookingDecorateInfo> getBookingInfoList();
}
