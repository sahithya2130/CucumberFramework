Feature: changeServiceIdentifier Api

@changeServiceIdentifier1
Scenario Outline: To verify the Change Service Identifier API by providing valid old serviceIdentifier and valid new serviceIdentifier for primary subscription
		Given changeServiceIdentifier payload1
		When When user hits "changeServiceIdentifier" request with "POST" http request and with the TC name "<Api>"
    Then status code is <StatusCode> and message is "<Message>"
	
    Examples: 
      | Api  	 													| StatusCode | Message 																		|
      | changeServiceIdentifierPrimary	| 201				 | ServiceIdentifier changed successfully			|
      | changeServiceIdentifierSecondary|	201				 | ServiceIdentifier changed successfully			|
   		| invalidOldServiceIdentifier			| 404 			 | ServiceIdentifier not found in BRM.				|  		
		#	|	alreadyAssignedSerivceIdentifier| 409				 | Given serviceIdentifier is already assigned to another account |
			|	withoutProvidingOldIdentifier		| 404				 |																						|

@changeServiceIdentifier2
Scenario Outline: To verify the Change Service Identifier API by providing valid old serviceIdentifier and invalid new serviceIdentifier(length greater than 15)
		Given changeServiceIdentifier ser hits "chpayload2
		When When user hits "changeServiceIdentifier" request with "POST" http request and with the TC name "<Api>"
    Then status code is <StatusCode> and message is "<Message>"	
			
		Examples:
			| Api  	 													| StatusCode | Message 																		|
			|	serviceIdentifierGreaterThan15	| 400				 | Length of newServiceIdentifier should be 15|

		
			