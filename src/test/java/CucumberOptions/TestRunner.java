package CucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "Features/PlaceValidation.feature", plugin = { "json:target/cucumber-report/cucumber.json",
		"html:target/cucumber-report/cucumber.html" }, glue = { "StepDefinitions" }, dryRun = false)
public class TestRunner {

	// tags = "@AddPlace or @DeletePlace"

}
