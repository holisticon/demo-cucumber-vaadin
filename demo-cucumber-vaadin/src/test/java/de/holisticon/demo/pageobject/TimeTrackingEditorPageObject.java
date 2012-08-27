package de.holisticon.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TimeTrackingEditorPageObject extends VaadinPageObject {

	public TimeTrackingEditorPageObject(WebDriver driver) {
		super(driver);
	}

	public TimeTrackingEditorPageObject description(String description) {
		WebElement element = findById("_descriptionField");
		element.clear();
		element.sendKeys(description);
		return this;
	}

	public TimeTrackingEditorPageObject date(String date) {
		findById("_dateField").findElement(By.tagName("input")).sendKeys(date);
		return this;
	}


	public TimeTrackingEditorPageObject timeFrom(String timeFrom) {
		findById("_timeFromField").findElement(By.tagName("input")).sendKeys(timeFrom);
		return this;
	}

	public TimeTrackingEditorPageObject timeUntil(String timeUntil) {
		findById("_timeUntilField").findElement(By.tagName("input")).sendKeys(timeUntil);
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
