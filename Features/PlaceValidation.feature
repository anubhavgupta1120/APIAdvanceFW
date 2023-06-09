#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: Validating Place API's
@AddPlace
Scenario Outline: Verify if Place is being successfully added using AddPlace API
		Given Add Place PayLoad with "<name>" "<language>" "<address>" "<PhoneNumber>"
		When User calls "AddPlace" API with "Post" Http request
		Then the API call got success with status code "200"
		And "status" in response body is "OK"
		And "scope" in response body is "APP"
		And Verify Place_Id created maps to "<name>" using "GetPlace" API
		
		Examples:
	  | name 				 | language  | address 																					  | PhoneNumber |
		|Anubhav Gupta |Hindi 		 |Amestredam House, Eletronic City, Phase 1, Banglore |7078466107   |	
#		|Deepanshi Garg|Hindi 		 |Sector 15, Gurgaon																  |7451046311   | 
@DeletePlace
Scenario Outline: Verify if Delete place API is working
			Given Delete Place payload
			When User calls "DeletePlace" API with "Delete" Http request
			Then the API call got success with status code "200"
			And "status" in response body is "OK"
			