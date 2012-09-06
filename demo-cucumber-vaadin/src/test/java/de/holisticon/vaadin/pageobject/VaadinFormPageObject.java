package de.holisticon.vaadin.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VaadinFormPageObject extends VaadinPageObject {

	public VaadinFormPageObject(WebDriver browser) {
		super(browser);
	}

	public String formError() {
		try {
			WebElement findElement = browser().findElement(By.className("v-form-errormessage"));
			return findElement.getText();
		} catch (NoSuchElementException ex) {
			return null;
		}

	}

}
