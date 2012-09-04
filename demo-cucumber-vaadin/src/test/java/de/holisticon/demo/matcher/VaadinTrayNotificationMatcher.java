package de.holisticon.demo.matcher;

import org.apache.commons.lang3.StringUtils;
import org.hamcrest.Description;
import org.hamcrest.TypeSafeMatcher;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VaadinTrayNotificationMatcher extends TypeSafeMatcher<WebDriver> {
	private final String expectedMessage;
	private String actucalMessage;

	public VaadinTrayNotificationMatcher(String expectedMessage) {
		this.expectedMessage = expectedMessage;
	}

	public void describeTo(Description description) {
		description.appendText("tray notificiation: ").appendText(expectedMessage);
	}

	@Override
	protected void describeMismatchSafely(WebDriver item, Description mismatchDescription) {
		if (StringUtils.isEmpty(actucalMessage)) {
			mismatchDescription.appendText(" couldn't find tray notification");
		} else {
			mismatchDescription.appendText("message was: ");
			mismatchDescription.appendText(actucalMessage);
		}
	}

	@Override
	protected boolean matchesSafely(WebDriver browser) {
		try {
			WebElement notification = browser.findElement(By.className("v-Notification-tray"));
			actucalMessage = notification.getText();
			return actucalMessage.contains(expectedMessage);
		} catch (NoSuchElementException ex) {
		}
		return false;
	}
}