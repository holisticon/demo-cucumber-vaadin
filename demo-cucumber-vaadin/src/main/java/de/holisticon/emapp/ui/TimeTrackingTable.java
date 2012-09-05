package de.holisticon.emapp.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.data.Property;
import com.vaadin.ui.Table;

import de.holisticon.emapp.model.TimeTrackingRecord;

@SuppressWarnings("serial")
public class TimeTrackingTable extends Table {

	public TimeTrackingTable() {

		setColumnWidth(TimeTrackingRecord.PROP_TIME_FROM, 80);
		setColumnWidth(TimeTrackingRecord.PROP_TIME_UNTIL, 80);
		// setColumnWidth(TimeTrackingRecord.PROP_DESCRIPTION, 10);

		// set nicer headers
		setColumnHeader(TimeTrackingRecord.PROP_TIME_FROM, "von");
		setColumnHeader(TimeTrackingRecord.PROP_TIME_UNTIL, "bis");
		setColumnHeader(TimeTrackingRecord.PROP_DESCRIPTION, "Tätigkeit");

		setDebugId("_timeTrackingRecordsTable");
	}

	@Override
	protected String formatPropertyValue(Object rowId, Object colId, Property property) {
		Object value = property.getValue();
		if (value instanceof Date) {
			Date dateValue = (Date) value;
			return new SimpleDateFormat("dd.MM.yyyy hh:mm").format(dateValue);
		}
		return super.formatPropertyValue(rowId, colId, property);
	}

}
