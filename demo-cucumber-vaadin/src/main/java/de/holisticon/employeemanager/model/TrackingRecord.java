package de.holisticon.employeemanager.model;

import java.util.Date;

public class TrackingRecord {

	private Date date;
	
	private Date timeFrom;
	
	private Date timeUntil;
	
	private String description;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(Date timeFrom) {
		this.timeFrom = timeFrom;
	}

	public Date getTimeUntil() {
		return timeUntil;
	}

	public void setTimeUntil(Date timeUntil) {
		this.timeUntil = timeUntil;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
