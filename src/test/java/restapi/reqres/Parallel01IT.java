package restapi.reqres;

import java.lang.management.ManagementFactory;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
/*
 * plugin = { "pretty", "html:target/cucumber-reports" },,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" 
 */
@CucumberOptions(plugin = {"html:target/cucumber-reports/cucumber-html.html","json:target/cucumber-reports/cucumber.json","junit:target/cucumber-reports/cucumber.xml"}
, monochrome = true, features = "src/test/resources/feature", glue = {
				"restapi.reqres.StepDef" }, tags = "@REST", publish = true)
public class Parallel01IT {
	

}
