package de.holisticon.emapp.event;

import de.holisticon.emapp.model.TimeTrackingRecord;

public class NewTimeTrackingRecordEvent {

	private final TimeTrackingRecord trackingRecord;

	public NewTimeTrackingRecordEvent(TimeTrackingRecord trackingRecord) {
		this.trackingRecord = trackingRecord;
	}

	public TimeTrackingRecord getTrackingRecord() {
		return trackingRecord;
	}

}
