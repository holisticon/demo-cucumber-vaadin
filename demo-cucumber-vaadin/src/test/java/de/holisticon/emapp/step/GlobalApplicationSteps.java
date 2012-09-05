package de.holisticon.emapp.step;

import static de.holisticon.emapp.EmployeeManagerContext.application;
import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.runtime.ScenarioResult;

public class GlobalApplicationSteps {

	@Before
	public void setUp() {
		application().start();
	}

	@After
	public void cleanUp(ScenarioResult result) {
		application().processFailureIn(result);
		application().close();
	}


}
