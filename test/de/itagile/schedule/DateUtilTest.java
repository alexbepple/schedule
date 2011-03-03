package de.itagile.schedule;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import de.itagile.schedule.DateUtil;

public class DateUtilTest {

	Calendar calendar = Calendar.getInstance();
	
	@Test
	public void formatsDateAs24hours() throws Exception {
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 59);
		Date time = calendar.getTime();
		assertEquals("23:59", DateUtil.format(time));
	}
	
	@Test
	public void parsesDateFromString() throws Exception {
		Date time = DateUtil.parse("23:59");
		calendar.setTime(time);
		assertEquals(23, calendar.get(Calendar.HOUR_OF_DAY));
		assertEquals(59, calendar.get(Calendar.MINUTE));
	}
	
	@Test
	public void convertsParseExceptionToRuntimeException() throws Exception {
		try {
			DateUtil.parse("wrong");
			fail();
		} catch (RuntimeException exception) {
			assertTrue(exception.getCause() instanceof ParseException);
		}
	}
}
