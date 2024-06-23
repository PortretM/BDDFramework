package TestRunner;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="",features={"src/test/resources/Features/login.feature"},glue= {"StepDefinitions"},plugin = {"pretty","html:target/htmlCucumberReport.html"})
public class TestRunner extends AbstractTestNGCucumberTests{
	

}
