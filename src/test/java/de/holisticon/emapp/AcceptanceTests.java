package de.holisticon.emapp;

import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@Cucumber.Options(
		features = AcceptanceTests.FEATURES_COMPLETE,
		glue = AcceptanceTests.STEPS_COMPLETE,
		format = { "json:target/cucumber.json", "pretty", "html:target/cucumber-html" },
		monochrome = true)
public class AcceptanceTests {

	//static final String FEATURES_DEMO = "src/test/features/demo";
	//static final String STEPS_DEMO = "de.holisticon.emapp.step.demo";

	static final String FEATURES_COMPLETE = "src/test/features/complete";
	static final String STEPS_COMPLETE = "de.holisticon.emapp.step.complete";
}
