package de.holisticon.demo;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.File;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.runtime.ScenarioResult;
import de.holisticon.demo.pageobject.LoginPage;
import de.holisticon.demo.pageobject.MainPage;
import de.holisticon.demo.pageobject.VaadinPageObject;
import de.holisticon.employeemanager.service.UserManagementService;

public class ApplicationDriver extends ExternalResource {

	public static final String SYSTEM_VIRTUAL_DISPLAY_VARIABLE = "DISPLAY";

	private ApplicationConfig config = new ApplicationConfig();
	private WebDriver browser;

	@Override
	protected void before() throws Throwable {
		super.before();
		browser();
	}

	@Override
	protected void after() {
		super.after();
		browser.close();
	}

	public LoginPage start() {
		browser().get(config.applicationUrl());
		return new LoginPage(browser);
	}

	public WebDriver browser() {
		if (browser == null) {
			if (runHeadless()) {
				FirefoxBinary binary = new FirefoxBinary(new File(config.pathToBrowser()));
				binary.setEnvironmentProperty(SYSTEM_VIRTUAL_DISPLAY_VARIABLE, config.display());
				browser = new FirefoxDriver(binary, null);
			}
			else {
				browser = new FirefoxDriver();
			}
		}
		return browser;
	}

	public ApplicationDriver close() {
		if (browser != null) {
			browser.close();
			browser = null;
		}
		return this;
	}

	public ApplicationDriver processFailureIn(ScenarioResult result) {
		if (result.getStatus().equals("failed")) {
			takeScreenshotOf(result);
		}
		return this;
	}

	public ApplicationDriver waitForRendering() {
		waitSeconds(config.delayForRendering());
		return this;
	}

	public void waitSeconds(int seconds) {
		try {
			Thread.sleep(1000 * seconds);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private boolean runHeadless() {
		return isNotEmpty(config.display());
	}

	private void takeScreenshotOf(ScenarioResult result) {
		try {
			byte[] screenshot = ((TakesScreenshot) browser()).getScreenshotAs(OutputType.BYTES);
			result.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}

	public void restart() {
		close().start();
	}

	public ApplicationDriver refresh() {
		browser.navigate().refresh();
		return this;
	}

	public boolean knowsUserWithCredentials(String username, String password) {
		return new UserManagementService().exists(username, password);
	}

	public VaadinPageObject currentPage() {
		if (pageContainsId("_loginComponent")){
			return new LoginPage(browser);
		}

		if (pageContainsId("_mainComponent")){
			return new MainPage(browser);
		}
		
		throw new IllegalStateException("invalid display state, only mainpage or loginpage are allowed");

	}

	private boolean pageContainsId(String id) {
		return findById(id) != null;
	}

	private WebElement findById(String id) {
		try {
			return browser.findElement(By.id(id));
		} catch (NoSuchElementException nse) {
			return null;
		}
	}

}
