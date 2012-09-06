package de.holisticon.emapp.step.complete;

import static de.holisticon.emapp.EmployeeManagerContext.application;
import static de.holisticon.emapp.EmployeeManagerContext.mainPage;
import static de.holisticon.vaadin.matcher.VaadinPageMatchers.displaysTrayNotification;
import static de.holisticon.vaadin.matcher.VaadinPageMatchers.displaysValidationError;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;

import org.hamcrest.CoreMatchers;

import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import de.holisticon.emapp.pageobject.TimeTrackingEditorPageObject;
import de.holisticon.vaadin.matcher.VaadinPageMatchers;
import de.holisticon.vaadin.pageobject.VaadinTablePageObject;

public class TrackWorkingTimesFeatureSteps {

	@When("^I record an entry for (.*) on (.*) from (.*) to (.*)$")
	public void recordAnEntry(String description, String date, String timeFrom, String timeUntil) throws Throwable {

		application().waitForRendering();
		TimeTrackingEditorPageObject editor = mainPage().openTimeTrackingEditor();

		application().waitForRendering();
		editor.fillDate(date)
				.fillTimeFrom(timeFrom)
				.fillTimeUntil(timeUntil)
				.fillDescription(description)
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
		assertThat(actualRows, VaadinPageMatchers.containsRows(expectedRows));
	}

	@Then("^a notification '(.*)' appears$")
	public void showsTrayNotification(String message) throws Throwable {
		application().waitSeconds(5);
		assertThat(application().browser(), displaysTrayNotification(message));
	}

	@Then("^form displays validation error (.*)$")
	public void displaysErrorMessage(String expectedMessage) throws Throwable {
		assertThat(mainPage().timeTrackingEditor().form(), displaysValidationError(expectedMessage));
	}

}
