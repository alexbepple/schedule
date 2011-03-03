package de.itagile.schedule;

import java.util.ArrayList;
import java.util.List;

public class Schedule {
	
	private List<Appointment> appointments = new ArrayList<Appointment>();
	private Participant owner;

	public void add(Appointment appointment) {
		if (has(appointment)) 
			throw new AppointmentAddedTwiceException();
		appointment.invite(owner);
		appointments.add(appointment);
	}

	public boolean has(Appointment appointment) {
		return appointments.contains(appointment);
	}

	public void setOwner(Participant owner) {
		this.owner = owner;
	}
}
