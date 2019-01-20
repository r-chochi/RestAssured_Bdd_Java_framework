package runnerClass;


import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		plugin = {"pretty"},
//    plugin = {
//        "html:target/cucumberHtmlReport",
//        "json:target/cucumber-report.json"
//    }, // Plugin to generate HTML report and json report
    features = {"F:/TestAutomation/RestAssured_Bdd_Java_framework/src/test/java/features"},
    glue = { "stepDefinations" },
    monochrome = true, 
    tags = {"@Apitest"})


public class Runner {
	
}
