package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class PrimarySubscriptionBody {

	private String serviceIdentifier;
	private String imsi;
	private String subscriptionMode;
	private AccountInfo accountInfo;
	private ServiceInfo serviceInfo;
	private String primaryServiceIdentifier;

	public String getServiceIdentifier() {
		return serviceIdentifier;
	}
	public void setServiceIdentifier(String serviceIdentifier) {
		if(!serviceIdentifier.isEmpty()) {
			this.serviceIdentifier = serviceIdentifier;
		}
	}
	public String getImsi() {
		return imsi;
	}
	public void setImsi(String imsi) {
		if(!imsi.isEmpty()) {
			this.imsi = imsi;
		}
	}
	public String getSubscriptionMode() {
		return subscriptionMode;
	}
	public void setSubscriptionMode(String subscriptionMode) {
		if(!subscriptionMode.isEmpty()) {
			this.subscriptionMode = subscriptionMode;
		}
	}
	public AccountInfo getAccountInfo() {
		return accountInfo;
	}
	public void setAccountInfo(AccountInfo accountInfo) {
		if(!String.valueOf(accountInfo).isEmpty()) {
			this.accountInfo = accountInfo;
		}
	}
	public ServiceInfo getServiceInfo() {
		return serviceInfo;
	}
	public void setServiceInfo(ServiceInfo serviceInfo) {
		if(!String.valueOf(serviceInfo).isEmpty()) {
			this.serviceInfo = serviceInfo;
		}	
	}

	public String getPrimaryServiceIdentifier() {
		return primaryServiceIdentifier;
	}

	public void setPrimaryServiceIdentifier(String primaryServiceIdentifier) {
		if(!primaryServiceIdentifier.isEmpty()) {
			this.primaryServiceIdentifier = primaryServiceIdentifier;
		}
	}



}
