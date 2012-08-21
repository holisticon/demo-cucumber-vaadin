package de.holisticon.demo.cucumber.vaadin;

import org.junit.runner.RunWith;

import cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@Cucumber.Options(features="src/test/features", glue="de.holisticon.demo.steps", format="json:target/cucumber.json")
public class AcceptanceTests {}
