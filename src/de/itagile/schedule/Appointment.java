package de.itagile.schedule;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Appointment {

	List<Participant> participants = new ArrayList<Participant>();
	private Date start;
	private Date end;

	public void invite(Participant participant) {
		participants.add(participant);
	}

	public boolean isInvited(Participant participant) {
		return participants.contains(participant);
	}

	public void setStart(String start) {
		this.start = DateUtil.parse(start);
	}

	public void setEnd(String end) {
		Date endAsDate = DateUtil.parse(end);
		if (endAsDate.before(start))
			throw new EndBeforeStartException(endAsDate, start);
		this.end = endAsDate;
	}

	public int getDuration() {
		return extractHour(end) - extractHour(start);
	}

	private int extractHour(Date zeit) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(zeit);
		return calendar.get(Calendar.HOUR_OF_DAY);
	}
}