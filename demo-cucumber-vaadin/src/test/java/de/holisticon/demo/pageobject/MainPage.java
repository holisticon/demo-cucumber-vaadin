package de.holisticon.demo.pageobject;

import static de.holisticon.demo.TestContext.application;
import static de.holisticon.demo.TestContext.pageContainsElementWith;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends VaadinPageObject {

	public MainPage(WebDriver browser) {
		super(browser);
	}

	public TimeTrackingEditorPageObject openTimeTrackingEditor() {
		browser().findElement(By.id("_openTimeTrackingEditor")).click();
		return new TimeTrackingEditorPageObject(browser());
	}

	public TimeTrackingEditorPageObject timeTrackingEditor() {
		if (pageContainsElementWith("_timeTrackingForm")) {
			return new TimeTrackingEditorPageObject(application().browser());
		}
		throw new IllegalStateException("time tracking form not at display");
	}

}
