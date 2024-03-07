package com.mycompany.booking.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BookingUtils {
	/**
	 * Date pattern. 
	 */
	private final static String DATE_PATTERN = "yyyyMMdd";
	
	/**
	 * Display date pattern. 
	 */
	private final static String DISPLAY_DATE_PATTERN = "yyyy-MM-dd HH:mm";
	
	public static Date parseDate(String date, Integer hour, Integer minute) throws ParseException {
		Date d = new SimpleDateFormat(DATE_PATTERN).parse(date);
		
		d.setHours(hour);
		d.setMinutes(minute);
		
		return d;
	}
 
	public static String displayDate(Date d) {
		return new SimpleDateFormat(DISPLAY_DATE_PATTERN).format(d);
	}
}
