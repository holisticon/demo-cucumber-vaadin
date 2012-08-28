package de.holisticon.employeemanager.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.vaadin.data.Validator;

@SuppressWarnings("serial")
public class TimeValidator implements Validator {

	public static final String TIME24HOURS_PATTERN = "([01]?[0-9]|2[0-3]):[0-5][0-9]";

	public void validate(Object value) throws InvalidValueException {
		if (!isValid(value)) {
			throw new InvalidValueException(String.format("Datum %s ungültig", value));
		}
	}

	public boolean isValid(Object value) {
		if (value != null) {
			Pattern pattern = Pattern.compile(TIME24HOURS_PATTERN);
			Matcher matcher = pattern.matcher((CharSequence) value);
			return matcher.matches();
		}
		return false;
	}
}