package com.galeza.petclinic.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateAndTimeFormatter {

	  private DateAndTimeFormatter() {
		    throw new IllegalStateException("Utility class");
		  }
	  
	public static String getLocalDate() {
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss");
		return now.format(dateTimeFormatter);
	}
}
