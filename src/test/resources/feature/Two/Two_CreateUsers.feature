@REST
Feature: Test TWO REST API 
@REST
Scenario: Test TWO REST API
	Given the baseuri 
	When the endpoint is set to "api/users" 
	Then post the request with name as "Praharsh" and job is "CEO"
	And verify the status code 201
	And also verify the user name "Praharsh" and job "CEO" in response
	
		
#--------------------------------------------------------------