package de.holisticon.emapp.ui;

import static java.util.Arrays.asList;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.vaadin.data.Item;
import com.vaadin.data.util.BeanItem;
import com.vaadin.terminal.UserError;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Field;
import com.vaadin.ui.Form;
import com.vaadin.ui.FormFieldFactory;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.TextArea;

import de.holisticon.emapp.ApplicationEventBus;
import de.holisticon.emapp.event.NewTimeTrackingRecordEvent;
import de.holisticon.emapp.model.TimeTrackingRecord;

@SuppressWarnings("serial")
public class TimeTrackingForm extends Form {

	TimeField timeFromField;
	TimeField timeUntilField;
	Button saveButton;

	public TimeTrackingForm() {

		setDebugId("_timeTrackingForm");

		setWriteThrough(false); // we want explicit 'apply'
		setInvalidCommitted(false); // no invalid values in datamodel
		setImmediate(true);

		setFormFieldFactory(new TimeTrackingFormFieldFactory());

		setFooter(createButtonBarWithSaveButton());

		// validation
		setValidationVisible(false);
//		timeFromField.addListener(new TimeRangeValidator());
//		timeUntilField.addListener(new TimeRangeValidator());
		

	}

	@Override
	public void attach() {
		super.attach();
//		timeFromField.addListener(new TimeRangeValidator());
//		timeUntilField.addListener(new TimeRangeValidator());
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
		saveButton = new Button("Speichern", new Button.ClickListener() {

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

	private class TimeTrackingFormFieldFactory implements FormFieldFactory {

		public Field createField(Item item, Object propertyId, Component uiContext) {

			String pid = (String) propertyId;

			if (pid.equals(TimeTrackingRecord.PROP_DATE)) {
				DateField dateField = new DateField("Datum");
				dateField.setDateFormat("dd.MM.yyyy");
				dateField.setRequired(true);
				dateField.setRequiredError("Datum muss angegeben werden");
				dateField.setLenient(true);
				dateField.setResolution(DateField.RESOLUTION_DAY);
				dateField.setDebugId("_dateField");
				return dateField;
			}
			if (pid.equals(TimeTrackingRecord.PROP_TIME_FROM)) {
				timeFromField = new TimeField("von", "08:00");
				timeFromField.setDebugId("_timeFromField");
				timeFromField.setRequired(true);
				timeFromField.setRequiredError("Anfangszeit muss angegeben werden");
				return timeFromField;
			}
			if (pid.equals(TimeTrackingRecord.PROP_TIME_UNTIL)) {
				timeUntilField = new TimeField("bis", "16:30");
				timeUntilField.setDebugId("_timeUntilField");
				timeUntilField.setRequired(true);
				timeUntilField.setRequiredError("Endzeit muss angegeben werden");
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

	class TimeRangeValidator implements ValueChangeListener {

		public void valueChange(com.vaadin.data.Property.ValueChangeEvent event) {
			validate();
		}

		boolean validate() {
			Object fromValue = getTimeFromField().getValue();
			Object untilValue = getTimeUntilField().getValue();
			if (fromValue != null && untilValue != null) {
				long from = asTime(fromValue).getTime();
				long until = asTime(untilValue).getTime();
				boolean timeRangeNotValid = ((until - from) <= 0);
				if (timeRangeNotValid) {
					setComponentError(new UserError("Startzeit muss vor Endzeit liegen"));
					saveButton.setEnabled(false);
					return false;
				} else {
					setComponentError(null);
					setValidationVisible(false);
					saveButton.setEnabled(true);
					return true;
				}
			}
			return false;
		}

		TimeField getTimeUntilField() {
			return timeUntilField;
		}

		TimeField getTimeFromField() {
			return timeFromField;
		}

		private Date asTime(Object fromValue) {
			try {
				return new SimpleDateFormat("hh:mm").parse((String) fromValue);
			} catch (ParseException e) {
				e.printStackTrace();
				return null;
			}
		}
	}
}
