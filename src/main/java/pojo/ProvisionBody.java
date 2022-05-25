package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ProvisionBody {
	
	private BundleGroup bundleGroup;
	private String serviceIdentifier;
	private String imsi;
	private String subscriptionMode;
	private Subscription subscription;
	
	
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

	
	public BundleGroup getBundleGroup() {
		return bundleGroup;
	}
	public void setBundleGroup(BundleGroup bundleGroup) {
		if(!String.valueOf(bundleGroup).isEmpty()) {
		this.bundleGroup = bundleGroup;
		}
	}
	public Subscription getSubscription() {
		return subscription;
	}
	public void setSubscription(Subscription subscription) {
		if(!String.valueOf(subscription).isEmpty()) {
		this.subscription = subscription;
		}
	}

	

}
