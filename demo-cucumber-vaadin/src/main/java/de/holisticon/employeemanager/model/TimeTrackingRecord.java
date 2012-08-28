package de.holisticon.employeemanager.model;

import java.util.Date;

public class TimeTrackingRecord {

	public static final String PROP_DATE = "date";
	public static final String PROP_TIME_UNTIL = "timeUntil";
	public static final String PROP_TIME_FROM = "timeFrom";
	public static final String PROP_DESCRIPTION = "description";

	private Date date;

	private String timeFrom;

	private String timeUntil;

	private String description;

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getTimeFrom() {
		return timeFrom;
	}

	public void setTimeFrom(String timeFrom) {
		this.timeFrom = timeFrom;
	}

	public String getTimeUntil() {
		return timeUntil;
	}

	public void setTimeUntil(String timeUntil) {
		this.timeUntil = timeUntil;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
