package de.holisticon.emapp;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(
		features = AcceptanceTests.FEATURES_DEMO,
		glue = AcceptanceTests.STEPS_DEMO,
		format = { "json:target/cucumber.json", "pretty", "html:target/cucumber-html" },
		monochrome = true)
public class AcceptanceTests {

	static final String FEATURES_DEMO = "src/test/features/demo";
	static final String STEPS_DEMO = "de.holisticon.emapp.step.demo";

	static final String FEATURES_COMPLETE = "src/test/features/complete";
	static final String STEPS_COMPLETE = "de.holisticon.emapp.step.complete";
}
