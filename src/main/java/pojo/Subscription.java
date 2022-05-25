package pojo;

public class Subscription {
	
	private AccountInfo accountInfo;
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
	private ServiceInfo serviceInfo;


}
