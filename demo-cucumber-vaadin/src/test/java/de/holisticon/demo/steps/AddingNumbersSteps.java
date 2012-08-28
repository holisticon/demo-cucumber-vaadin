package de.holisticon.demo.steps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import cucumber.annotation.en.Given;
import cucumber.annotation.en.Then;
import cucumber.annotation.en.When;
import de.holisticon.demo.ApplicationDriver;
import de.holisticon.demo.TestContext;

public class AddingNumbersSteps {

	private int actualResult;

	@Given("^an application$")
	public void an_application() throws Throwable {
		// TODO nothing 
	}

	@When("^adding (\\d+) and (\\d+)$")
	public void adding_and(int op1, int op2) throws Throwable {
		actualResult = op1 + op2;
	}

	@Then("^the result is (\\d+)$")
	public void the_result_is(int expectedResult) throws Throwable {
		assertThat(actualResult, is(expectedResult));
	}

	private ApplicationDriver application() {
		return TestContext.INSTANCE.getApplication();
	}
}
