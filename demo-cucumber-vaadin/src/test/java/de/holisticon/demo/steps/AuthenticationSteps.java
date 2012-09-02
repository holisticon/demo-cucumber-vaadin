package de.holisticon.demo.steps;

import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import de.holisticon.demo.ApplicationDriver;
import de.holisticon.demo.TestContext;
import de.holisticon.demo.pageobject.LoginPage;

public class AuthenticationSteps {

	@Given("^I'm an employee with username '(.*)' and password '(.*)'$")
	public void loginAs(String username, String password) throws Throwable {
		application().waitForRendering();
		loginPage().loginAs(username, password);
	}

	@Then("^login is denied$")
	public void loginFailure() throws Throwable {
		application().waitForRendering();
		application().browser().getPageSource().contains("unbekannter user");
	}

	private LoginPage loginPage() {
		return new LoginPage(application().browser());
	}

	private ApplicationDriver application() {
		return TestContext.INSTANCE.getApplication();
	}
}
