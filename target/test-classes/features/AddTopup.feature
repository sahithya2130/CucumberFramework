Feature: AddTopUp Api

@addTopUp
Scenario Outline: Verify AddTopup by providing valid serviceIdentifier and with <api> bundle code
		Given addTopUp payload with "<bundleCode>"
		When user hits "addTopUp" request with "POST" http request and with the TC name "<Api>"
    Then status code is <StatusCode> and message is "<Message>"
    
    Examples:
    |bundleCode			|	Api												|	StatusCode	|	Message																|
    |topUpBundle1		| validTopupBundleCode			|	201				 	|	Top-up bundle purchased successfully.	|
    |topUpBundle2		|	withMultipleBundles				|	201					| Top-up bundle purchased successfully.	|
    |invalidBundle 	| withInvalidBundleCode			|	400					| Invalid bundleCode provided.					|
    
    
    @inactiveAccount @addTopUp
    Examples:
    |topUpBundle1		| inactiveServiceIdentifier	| 404					| ServiceIdentifier not found in BRM.		|