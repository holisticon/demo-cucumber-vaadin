package de.holisticon.demo.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import de.holisticon.demo.ApplicationDriver;
import de.holisticon.demo.TestContext;
import de.holisticon.demo.pageobject.LoginPage;
import de.holisticon.demo.pageobject.MainPage;
import de.holisticon.demo.pageobject.TimeTrackingEditorPageObject;
import de.holisticon.demo.pageobject.VaadinTablePageObject;

public class EditTimeTrackingRecordSteps {

	@Given("^I'm an employee with username '(.*)' and password '(.*)'$")
	public void loginAs(String username, String password) throws Throwable {
		application().waitForRendering();
		loginPage().loginAs(username, password);
	}

	@When("^I record an entry for '(.*)' on '(.*)' from '(.*)' to '(.*)'$")
	public void recordAnEntry(String description, String date, String timeFrom, String timeUntil) throws Throwable {

		application().waitForRendering();
		TimeTrackingEditorPageObject editor = mainPage().openTimeTrackingEditor();

		application().waitForRendering();
		editor.fillDate(date)
				.fillDescription(description)
				.fillTimeFrom(timeFrom)
				.fillTimeUntil(timeUntil)
				.saveRecord();
	}

	@Then("^the record is saved$")
	public void timeTrackingRecordTableContains() throws Throwable {
		VaadinTablePageObject table = new VaadinTablePageObject(application().browser());
		assertThat(table.countRows(), is(1));
	}

	private MainPage mainPage() {
		return new MainPage(application().browser());
	}

	private LoginPage loginPage() {
		return new LoginPage(application().browser());
	}

	private ApplicationDriver application() {
		return TestContext.INSTANCE.getApplication();
	}
}
