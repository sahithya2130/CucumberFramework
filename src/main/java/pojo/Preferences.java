package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Preferences {

	private String serviceProviderId;
	private String tcId;
	private String brandInfo;
	private String language;
	private String channel;
	private String emailAddress;
	private String alternateNumber;
	private String subscriptionType;


	public String getServiceProviderId() {
		return serviceProviderId;
	}
	public void setServiceProviderId(String serviceProviderId) {
		if(!serviceProviderId.isEmpty()) {
			this.serviceProviderId = serviceProviderId;
		}
	}
	public String getTcId() {
		return tcId;
	}
	public void setTcId(String tcId) {
		if(!tcId.isEmpty()) {
			this.tcId = tcId;
		}
	}
	public String getBrandInfo() {
		return brandInfo;
	}
	public void setBrandInfo(String brandInfo) {
		if(!brandInfo.isEmpty()) {
			this.brandInfo = brandInfo;
		}
	}
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		if(!language.isEmpty()) {
			this.language = language;
		}
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		if(!channel.isEmpty()) {
			this.channel = channel;
		}
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		if(!emailAddress.isEmpty()) {
			this.emailAddress = emailAddress;
		}
	}
	public String getAlternateNumber() {
		return alternateNumber;
	}
	public void setAlternateNumber(String alternateNumber) {
		if(!alternateNumber.isEmpty()) {
			this.alternateNumber = alternateNumber;
		}
	}
	public String getSubscriptionType() {
		return subscriptionType;
	}
	public void setSubscriptionType(String subscriptionType) {
		if(!subscriptionType.isEmpty()) {
			this.subscriptionType = subscriptionType;
		}
	}

}
