package pojo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AddTopUpBody {
	
	private String bundleCode;

	public String getBundleCode() {
		return bundleCode;
	}

	public void setBundleCode(String bundleCode) {
		if(!bundleCode.isEmpty()) {
		this.bundleCode = bundleCode;
		}
	}

}
