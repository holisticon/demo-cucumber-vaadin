package de.holisticon.emapp.step.complete;

import static de.holisticon.emapp.EmployeeManagerContext.application;
import static de.holisticon.emapp.EmployeeManagerContext.loginPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en_au.When;
import de.holisticon.emapp.pageobject.LoginPage;
import de.holisticon.emapp.pageobject.MainPage;

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
		assertThat(application().currentPage(), is(instanceOf(MainPage.class)));
	}

	@Given("^unknown credentials '(.*)' '(.*)'$")
	public void assumeUnknownUser(String username, String password) throws Throwable {
		String failMsg = String.format("user '%s' is not registered", username);
		assertFalse(failMsg, application().existsUserWithCredentials(username, password));
	}

	@Then("^the login is denied$")
	public void loginDenied() throws Throwable {
		application().waitForRendering();
		assertThat(application().currentPage(), is(instanceOf(LoginPage.class)));
	}

	@Then("^it displays an error message '(.*)'$")
	public void displaysError(String message) throws Throwable {
		String failMsg = String.format("expected error message: %s, but couldn't find it in page", message);
		assertTrue(failMsg, application().browser().getPageSource().contains(message));
	}
}
