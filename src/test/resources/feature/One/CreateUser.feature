@Smoke
Feature: Test REST API 
@CreateUser
Scenario: Test REST API 
	Given the baseuri 
	When the endpoint is set to "api/users" 
	Then post the request with name as "Ram Kumar" and job is "Tech Lead" 
	And post request & verify the status code 201 
	And also verify the user name "Ram Kumar" and job "Tech Lead" in response 
	And verify retrieve user "api/users/2" 
	And get request & verify the status code 200 
		
#--------------------------------------------------------------