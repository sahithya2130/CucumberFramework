package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountInfo {
	private String customerType;
	private String lastName;
	private String address;
	private String city;
	private String country;
	private String bdom;
	private String billingFrequency;

	public String getCustomerType() {
		return customerType;		
	}
	public void setCustomerType(String customerType) {
		if(!customerType.isEmpty()) {
			this.customerType = customerType;
		}
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		if(!lastName.isEmpty()) {
			this.lastName = lastName;
		}
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		if(!address.isEmpty()) {
			this.address = address;
		}
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		if(!city.isEmpty()) {
			this.city = city;
		}
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		if(!country.isEmpty()) {
			this.country = country;
		}
	}
	public String getBdom() {
		return bdom;
	}
	public void setBdom(String bdom) {
		if(!bdom.isEmpty()) {
			this.bdom = bdom;
		}
	}
	public String getBillingFrequency() {
		return billingFrequency;
	}
	public void setBillingFrequency(String billingFrequency) {
		if(!billingFrequency.isEmpty()) {
			this.billingFrequency = billingFrequency;
		}
	}



}
