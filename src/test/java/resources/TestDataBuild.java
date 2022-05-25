package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Properties;

import pojo.AccountInfo;
import pojo.AddTopUpBody;
import pojo.BundleGroup;
import pojo.ChangeServiceIdentifierBody;
import pojo.Notifications;
import pojo.Preferences;
import pojo.PrimarySubscriptionBody;
import pojo.ProvisionBody;
import pojo.ServiceInfo;
import pojo.Subscription;

public class TestDataBuild {
	Utils util = new Utils();
	
	public PrimarySubscriptionBody primarySubscription()
	{	
		PrimarySubscriptionBody ps = new PrimarySubscriptionBody();
		ps.setServiceIdentifier(util.getCurrentDateTimeMS()+"1");
		ps.setImsi(util.getCurrentDateTimeMS()+"2");
		ps.setSubscriptionMode("Postpaid");
		
		AccountInfo ai = new AccountInfo();
		ai.setCustomerType("Business");
		ai.setLastName("Dasari");
		ai.setAddress("4th street");
		ai.setCity("Hyd");
		ai.setCountry("Norway");
		ai.setBdom("1");
		ai.setBillingFrequency("Monthly");
		
		ps.setAccountInfo(ai);
		
		Preferences p = new Preferences();
		p.setServiceProviderId("TS");
		p.setTcId("12345");
		p.setBrandInfo("TeliaNO");
		p.setLanguage("Norwish");
		p.setChannel("SMS");
		p.setEmailAddress("sahithya.dasari@outlook.com");
		p.setAlternateNumber("3456789043");
		p.setSubscriptionType("1");
		
		Notifications n = new Notifications();
		n.setDomesticNotifyEnabled("0");
		n.setRoamingNotifyEnabled("0");
		n.setRccNotifyEnabled("1");
		n.setBarringTopupPurchase("1");
		
		ServiceInfo si = new ServiceInfo();
		si.setPreferences(p);
		si.setNotifications(n);
		
		ps.setServiceInfo(si);
		return ps;
	}
	
	public PrimarySubscriptionBody secondarySubscription(String primaryServiceIdentifier)
	{
		
		PrimarySubscriptionBody ps = new PrimarySubscriptionBody();
		ps.setPrimaryServiceIdentifier(primaryServiceIdentifier);
		ps.setServiceIdentifier(util.getCurrentDateTimeMS()+"3");
		ps.setImsi(util.getCurrentDateTimeMS()+"4");
		Preferences p = new Preferences();
		p.setLanguage("English");
		p.setSubscriptionType("1");
		p.setTcId("123456");
		p.setChannel("Email");
		p.setEmailAddress("sahithya@outlook.com");
		p.setAlternateNumber("9842847509");

		Notifications n = new Notifications();
		n.setBarringTopupPurchase("0");
		n.setDomesticNotifyEnabled("0");
		n.setRccNotifyEnabled("1");
		n.setRoamingNotifyEnabled("1");
		
		ServiceInfo si = new ServiceInfo();
		si.setPreferences(p);
		si.setNotifications(n);
		
		ps.setServiceInfo(si);
		
		return ps;
		
	}
	
	
	public ChangeServiceIdentifierBody changeServiceIdentifier()
	{
		ChangeServiceIdentifierBody csi = new ChangeServiceIdentifierBody();
		csi.setNewServiceIdentifier(util.getCurrentDateTimeMS()+"5");
		return csi;
	}
	
	public AddTopUpBody addTopUp(String bundleCode) throws IOException
	{
		AddTopUpBody atu = new AddTopUpBody();
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//configuration//global.properties");
		prop.load(fis);
		atu.setBundleCode(prop.getProperty(bundleCode));
		return atu;
	}
	
	public ProvisionBody provision(String baseBundle, String roamingBundle, String rccBundle) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//configuration//global.properties");
		prop.load(fis);
		
		ProvisionBody pro = new ProvisionBody();
		
		BundleGroup bg = new BundleGroup();
		bg.setBaseBundle(prop.getProperty(baseBundle));
		bg.setRoamingBundle(prop.getProperty(roamingBundle));
		bg.setRccBundle(prop.getProperty(rccBundle));
		
		pro.setBundleGroup(bg);
		
		pro.setServiceIdentifier(Utils.getCurrentDateTimeMS()+"1");
		pro.setImsi(Utils.getCurrentDateTimeMS()+"2");
		pro.setSubscriptionMode("Postpaid");
		
		AccountInfo ai = new AccountInfo();
		ai.setCustomerType("Business");
		ai.setLastName("Dasari");
		ai.setAddress("4th street");
		ai.setCity("Hyd");
		ai.setCountry("Norway");
		ai.setBdom("1");
		ai.setBillingFrequency("Monthly");
		
		Preferences p = new Preferences();
		p.setServiceProviderId("TS");
		p.setTcId("12345");
		p.setBrandInfo("TeliaNO");
		p.setLanguage("Norwish");
		p.setChannel("SMS");
		p.setEmailAddress("sahithya.dasari@outlook.com");
		p.setAlternateNumber("3456789043");
		p.setSubscriptionType("1");
		
		Notifications n = new Notifications();
		n.setDomesticNotifyEnabled("0");
		n.setRoamingNotifyEnabled("0");
		n.setRccNotifyEnabled("1");
		n.setBarringTopupPurchase("1");
		
		ServiceInfo si = new ServiceInfo();
		si.setPreferences(p);
		si.setNotifications(n);
		
		Subscription s = new Subscription();
		s.setAccountInfo(ai);
		s.setServiceInfo(si);
		
		pro.setSubscription(s);
				
		return pro;
	}
	

}
