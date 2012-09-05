package de.holisticon.emapp.handler;

import com.google.common.eventbus.Subscribe;
import com.vaadin.ui.HorizontalSplitPanel;

import de.holisticon.emapp.event.SwitchToTimeTrackingRecordEditorEvent;
import de.holisticon.emapp.ui.TimeTrackingEditor;

public class SwitchToTimeTrackingRecordEditorEventHandler {

	private final HorizontalSplitPanel masterDetails;

	public SwitchToTimeTrackingRecordEditorEventHandler(HorizontalSplitPanel masterDetails) {
		this.masterDetails = masterDetails;
	}

	@Subscribe
	public void handleEvent(SwitchToTimeTrackingRecordEditorEvent event) {
		masterDetails.setSecondComponent(new TimeTrackingEditor());
	}
}
