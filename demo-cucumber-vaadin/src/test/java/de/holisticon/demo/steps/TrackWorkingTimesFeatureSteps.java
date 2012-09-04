package de.holisticon.demo.steps;

import static de.holisticon.demo.TestContext.application;
import static de.holisticon.demo.TestContext.containsRows;
import static de.holisticon.demo.TestContext.displaysTrayNotification;
import static de.holisticon.demo.TestContext.mainPage;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.fail;

import java.util.List;

import org.hamcrest.CoreMatchers;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.table.DataTable;
import de.holisticon.demo.pageobject.TimeTrackingEditorPageObject;
import de.holisticon.demo.pageobject.VaadinTablePageObject;

public class TrackWorkingTimesFeatureSteps {

	@When("^I record an entry for (.*) on (.*) from (.*) to (.*)$")
	public void recordAnEntry(String description, String date, String timeFrom, String timeUntil) throws Throwable {

		application().waitForRendering();
		TimeTrackingEditorPageObject editor = mainPage().openTimeTrackingEditor();

		application().waitForRendering();
		editor.fillTimeFrom(timeFrom)
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
		assertThat(actualRows, containsRows(expectedRows));
	}

	@Then("^a notification '(.*)' appears$")
	public void showsTrayNotification(String message) throws Throwable {
		application().waitForRendering();
		assertThat(application().browser(), displaysTrayNotification(message));
	}

	@Then("^form displays validation error (.*)$")
	public void displaysErrorMessage(String expectedMessage) throws Throwable {
		try {
			WebElement errMsg = application().browser().findElement(By.className("v-form-errormessage"));
			assertThat(errMsg.getText(), is(expectedMessage));
		} catch (NoSuchElementException ex) {
			fail("error message not displayed");
		}
	}

}
