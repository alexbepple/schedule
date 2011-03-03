package de.itagile.schedule;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	private static final SimpleDateFormat FORMAT = new SimpleDateFormat("kk:mm");

	public static Date parse(String zeit) {
		try {
			return DateUtil.FORMAT.parse(zeit);
		} catch (ParseException exception) {
			throw new RuntimeException(exception);
		}
	}

	public static String format(Date zeit) {
		return DateUtil.FORMAT.format(zeit);
	}
}
