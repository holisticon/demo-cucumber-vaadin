package de.holisticon.webdriver;

import java.io.File;

import com.google.common.base.Strings;
import cucumber.api.Scenario;
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

import de.holisticon.emapp.TestServer;
import de.holisticon.emapp.pageobject.LoginPage;

public class ApplicationDriver extends ExternalResource {

	public static final String SYSTEM_VIRTUAL_DISPLAY_VARIABLE = "DISPLAY";
	private ApplicationConfig config = new ApplicationConfig();
	private WebDriver browser;

	public ApplicationDriver() {
		super();
	}

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
		TestServer.INSTANCE.start();
		browser().get(config.applicationUrl());
		return new LoginPage(browser);
	}

	public WebDriver browser() {
		if (browser == null) {
			if (runHeadless()) {
				FirefoxBinary binary = new FirefoxBinary(new File(
						config.pathToBrowser()));
				binary.setEnvironmentProperty(SYSTEM_VIRTUAL_DISPLAY_VARIABLE,
						config.display());
				browser = new FirefoxDriver(binary, null);
			} else {
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
		TestServer.INSTANCE.stop();
		return this;
	}

	public ApplicationDriver processFailureIn(Scenario scenario) {
		if (scenario.getStatus().equals("failed")) {
			takeScreenshotOf(scenario);
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
		return !Strings.isNullOrEmpty(config.display());
	}

	private void takeScreenshotOf(Scenario scenario) {
		try {
			byte[] screenshot = ((TakesScreenshot) browser())
					.getScreenshotAs(OutputType.BYTES);
			scenario.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err
					.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}

	public void restart() {
		close().start();
	}

	public ApplicationDriver pageRefresh() {
		browser.navigate().refresh();
		return this;
	}

	public boolean pageContainsId(String id) {
		return findById(id) != null;
	}

	public WebElement findById(String id) {
		try {
			return browser().findElement(By.id(id));
		} catch (NoSuchElementException nse) {
			return null;
		}
	}

}