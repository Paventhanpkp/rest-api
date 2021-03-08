@Smoke
Feature: Register User Account
@Register @Login
Scenario Outline: Register Users
	Given the baseuri 
	When the endpoint is set to "api/register" 
	Then post the request with email as "<email>" and password as "<password>"
	And post request & verify the status code <statusCode>
	And change the endpoint to "api/login" 
	And post the request with email as "<email>" and password as "<password>"
	And post request & verify the status code <statusCode>
	
Examples:
|email|password|statusCode|
|eve.holt@reqres.in|Y2l0eXNsaWNrYQ==|200|
|user2@gmail.com|UmVzZXRAMTIzNDU=|400|
#--------------------------------------------------------------