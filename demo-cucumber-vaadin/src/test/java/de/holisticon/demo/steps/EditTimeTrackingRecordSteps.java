package de.holisticon.demo.steps;

import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import de.holisticon.demo.ApplicationDriver;
import de.holisticon.demo.TestContext;
import de.holisticon.demo.pageobject.LoginPage;
import de.holisticon.demo.pageobject.MainPage;
import de.holisticon.demo.pageobject.TimeTrackingEditorPageObject;
import de.holisticon.demo.pageobject.VaadinTablePageObject;

public class EditTimeTrackingRecordSteps {

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
		assertThat(table.countRows(), CoreMatchers.is(1));
	}

	@Then("^the saved record is displayed$")
	public void timeTrackingTableShowsResult(DataTable expected) throws Throwable {
		List<List<String>> expectedRows = expected.raw();
		List<List<String>> actualRows = new VaadinTablePageObject(application().browser()).rows();
		assertThat(actualRows, containsRows(expectedRows));
	}

	private static Matcher<List<List<String>>> containsRows(final List<List<String>> expected) {
		return new VaadinTableContentMatcher(expected);
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
