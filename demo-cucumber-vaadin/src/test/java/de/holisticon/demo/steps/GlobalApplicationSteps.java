package de.holisticon.demo.steps;

import cucumber.annotation.After;
import cucumber.annotation.Before;
import cucumber.runtime.ScenarioResult;
import de.holisticon.demo.ApplicationDriver;
import de.holisticon.demo.TestContext;

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

	private ApplicationDriver application() {
		return TestContext.INSTANCE.getApplication();
	}

}
