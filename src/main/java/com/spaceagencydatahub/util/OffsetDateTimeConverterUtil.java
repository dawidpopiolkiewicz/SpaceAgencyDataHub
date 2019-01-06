package com.spaceagencydatahub.util;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

@Component
public class OffsetDateTimeConverterUtil {

	public OffsetDateTime convertStringToOffsetDateTime(String stringDate) {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("YYYY-MM-DD'T'hh:mmTZD");
		String date = stringDate;
		OffsetDateTime offSetDateTime = OffsetDateTime.parse(date, dateTimeFormatter);
		return offSetDateTime;
	}
	
	
	
}
