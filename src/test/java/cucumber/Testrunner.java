package cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="src/test/java/cucumber",glue = "Stepdefinitions",tags="@placeorder",monochrome=true)
public class Testrunner extends AbstractTestNGCucumberTests {
	

}
