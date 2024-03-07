package com.mycompany.booking.model;

import java.util.Objects;

public class BookingInfo {
	/**
	 * Customer name.
	 */
	private String customerName;

	/**
	 * Table size.
	 */
	private Integer tableSize;

	/**
	 * Start date.
	 */
	private String startDate;

	/**
	 * Booking hour.
	 */
	private Integer hour;

	/**
	 * Booking minute;
	 */
	private Integer minute;

	public BookingInfo(String customerName, Integer tableSize, String startDate, Integer hour, Integer minute) {
		super();
		this.customerName = customerName;
		this.tableSize = tableSize;
		this.startDate = startDate;
		this.hour = hour;
		this.minute = minute;
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

	public Integer getHour() {
		return hour;
	}

	public Integer getMinute() {
		return minute;
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerName, hour, minute, startDate, tableSize);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookingInfo other = (BookingInfo) obj;
		return Objects.equals(customerName, other.customerName) && Objects.equals(hour, other.hour)
				&& Objects.equals(minute, other.minute) && Objects.equals(startDate, other.startDate)
				&& Objects.equals(tableSize, other.tableSize);
	}

	@Override
	public String toString() {
		return "BookingInfo [customerName=" + customerName + ", tableSize=" + tableSize + ", startDate=" + startDate
				+ ", hour=" + hour + ", minute=" + minute + "]";
	}
}
