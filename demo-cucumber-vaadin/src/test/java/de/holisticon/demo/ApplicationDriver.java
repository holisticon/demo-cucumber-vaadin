package de.holisticon.demo;

import static org.apache.commons.lang3.StringUtils.isNotEmpty;

import java.io.File;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.runtime.ScenarioResult;
import de.holisticon.demo.pageobject.VaadinPageObject;

public class ApplicationDriver extends ExternalResource {

	public static final String SYSTEM_VIRTUAL_DISPLAY_VARIABLE = "DISPLAY";

	private ApplicationConfig config = new ApplicationConfig();
	private WebDriver actualDriver;

	@Override
	protected void before() throws Throwable {
		super.before();
		driver();
	}

	@Override
	protected void after() {
		super.after();
		actualDriver.close();
	}

	public VaadinPageObject start() {
		driver().get(config.applicationUrl());
		return new VaadinPageObject(actualDriver);
	}

	public WebDriver driver() {
		if (actualDriver == null) {
			if (runHeadless()) {
				FirefoxBinary binary = new FirefoxBinary(new File(config.pathToBrowser()));
				binary.setEnvironmentProperty(SYSTEM_VIRTUAL_DISPLAY_VARIABLE, config.display());
				actualDriver = new FirefoxDriver(binary, null);
			}
			else {
				actualDriver = new FirefoxDriver();
			}
		}
		return actualDriver;
	}

	public ApplicationDriver close() {
		actualDriver.close();
		actualDriver = null;
		return this;
	}

	public ApplicationDriver process(ScenarioResult result) {
		if (result.getStatus().equals("failed")) {
			takeScreenshotOf(result);
		}
		return this;
	}

	public ApplicationDriver waitForRendering() {
		try {
			Thread.sleep(1000 * config.delayForRendering());
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return this;
	}

	private boolean runHeadless() {
		return isNotEmpty(config.display());
	}

	private void takeScreenshotOf(ScenarioResult result) {
		try {
			byte[] screenshot = ((TakesScreenshot) driver()).getScreenshotAs(OutputType.BYTES);
			result.embed(screenshot, "image/png");
		} catch (WebDriverException somePlatformsDontSupportScreenshots) {
			System.err.println(somePlatformsDontSupportScreenshots.getMessage());
		}
	}

	public void restart() {
		close().start();
	}

	public ApplicationDriver refresh() {
		actualDriver.navigate().refresh();
		return this;
	}

}
