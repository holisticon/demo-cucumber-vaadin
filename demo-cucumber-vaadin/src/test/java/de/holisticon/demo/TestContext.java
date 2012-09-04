package de.holisticon.demo;

import java.util.List;

import org.hamcrest.Matcher;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import de.holisticon.demo.matcher.VaadinTableContentMatcher;
import de.holisticon.demo.matcher.VaadinTrayNotificationMatcher;
import de.holisticon.demo.pageobject.LoginPage;
import de.holisticon.demo.pageobject.MainPage;

public enum TestContext {

	INSTANCE;

	private final ApplicationDriver appInstance = new ApplicationDriver();
	
	private ApplicationDriver getApplication() {
		return appInstance;
	}
	
	public static Matcher<List<List<String>>> containsRows(final List<List<String>> expected) {
		return new VaadinTableContentMatcher(expected);
	}

	public static Matcher<? super WebDriver> displaysTrayNotification(String expectedMessage) {
		return new VaadinTrayNotificationMatcher(expectedMessage);
	}

	public static LoginPage loginPage() {
		if(application().currentPage() instanceof LoginPage){
			return new LoginPage(application().browser());
		} 
		throw new UnsupportedOperationException("loginPage not at display");
	}

	public static MainPage mainPage() {
		if(application().currentPage() instanceof MainPage){
			return new MainPage(application().browser());
		} 
		throw new UnsupportedOperationException("mainPage not at display");
	}

	public static boolean pageContainsElementWith(String id) {
		try {
			WebElement element = application().browser().findElement(By.id(id));
			return element!=null;
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static ApplicationDriver application() {
		return TestContext.INSTANCE.getApplication();
	}
}
