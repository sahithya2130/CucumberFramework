package resources;

import stepDefinitions.StepDefinition;

public class APIResources {
	
	private static String domain = "/apilayer/v1";
	
	public static String getAPI(String apiName, String TC_Name)
	{
		String resource = "";
		
		switch(apiName)
		{
			case "primarySubscription":
				return resource = primarySubscription(TC_Name);
			case "secondarySubscription":
				return resource = secondarySubscription(TC_Name);
			case "provision":
				return resource = provision(TC_Name);
			case "changeServiceIdentifier":
				return resource = changeServiceIdentifier(TC_Name);
			case "addTopUp":
				return resource = addTopUp(TC_Name);
			case "deleteSubscription":
				return resource = deletSubscription(TC_Name);
								
		    default:
		    	return resource = ""; 
				
		}
	}
	
	public static String primarySubscription(String TC_Name)
	{
		String resource;
		
		switch(TC_Name)
		{
		case "primarySubscription" :
			return resource = domain + "/subscriptions";
			
		default:
			return resource="";
		}		
	}
	
	public static String secondarySubscription(String TC_Name)
	{
		String resource;
		
		switch(TC_Name)
		{
		case "secondarySubscription" :
			return resource = domain + "/subscriptions";
			
		default:
			return resource="";
		}		
	}
	
	public static String changeServiceIdentifier(String TC_Name)
	{
		String serviceIdentifierPrimary = StepDefinition.primaryServiceIdentifier;
		String serviceIdentifierSecondary= StepDefinition.secondaryServiceIdentifier;
		String newServiceIdentifier = StepDefinition.newServiceIdentifier;
		String invalidServiceIdentifier = "123459865";
		String serviceIdentifierGreaterThan15 = "1234598650987654";
		String withoutProvidingOldIdentifier =" ";
	
		String resource ="";
		
		switch(TC_Name)
		{
		case "changeServiceIdentifierPrimary":
			return resource = domain + "/subscriptions/" + serviceIdentifierPrimary+"/serviceIdentifier";
		case "changeServiceIdentifierSecondary":
			return resource = domain + "/subscriptions/" + serviceIdentifierSecondary+"/serviceIdentifier";
		case "invalidOldServiceIdentifier":
			return resource = domain + "/subscriptions/" + invalidServiceIdentifier+"/serviceIdentifier";
		case "serviceIdentifierGreaterThan15":
			return resource = domain + "/subscriptions/" + serviceIdentifierPrimary+"/serviceIdentifier";
		case "withoutProvidingOldIdentifier":
			return resource = domain + "/subscriptions//serviceIdentifier";
			
		default:
	    	return resource = ""; 
		}		
	}
	
	public static String addTopUp(String TC_Name)
	{
		String serviceIdentifierPrimary = StepDefinition.primaryServiceIdentifier;
		
		String resource;
		
		switch(TC_Name)
		{
		case "validTopupBundleCode" :
			return resource = domain + "/subscriptions/"+serviceIdentifierPrimary+"/topups";
		case "withMultipleBundles" :
			return resource = domain + "/subscriptions/"+serviceIdentifierPrimary+"/topups";
		case "withInvalidBundleCode" :
			return resource = domain + "/subscriptions/"+serviceIdentifierPrimary+"/topups";
		case "inactiveServiceIdentifier" :
			return resource = domain + "/subscriptions/"+serviceIdentifierPrimary+"/topups";
			
		default:
			return resource="";
		}		
	}
	
	public static String provision(String TC_Name)
	{
		String resource;
		
		switch(TC_Name)
		{
		case "withAllBundles" :
			return resource = domain + "/provision";
			
		default:
			return resource="";
		}		
	}
	
	public static String deletSubscription(String TC_Name)
	{
		String serviceIdentifierPrimary = StepDefinition.primaryServiceIdentifier;
		String resource;
		
		switch(TC_Name)
		{
		case "withValidServiceIdentifier" :
			return resource = domain + "/subscriptions/" + serviceIdentifierPrimary;
			
		default:
			return resource="";
		}		
	}
	
	

}
