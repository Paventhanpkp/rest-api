package restapi.reqres.StepDef;

import io.cucumber.java.en.Then;
import io.restassured.RestAssured;
import restapi.reqres.util.TestContainer;

public class RetrieveUser {
	TestContainer testContainer;

	public RetrieveUser(TestContainer testContainer) {
		this.testContainer = testContainer;
	}
	
	@Then("verify retrieve user {string}")
	public void retrieveUser(String endPoint) {
		RestAssured.baseURI = testContainer.getRestRequest().getUri()+endPoint;//+testContainer.getTestData().get("id");
		testContainer.getRestRequest().setRequest(RestAssured.given());
	}
}
