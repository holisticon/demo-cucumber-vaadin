package de.holisticon.employeemanager.ui;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.data.Property;
import com.vaadin.ui.Table;

import de.holisticon.employeemanager.model.TimeTrackingRecord;

@SuppressWarnings("serial")
public class TimeTrackingTable extends Table {

	public TimeTrackingTable() {

		setColumnWidth(TimeTrackingRecord.PROP_DATE, 80);
		setColumnWidth(TimeTrackingRecord.PROP_TIME_FROM, 50);
		setColumnWidth(TimeTrackingRecord.PROP_TIME_UNTIL, 50);
		// setColumnWidth(TimeTrackingRecord.PROP_DESCRIPTION, 10);

		// set nicer headers
		setColumnHeader(TimeTrackingRecord.PROP_DATE, "Datum");
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
			return new SimpleDateFormat("dd.MM.yyyy").format(dateValue);
		}
		return super.formatPropertyValue(rowId, colId, property);
	}

}
