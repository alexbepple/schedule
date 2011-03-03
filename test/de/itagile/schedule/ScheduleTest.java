package de.itagile.schedule;

import static org.junit.Assert.*;

import org.junit.Test;

import de.itagile.schedule.Appointment;
import de.itagile.schedule.AppointmentAddedTwiceException;
import de.itagile.schedule.Participant;
import de.itagile.schedule.Schedule;

public class ScheduleTest {

	private Schedule schedule = new Schedule();
	private Appointment appointment = new Appointment();

	@Test
	public void addsAppointment() {
		schedule.add(appointment);
		assertTrue(schedule.has(appointment));
	}

	@Test
	public void invitesOwnerToNewAppointments() throws Exception {
		Participant participant = new Participant();
		schedule.setOwner(participant);
		schedule.add(appointment);
		assertTrue(appointment.isInvited(participant));
	}
	
	@Test(expected=AppointmentAddedTwiceException.class)
	public void doesNotAllowAppointmentToBeAddedMoreThanOnce() throws Exception {
		schedule.add(appointment);
		schedule.add(appointment);
	}
}
