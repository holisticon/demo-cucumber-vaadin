package de.holisticon.emapp.handler;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.Table;
import com.vaadin.ui.Window;
import de.holisticon.emapp.event.NewTimeTrackingRecordEvent;
import de.holisticon.emapp.model.TimeTrackingRecord;
import de.holisticon.emapp.ui.MessageBox;

public class NewTimeTrackingRecordHandler {

	private final Table view;
	private Window window;

	public NewTimeTrackingRecordHandler(Table timeTrackingRecordsTable, Window window) {
		this.window = window;
		this.view = timeTrackingRecordsTable;
	}

	@Subscribe
	public void addTimeTrackingRecord(NewTimeTrackingRecordEvent event) {
		MessageBox.showTray(window, "info", "your record has been saved");
		TimeTrackingRecord model = event.getTrackingRecord();
		view.getContainerDataSource().addItem(model);
	}
}
