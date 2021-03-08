package restapi.reqres.util;

import java.util.HashMap;

public class TestContainer {
	private HashMap<String,String> testData;
	private RestRequest restRequest;

	public TestContainer() {
		testData=new HashMap<>();
		restRequest=new RestRequest();
	}
	
	public HashMap<String,String>  getTestData() {
		return testData;
	}

	public void setTestData(HashMap<String,String>  testData) {
		this.testData = testData;
	}

	public RestRequest getRestRequest() {
		return restRequest;
	}

	public void setRestRequest(RestRequest restRequest) {
		this.restRequest = restRequest;
	}
	
	
}
