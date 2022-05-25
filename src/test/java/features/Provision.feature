Feature: Provision api

@provision
Scenario Outline: To verify provision with all bundles
		Given provision payload with "<baseBundleCode>" "<roamingBundleCode>" "<rccBundleCode>"
		When user hits "provision" request with the TC name "<Api>"
    Then status code is <StatusCode> and message is "<Message>"
    
    Examples:
    |baseBundleCode	|roamingBundleCode|	rccBundleCode	| Api									|StatusCode	|Message															|
    |baseBundle 		|roamingBundle		| rccBundle			| withAllBundles			| 201				|Provisioning created successfully		|