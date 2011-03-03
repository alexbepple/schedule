package de.itagile.schedule;

import java.util.Date;

public class EndBeforeStartException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public EndBeforeStartException(Date end, Date start) {
		super("The end (" + DateUtil.format(end)
				+ ") must not be before the start ("
				+ DateUtil.format(start) + ").");
	}

}
