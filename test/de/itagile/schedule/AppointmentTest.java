package de.itagile.schedule;

import static org.junit.Assert.*;

import org.junit.Test;

import de.itagile.schedule.Appointment;
import de.itagile.schedule.EndBeforeStartException;
import de.itagile.schedule.Participant;

public class AppointmentTest {

	private Appointment appointment = new Appointment();

	@Test
	public void invitesParticipant() throws Exception {
		Participant participant = new Participant();
		appointment.invite(participant);
		assertTrue(appointment.isInvited(participant));
	}

	@Test
	public void doesNotAllowEndBeforeStart() throws Exception {
		appointment.setStart("12:00");
		try {
			appointment.setEnd("11:00");
			fail();
		} catch (EndBeforeStartException exception) {
			assertEquals(
					"The end (11:00) must not be before the start (12:00).",
					exception.getMessage());
		}
	}
	
	@Test
	public void calculatesDuration() throws Exception {
		appointment.setStart("11:00");
		appointment.setEnd("12:00");
		assertEquals(1, appointment.getDuration());
	}
}
