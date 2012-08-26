package de.holisticon.employeemanager.handler;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Table;

import de.holisticon.employeemanager.event.NewTimeTrackingRecordEvent;
import de.holisticon.employeemanager.model.TrackingRecord;

public class NewTimeTrackingRecordHandler {

	private final Table view;

	public NewTimeTrackingRecordHandler(Table timeTrackingRecordsTable) {
		this.view = timeTrackingRecordsTable;
	}
	
	@Subscribe
	public void addTimeTrackingRecord(NewTimeTrackingRecordEvent event) {
		TrackingRecord model = event.getTrackingRecord();
		view.getContainerDataSource().addItem(model);
	}

}
