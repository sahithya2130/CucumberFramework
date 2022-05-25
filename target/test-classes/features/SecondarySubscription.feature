Feature: SecondarySubsription Api

Scenario: To verify Secondary subscription with providing primaryserviceIdentifier in the input.
		Given secondarySubscription payload
		When user hits secondarySubscription "secondarySubscription" request
    Then status code is 201 and message is "Secondary subscription created successfully" 