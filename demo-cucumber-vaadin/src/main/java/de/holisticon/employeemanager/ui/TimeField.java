package de.holisticon.employeemanager.ui;

import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.TextField;

import de.holisticon.employeemanager.validator.TimeValidator;

@SuppressWarnings("serial")
public class TimeField extends TextField {

	public TimeField() {
		configureWidget();
	}

	public TimeField(String caption) {
		super(caption);
		configureWidget();
	}

	private void configureWidget() {
		addValidator(new TimeValidator());
		setNullRepresentation("");
	}

	static TimeField createWith(String caption, String proposal, String requiredError) {
		TimeField widget = new TimeField(caption);
		widget.setImmediate(true);
	
		widget.addValidator(new TimeValidator());
		widget.setValidationVisible(true);
	
		widget.setNullRepresentation("");
		widget.setInputPrompt(proposal);
	
		widget.setRequired(true);
		widget.setRequiredError(requiredError);
	
		widget.setWidth(50, Sizeable.UNITS_PIXELS);
		return widget;
	}

}
