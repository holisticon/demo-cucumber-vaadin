package de.holisticon.emapp.pageobject;

import static de.holisticon.emapp.EmployeeManagerContext.application;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import de.holisticon.vaadin.pageobject.VaadinPageObject;

public class MainPage extends VaadinPageObject {

	public MainPage(WebDriver browser) {
		super(browser);
	}

	public TimeTrackingEditorPageObject openTimeTrackingEditor() {
		browser().findElement(By.id("_openTimeTrackingEditor")).click();
		return new TimeTrackingEditorPageObject(browser());
	}

	public TimeTrackingEditorPageObject timeTrackingEditor() {
		if (containsId("_timeTrackingEditor")) {
			return new TimeTrackingEditorPageObject(application().browser());
		}
		throw new IllegalStateException("time tracking form not at display");
	}

}
