package cucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features", glue = "stepDefinitions", plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})


//        tags = "@firstTest"
public class TestRunner extends AbstractTestNGCucumberTests {

}