package restapi.reqres.StepDef;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.management.ManagementFactory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import restapi.reqres.util.CommonUtils;
import restapi.reqres.util.ConstantKeys;
import restapi.reqres.util.RestRequest;
import restapi.reqres.util.TestContainer;

public class CommonSteps {
	final static Logger logger = LogManager.getLogger(CommonSteps.class);
			
	TestContainer testContainer;

	public CommonSteps(TestContainer testContainer) {
		this.testContainer = testContainer;
	}
	
	@Given("the baseuri {string}")
	public void the_baseuri(String uri) {
		testContainer.getRestRequest().setUri(uri);
	}
	
	@Given("the baseuri")
	public void the_baseuri() throws FileNotFoundException, IOException {
		testContainer.getRestRequest().setUri(CommonUtils.getProperty(RestRequest.class,ConstantKeys.uri));
	}
	
	@When("the endpoint is set to {string}")
	public void the_name_and_the_job(String endPoint) {
		RestAssured.baseURI = testContainer.getRestRequest().getUri()+endPoint;
		testContainer.getRestRequest().setRequest(RestAssured.given());
	}
	
	@Then("verify the status code {int}")
	public void create_a_user_profile(int statusCode) {
		logger.info("____________________ Status Code Verification___________________");
		testContainer.getRestRequest().setResponse(testContainer.getRestRequest().getRequest().post());
		logger.info(testContainer.getRestRequest().getResponse().getStatusCode() + "-" + testContainer.getRestRequest().getResponse().getStatusLine());
	    logger.info(testContainer.getRestRequest().getResponse().asString());
	    logger.info(testContainer.getRestRequest().getResponse().getBody());
		Assert.assertTrue(testContainer.getRestRequest().getResponse().statusCode()==statusCode);
		logger.info("____________________Verification successfull___________________");
		
	}
	
	@Before
	public void before() {
		long threadId = Thread.currentThread().getId();
		String processName = ManagementFactory.getRuntimeMXBean().getName();
		System.out.println("Started in thread: " + threadId + ", in JVM: " + processName);
	}
	
}
