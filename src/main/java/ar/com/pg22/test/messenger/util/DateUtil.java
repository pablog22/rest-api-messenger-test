package ar.com.pg22.test.messenger.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {
	
	public static Date getNewDate() {
		return new Date();
	}
	
	public static Date getFirstDayOfYear(int year) {
		Calendar cal = new GregorianCalendar(year, 0, 1);
		cal.set(Calendar.YEAR, year);
		return cal.getTime();
	}

}
