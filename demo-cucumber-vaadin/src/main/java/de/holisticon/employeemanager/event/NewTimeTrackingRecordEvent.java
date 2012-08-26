package de.holisticon.employeemanager.event;

import de.holisticon.employeemanager.model.TrackingRecord;

public class NewTimeTrackingRecordEvent {

	private final TrackingRecord trackingRecord;

	public NewTimeTrackingRecordEvent(TrackingRecord trackingRecord) {
		this.trackingRecord = trackingRecord;
	}

	public TrackingRecord getTrackingRecord() {
		return trackingRecord;
	}

}
