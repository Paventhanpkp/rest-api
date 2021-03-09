package restapi.reqres.StepDef;

import io.cucumber.java.en.Then;
import restapi.reqres.Pojo.CreateRequest;
import restapi.reqres.Pojo.CreateResponse;
import restapi.reqres.Pojo.UserRequest;
import restapi.reqres.util.CommonUtils;
import restapi.reqres.util.TestContainer;

public class RegisterUser {
	
	TestContainer testContainer;

	
	public RegisterUser(TestContainer testContainer) {
		this.testContainer = testContainer;
	}
	
	@Then("post the request with email as {string} and password as {string}")
	public void post_the_request_with_email_as_and_password_as(String email, String password) {
		testContainer.getRestRequest().getRequest().given().
		header("Content-Type", "application/json");
		UserRequest registerUser=new UserRequest();
		registerUser.setEmail(email);
		registerUser.setPassword(CommonUtils.DecodeText(password));
		testContainer.getRestRequest().getRequest().body(registerUser);
	}
}
