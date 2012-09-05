package de.holisticon.emapp.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.holisticon.vaadin.pageobject.VaadinPageObject;

public class TimeTrackingEditorPageObject extends VaadinPageObject {

	public TimeTrackingEditorPageObject(WebDriver driver) {
		super(driver);
	}

	public TimeTrackingEditorPageObject fillDescription(String description) {
		WebElement element = findById("_descriptionField");
		element.clear();
		element.sendKeys(description);
		return this;
	}

	public TimeTrackingEditorPageObject fillTimeFrom(String timeFrom) {
		findById("_timeFromField").sendKeys(timeFrom);
		return this;
	}

	public TimeTrackingEditorPageObject fillTimeUntil(String timeUntil) {
		findById("_timeUntilField").sendKeys(timeUntil);
		return this;
	}

	public TimeTrackingEditorPageObject saveRecord() {
		findById("_saveButton").click();
		return this;
	}

	private WebElement findById(String id) {
		return browser().findElement(By.id(id));
	}

}
