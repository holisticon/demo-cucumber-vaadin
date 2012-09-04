package de.holisticon.employeemanager.handler;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;

import de.holisticon.employeemanager.event.NewTimeTrackingRecordEvent;
import de.holisticon.employeemanager.model.TimeTrackingRecord;
import de.holisticon.employeemanager.ui.MessageBox;

public class NewTimeTrackingRecordHandler {

//	private final Table view;
	private Window window;

	public NewTimeTrackingRecordHandler(Table timeTrackingRecordsTable, Window window) {
		this.window = window;
//		this.view = timeTrackingRecordsTable;
	}

	@Subscribe
	public void addTimeTrackingRecord(NewTimeTrackingRecordEvent event) {
		TimeTrackingRecord model = event.getTrackingRecord();
		// view.getContainerDataSource().addItem(model);
		MessageBox.showTray(window, "info", "your record has been saved");
	}

}
