package de.holisticon.vaadin.matcher;

import java.util.List;

import org.hamcrest.Matcher;
import org.openqa.selenium.WebDriver;

public class VaadinPageMatchers {

	public static Matcher<List<List<String>>> containsRows(final List<List<String>> expected) {
		return new VaadinTableContentMatcher(expected);
	}

	public static Matcher<? super WebDriver> displaysTrayNotification(String expectedMessage) {
		return new VaadinTrayNotificationMatcher(expectedMessage);
	}

}
