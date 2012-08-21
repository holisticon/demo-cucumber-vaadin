package de.holisticon.demo.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import cucumber.runtime.PendingException;
import de.holisticon.demo.ApplicationDriver;
import de.holisticon.demo.pageobject.VaadinPageObject;

public class StaffMemberEvaluationViewSteps {

	
	private VaadinPageObject page;

	@Before
	public void setUp() {
		page = new ApplicationDriver().start();
	}
	
	@After
	public void cleanUp() {
		page.driver().close();
	}
	
	@Given("^I'm head of staff$")
	public void I_m_head_of_staff() throws Throwable {
		//TODO login
		assertThat(page, is(notNullValue()));
	}

	@When("^opening the evaluation report view$")
	public void opening_the_evaluation_report_view() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^I have access to the reports of all members$")
	public void I_have_access_to_the_reports_of_all_members() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Given("^I'm clerk$")
	public void I_m_clerk() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Then("^I have access to my own report only$")
	public void I_have_access_to_my_own_report_only() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

	@Given("^I'm team leader$")
	public void I_m_team_leader() throws Throwable {
		// Express the Regexp above with the code you wish you had
		throw new PendingException();
	}

}
