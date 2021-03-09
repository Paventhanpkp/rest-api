Rest API automation using Cucumber

URI tested : https://reqres.in/

Endpoint covered :
	POST	/api/register
	POST	/api/login 
	POST	/api/users
	GET		/api/users/2

Tags:
	@Smoke<default>		-	Executes all the endpoint testcases
	@E2E				-	will execute Register->login->create user->retrieve scenario
	@Register			-	will execute Register->Login scenario		
	@CreateUser			-	will execute create user->retrieve scenario
	
pass the -DTestEnv vm argument with environment name DIT/SIT this will load the corresponding property file to load the corresponding environment properties

Custom Reporting - Cucumber-JVM (maven-cucumber-reporting) has been used

Parallel Execution - Sure fired forked VM execution

		Note:	
			facing issue with temyers/cucumber-jvm-parallel-plugin, which is still using old version of cucumber-junit dependency 'info-cukes' one and hence facing 'cucumber.api.junit does not exist'. As a work around manually created multiple parallelTest classes file and triggered parallel execution
			
execute the project with mvn goals 'clean verify' Example: mvn clean verify -DTestEnv="DIT" -Dlog4j.configurationFile="file:log4j2.xml"


			