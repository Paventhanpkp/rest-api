@Smoke @E2E
Feature: Test E2E REQRES API 
Background: Register the user and login 
	Given the baseuri 
	When the endpoint is set to "api/register" 
	Then post the request with email as "eve.holt@reqres.in" and password as "Y2l0eXNsaWNrYQ==" 
	And post request & verify the status code 200 
	And change the endpoint to "api/login" 
	And post the request with email as "eve.holt@reqres.in" and password as "Y2l0eXNsaWNrYQ==" 
	And post request & verify the status code 200
Scenario: Test E2E REST API 
	Given the baseuri 
	When the endpoint is set to "api/users" 
	Then post the request with name as "Ram Kumar" and job is "Tech Lead" 
	And post request & verify the status code 201 
	And also verify the user name "Ram Kumar" and job "Tech Lead" in response 
	And verify retrieve user "api/users/2" 
	And get request & verify the status code 200 
	
	#--------------------------------------------------------------