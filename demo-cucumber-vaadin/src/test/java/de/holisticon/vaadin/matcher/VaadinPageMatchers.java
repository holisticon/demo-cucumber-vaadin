package de.holisticon.vaadin.matcher;

import java.util.List;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;

import de.holisticon.emapp.ui.VaadinFormValidationMatcher;

public class VaadinPageMatchers {

	public static Matcher<List<List<String>>> containsRows(final List<List<String>> expected) {
		return new VaadinTableContentMatcher(expected);
	}

	public static Matcher<? super WebDriver> displaysTrayNotification(String expectedMessage) {
		return new VaadinTrayNotificationMatcher(expectedMessage);
	}

	public static VaadinFormValidationMatcher displaysValidationError(String errMsg) {
		return new VaadinFormValidationMatcher(errMsg);
	}

	
}
