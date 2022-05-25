#Author: sahithya.dasari@covalensedigital.com


Feature: PrimarySubscription
	
	@Before
	@primarySubscription
  Scenario: To verify primarySubscription with providing Mandatory Attributes.
    Given primary subscription payload
    When user hits primarySubscription "primarySubscription" request
    Then status code is 201 and message is "Primary subscription created successfully "
