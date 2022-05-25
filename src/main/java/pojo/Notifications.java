package pojo;

public class Notifications {

	private String domesticNotifyEnabled;
	private String roamingNotifyEnabled;
	private String rccNotifyEnabled;
	private String barringTopupPurchase;

	public String getDomesticNotifyEnabled() {
		return domesticNotifyEnabled;
	}
	public void setDomesticNotifyEnabled(String domesticNotifyEnabled) {
		if(!domesticNotifyEnabled.isEmpty()) {
			this.domesticNotifyEnabled = domesticNotifyEnabled;
		}
	}
	public String getRoamingNotifyEnabled() {
		return roamingNotifyEnabled;
	}
	public void setRoamingNotifyEnabled(String roamingNotifyEnabled) {
		if(!roamingNotifyEnabled.isEmpty()) {
			this.roamingNotifyEnabled = roamingNotifyEnabled;
		}
	}
	public String getRccNotifyEnabled() {
		return rccNotifyEnabled;
	}
	public void setRccNotifyEnabled(String rccNotifyEnabled) {
		if(!rccNotifyEnabled.isEmpty()) {
			this.rccNotifyEnabled = rccNotifyEnabled;
		}
	}
	public String getBarringTopupPurchase() {
		return barringTopupPurchase;
	}
	public void setBarringTopupPurchase(String barringTopupPurchase) {
		if(!barringTopupPurchase.isEmpty()) {
			this.barringTopupPurchase = barringTopupPurchase;
		}
	}



}
