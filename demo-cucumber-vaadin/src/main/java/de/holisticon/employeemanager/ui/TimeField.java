package de.holisticon.employeemanager.ui;


import com.vaadin.terminal.Sizeable;
import com.vaadin.ui.TextField;

import de.holisticon.employeemanager.validator.TimeValidator;

@SuppressWarnings("serial")
public class TimeField extends TextField {

	public TimeField(String caption, String proposal) {
		super(caption);
		addValidator(new TimeValidator());
		setNullRepresentation("");
		setImmediate(true);
		
		addValidator(new TimeValidator());
		
		setNullRepresentation("");
		setInputPrompt(proposal);
		
		setWidth(50, Sizeable.UNITS_PIXELS);
	}

}
