package de.holisticon.employeemanager.ui;

import static java.util.Arrays.asList;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;

import de.holisticon.demo.ApplicationEventBus;
import de.holisticon.employeemanager.event.NewTimeTrackingRecordEvent;
import de.holisticon.employeemanager.model.TimeTrackingRecord;

@SuppressWarnings("serial")
public class TimeTrackingForm extends Form {

	public TimeTrackingForm() {
		setWriteThrough(false); // we want explicit 'apply'
		setInvalidCommitted(false); // no invalid values in datamodel
		setImmediate(true);

		setFormFieldFactory(new TimeTrackingFormFieldFactory());

		setFooter(createButtonBarWithSaveButton());

	}

	@Override
	public void setItemDataSource(Item newDataSource) {
		super.setItemDataSource(newDataSource);
		// Determines which properties are shown, and in which order
		// must be set AFTER the dataSource has been set
		setVisibleItemProperties(asList(
				TimeTrackingRecord.PROP_DATE,
				TimeTrackingRecord.PROP_TIME_FROM,
				TimeTrackingRecord.PROP_TIME_UNTIL,
				TimeTrackingRecord.PROP_DESCRIPTION));
	}

	private HorizontalLayout createButtonBarWithSaveButton() {
		HorizontalLayout buttonBar = new HorizontalLayout();
		Button saveButton = new Button("Speichern", new Button.ClickListener() {
	
			@SuppressWarnings("unchecked")
			public void buttonClick(ClickEvent event) {
				commit();
				TimeTrackingRecord record = ((BeanItem<TimeTrackingRecord>) getItemDataSource()).getBean();
				ApplicationEventBus.post(new NewTimeTrackingRecordEvent(record));
			}
		});
		saveButton.setDebugId("_saveButton");
		buttonBar.addComponent(saveButton);
		return buttonBar;
	}

	private final class TimeTrackingFormFieldFactory implements FormFieldFactory {
		public Field createField(Item item, Object propertyId, Component uiContext) {

			String pid = (String) propertyId;

			if (pid.equals(TimeTrackingRecord.PROP_DATE)) {
				DateField dateField = new DateField("Datum");
				dateField.setRequired(true);
				dateField.setDateFormat("dd.MM.yyyy");
				dateField.setLenient(true);
				dateField.setResolution(DateField.RESOLUTION_DAY);
				dateField.setDebugId("_dateField");
				return dateField;
			}
			if (pid.equals(TimeTrackingRecord.PROP_TIME_FROM)) {
				TimeField timeFromField = TimeField.createWith("von", "08:00", "Anfangszeit muss angegeben werden");
				timeFromField.setDebugId("_timeFromField");
				return timeFromField;
			}
			if (pid.equals(TimeTrackingRecord.PROP_TIME_UNTIL)) {
				TimeField timeUntilField = TimeField.createWith("bis", "16:30", "Endzeit muss angegeben werden");
				timeUntilField.setDebugId("_timeUntilField");
				return timeUntilField;
			}
			if (pid.equals(TimeTrackingRecord.PROP_DESCRIPTION)) {
				TextArea descriptionField = new TextArea("Tätigkeit");
				descriptionField.setNullRepresentation("");
				descriptionField.setInputPrompt("description of your work...");
				descriptionField.setDebugId("_descriptionField");
				descriptionField.setWidth("50%");
				return descriptionField;
			}

			return null;
		}
	}
}
