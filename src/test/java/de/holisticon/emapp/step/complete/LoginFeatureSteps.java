package de.holisticon.emapp.step.complete;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import de.holisticon.emapp.pageobject.LoginPage;
import de.holisticon.emapp.pageobject.MainPage;

import static de.holisticon.emapp.EmployeeManagerContext.application;
import static de.holisticon.emapp.EmployeeManagerContext.loginPage;
import static de.holisticon.vaadin.asserts.CustomFestAssertions.assertThat;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LoginFeatureSteps {

	@When("^I login with username '(.*)' and password '(.*)'$")
	public void loginAs(String username, String password) throws Throwable {
		application().waitForRendering();
		loginPage().loginWith(username, password);
	}

	@Given("^known credentials '(.*)' '(.*)'$")
	public void assumeKnownUser(String username, String password) throws Throwable {
		String failMsg = String.format("user '%s' is not registered", username);
		assertTrue(failMsg, application().existsUserWithCredentials(username, password));
	}

	@Then("^I get access to the editor.$")
	public void loginSuccessful() throws Throwable {
		assertThat(application().currentPage()).isInstanceOf(MainPage.class);
	}

	@Given("^unknown credentials '(.*)' '(.*)'$")
	public void assumeUnknownUser(String username, String password) throws Throwable {
		String failMsg = String.format("user '%s' is not registered", username);
		assertFalse(failMsg, application().existsUserWithCredentials(username, password));
	}

	@Then("^the login is denied$")
	public void loginDenied() throws Throwable {
		application().waitForRendering();
		assertThat(application().currentPage()).isInstanceOf(LoginPage.class);
	}

	@Then("^it displays an error message '(.*)'$")
	public void displaysError(String message) throws Throwable {
		String failMsg = String.format("expected error message: %s, but couldn't find it in page", message);
		assertTrue(failMsg, application().browser().getPageSource().contains(message));
	}
}
