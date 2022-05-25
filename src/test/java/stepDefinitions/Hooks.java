package stepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@changeServiceIdentifier1")
	public void before_changeServiceIdentifier1()
	{
		StepDefinition p = new StepDefinition();
		if(StepDefinition.primaryServiceIdentifier==null)
		{
			p.primary_subscription_payload();
			p.user_hits_primarySubscription_request("primarySubscription");
			p.secondary_subscription_payload();
			p.user_hits_secondarySubscription_request("secondarySubscription");
		}
	}
	
	@Before("@changeServiceIdentifier2")
	public void before_changeServiceIdentifier2()
	{
		StepDefinition p = new StepDefinition();
		if(StepDefinition.primaryServiceIdentifier==null)
		{
			p.primary_subscription_payload();
			p.user_hits_primarySubscription_request("primarySubscription");
		}
	}
	
	@Before("@addTopUp")
	public void before_addTopUp()
	{
		StepDefinition p = new StepDefinition();
		if(StepDefinition.primaryServiceIdentifier==null)
		{
			p.primary_subscription_payload();
			p.user_hits_primarySubscription_request("primarySubscription");
		}
	}
	
	@Before("@deleteSubscription and @inactiveAccount")
	public void before_deleteSubscription()
	{
		StepDefinition p = new StepDefinition();
		if(StepDefinition.primaryServiceIdentifier==null)
		{
			p.primary_subscription_payload();
			p.user_hits_primarySubscription_request("primarySubscription");
		}
	}

}
