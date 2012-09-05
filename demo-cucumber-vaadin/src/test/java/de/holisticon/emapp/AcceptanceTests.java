package de.holisticon.emapp;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;

@RunWith(Cucumber.class)
@Cucumber.Options(features = "src/test/features",
		glue = "de.holisticon.emapp.step",
		format = { "json:target/cucumber.json", "pretty", "html:target/cucumber-html" },
		monochrome = true)
public class AcceptanceTests {
}
