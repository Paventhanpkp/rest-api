@REST
Feature: Test ONE REST API 
@REST
Scenario: Test ONE REST API
	Given the baseuri 
	When the endpoint is set to "api/users" 
	Then post the request with name as "Kumar" and job is "Tech Manager"
	And verify the status code 201
	And also verify the user name "Kumar" and job "Tech Manager" in response
	
		
#--------------------------------------------------------------