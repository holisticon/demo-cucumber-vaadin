package de.holisticon.emapp.step.complete;

import static de.holisticon.emapp.EmployeeManagerContext.application;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class FixtureSteps {

	@Before
	public void setUp() {
		application().start();
	}

	@After
	public void cleanUp(Scenario scenario) {
		application().processFailureIn(scenario);
		application().close();
	}
}
