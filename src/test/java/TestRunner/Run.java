package TestRunner;

//import org.junit.runner.RunWith;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

//@RunWith(Cucumber.class)
@CucumberOptions(
//		features = ".\\Features", // runs all the feature file in folder
//		features = {".\\Features\\CheckEligibility.feature",".\\Features\\LoginFeatures.feature"}, //Runs multiple specified files
		features = ".\\Features\\LoginFeatures.feature", // Runs multiple specified files

		glue = "StepDefination", 
		dryRun = false, 
		monochrome = true, 
		tags = "@sanity and not @regression", 
		plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" } // ONLY Extent report

)
//plugin = {"html:target/cucumber-reports/report1.html"}
//plugin = {"pretty","json:target/cucumber-reports/report_json.json"}
//{"pretty","junit:target/cucumber-reports/report_xml.xml"
public class Run extends AbstractTestNGCucumberTests {

}
