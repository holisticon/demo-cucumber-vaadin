package de.holisticon.demo.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage extends VaadinPageObject{

	public MainPage(WebDriver browser) {
		super(browser);
	}

	public TimeTrackingEditorPageObject openTimeTrackingEditor() {
		browser().findElement(By.id("_openTimeTrackingEditor")).click();
		return new TimeTrackingEditorPageObject(browser());
	}

}
