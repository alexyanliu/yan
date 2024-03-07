package com.mycompany.booking.model;

import java.util.Objects;

import com.mycompany.booking.utils.BookingUtils;

public class BookingDecorateInfo {
	/**
	 * Customer name.
	 */
	private String customerName;

	/**
	 * Table size.
	 */
	private Integer tableSize;

	/**
	 * Booking start date.
	 */
	private String startDate;

	/**
	 * Booking end date.
	 */
	private String endDate;

	public BookingDecorateInfo(BookingInfo bookingInfo) {
		super();

		customerName = bookingInfo.getCustomerName();
		tableSize = bookingInfo.getTableSize();

		try {
			startDate = BookingUtils.displayDate(
					BookingUtils.parseDate(bookingInfo.getStartDate(), bookingInfo.getHour(), bookingInfo.getMinute()));
			endDate = BookingUtils.displayDate(
					BookingUtils.parseDate(bookingInfo.getStartDate(), bookingInfo.getHour() + 2, bookingInfo.getMinute()));
		} catch (java.text.ParseException e) {
			e.printStackTrace();
		}
	}

	public String getCustomerName() {
		return customerName;
	}

	public Integer getTableSize() {
		return tableSize;
	}

	public String getStartDate() {
		return startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerName, endDate, startDate, tableSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingDecorateInfo other = (BookingDecorateInfo) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(endDate, other.endDate)
				&& Objects.equals(startDate, other.startDate) && Objects.equals(tableSize, other.tableSize);
	}

	@Override
	public String toString() {
		return "BookingDecorateInfo [customerName=" + customerName + ", tableSize=" + tableSize + ", startDate="
				+ startDate + ", endDate=" + endDate + "]";
	}
}
