Feature: Delete Subscription

@deleteSubscription
Scenario Outline: To verify deleteSubscription with valid serviceIdentifier
		Given deleteSubscription payload
		When user hits "deleteSubscription" request with "DELETE" http request and with the TC name "<Api>"
    Then status code is <StatusCode>
    
    Examples:
    |Api												|StatusCode |
    |withValidServiceIdentifier	|204				|
 		