package TestRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(tags="@sanity or @smoke and not @regression ",features={"src/test/resources/FeaturesWithTags"},glue= {"StepDefinitions"},plugin = {"pretty","html:target/htmlCucumberReport.html"})
public class TestRunnerFeatureWithTags extends AbstractTestNGCucumberTests{
	

}
