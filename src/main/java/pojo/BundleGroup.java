package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class BundleGroup {

	private String baseBundle;
	private String roamingBundle;
	private String rccBundle;
	
	public String getBaseBundle() {
		return baseBundle;
	}
	public void setBaseBundle(String baseBundle) {
		if(!baseBundle.isEmpty()) {
		this.baseBundle = baseBundle;
		}
	}
	public String getRoamingBundle() {
		return roamingBundle;
	}
	public void setRoamingBundle(String roamingBundle) {
		if(!roamingBundle.isEmpty()) {
		this.roamingBundle = roamingBundle;
		}
	}
	public String getRccBundle() {
		return rccBundle;
	}
	public void setRccBundle(String rccBundle) {
		if(!rccBundle.isEmpty()) {
		this.rccBundle = rccBundle;
		}
	}


}
