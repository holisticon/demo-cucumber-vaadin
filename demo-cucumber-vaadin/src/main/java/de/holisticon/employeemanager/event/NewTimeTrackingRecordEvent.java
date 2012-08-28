package de.holisticon.employeemanager.event;

import de.holisticon.employeemanager.model.TimeTrackingRecord;

public class NewTimeTrackingRecordEvent {

	private final TimeTrackingRecord trackingRecord;

	public NewTimeTrackingRecordEvent(TimeTrackingRecord trackingRecord) {
		this.trackingRecord = trackingRecord;
	}

	public TimeTrackingRecord getTrackingRecord() {
		return trackingRecord;
	}

}
