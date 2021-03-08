package restapi.reqres.StepDef;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import restapi.reqres.Pojo.CreateRequest;
import restapi.reqres.Pojo.CreateResponse;
import restapi.reqres.util.TestContainer;

public class CreateUser {
	final static Logger logger = LogManager.getLogger(CreateUser.class);
	TestContainer testContainer;
	CreateResponse createResponse;
	
	public CreateUser(TestContainer testContainer) {
		this.testContainer = testContainer;
	}
	
	@Then("post the request with name as {string} and job is {string}")
	public void the_name_and_the_job(String name, String job) {
		testContainer.getRestRequest().getRequest().given().
		header("Content-Type", "application/json");
		CreateRequest createRequest=new CreateRequest();
		createRequest.setName(name);
		createRequest.setJob(job);
		testContainer.getRestRequest().getRequest().body(createRequest);
	}
	
	@Then("also verify the user name {string} and job {string} in response")
	public void verifyResponse(String name, String job) {
	    createResponse=testContainer.getRestRequest().getResponse().getBody().as(CreateResponse.class);
		Assert.assertTrue("User name verification ", createResponse.getName().equalsIgnoreCase(name));
		Assert.assertTrue("User name verification ", createResponse.getJob().equalsIgnoreCase(job));
		testContainer.getTestData().put("id", createResponse.getId());
	}

}
