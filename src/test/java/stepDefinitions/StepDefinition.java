package stepDefinitions;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import pojo.AccountInfo;
import pojo.ChangeServiceIdentifierBody;
import pojo.Notifications;
import pojo.Preferences;
import pojo.PrimarySubscriptionBody;
import pojo.ServiceInfo;
import resources.APIResources;
import resources.TestDataBuild;
import resources.Utils;

public class StepDefinition extends Utils{

	RequestSpecification request;
	ResponseSpecification resSpec;
	Response response;
	public static String primaryServiceIdentifier;
	public static String secondaryServiceIdentifier;
	public static String newServiceIdentifier;
	TestDataBuild data = new TestDataBuild();

	//@Before(order =0)
	@Given("primary subscription payload")
	public void primary_subscription_payload()
	{		
		try {
			PrimarySubscriptionBody pri =data.primarySubscription();
			request = given().spec(requestSpecification())
					.body(pri);
			primaryServiceIdentifier = pri.getServiceIdentifier();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	//@Before(order = 1)


	@When("user hits primarySubscription {string} request")
	public void user_hits_primarySubscription_request(String resource) {
		
		response = request.when().post(getAPI(resource));
	}
		

	//	@Before(order =2)
	@Then("status code is {int} and message is {string}")
	public void status_code_is_and_message_is(int statusCode, String value) {
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.JSON).build();
		Response res= response.then().spec(resSpec).extract().response();
		assertEquals(res.getStatusCode(),statusCode);	
		assertEquals(getJsonPath(res, "message"),value);
//		if(getJsonPath(res, "message").equals(value))
//		{
//			assertEquals(getJsonPath(res, "message"),value);
//		}
//		else 
//		{
//			String res1 = res.asString();
//			JsonPath js = new JsonPath(res1);
//			List<String> arr = js.get(value);
//			String actualRes = arr.get(0);
//			assertEquals(actualRes,value);
//		}
	}

	@Given("changeServiceIdentifier payload1")
	public void change_service_identifier_payload1() {
		try {
			ChangeServiceIdentifierBody change = data.changeServiceIdentifier();
			request = given().spec(requestSpecification())
					.body(change);
			newServiceIdentifier = change.getNewServiceIdentifier();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	


@When("user hits {string} request with {string} http request and with the TC name {string}")
public void user_hits_request_with_http_request_and_with_the_tc_name(String resource, String httpMethod, String TC_Name) {
		if(httpMethod.equalsIgnoreCase("POST"))
		{
			response = request.when().post(APIResources.getAPI(resource, TC_Name));	
		}
		else if(httpMethod.equalsIgnoreCase("GET"))
		{
			response = request.when().get(APIResources.getAPI(resource, TC_Name));	
		}
		else if(httpMethod.equalsIgnoreCase("PUT"))
		{
			response = request.when().put(APIResources.getAPI(resource, TC_Name));	
		}
		else if(httpMethod.equalsIgnoreCase("DELETE"))
		{
			response = request.when().delete(APIResources.getAPI(resource, TC_Name));	
		}
		
	}
	
	@Given("changeServiceIdentifier payload2")
	public void change_service_identifier_payload2() throws ClassNotFoundException {
		try {
		//	Class c = Class.forName(newServiceIdentifier);
			request = given().spec(requestSpecification())
					.body(Utils.getCurrentDateTimeMS()+"12");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Given("secondarySubscription payload")
	public void secondary_subscription_payload() {		
		try {
			PrimarySubscriptionBody secondary = data.secondarySubscription(primaryServiceIdentifier);
			request = given().spec(requestSpecification())
					.body(secondary);
			secondaryServiceIdentifier = secondary.getServiceIdentifier();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	
	@When("user hits secondarySubscription {string} request")
	public void user_hits_secondarySubscription_request(String resource) {		
		response = request.when().post(getAPI(resource));
	}

	@Given("addTopUp payload with {string}")
	public void add_top_up_payload_with(String bundleCode) {	   
		try {
			request=given().spec(requestSpecification())
			.body(data.addTopUp(bundleCode));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	@Given("provision payload with {string} {string} {string}")
	public void provision_payload_with(String baseBundle, String roamingBundle, String rccBundle) {	  
		try {
			request = given().spec(requestSpecification())
					.body(data.provision(baseBundle, roamingBundle, rccBundle));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	@Given("deleteSubscription payload")
	public void delete_subscription_payload() {
	   try {
		request = given().spec(requestSpecification());
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
	
	@Then("status code is {int}")
	public void status_code_is(int statusCode) {
		resSpec = new ResponseSpecBuilder().expectContentType(ContentType.TEXT).build();
		Response res= response.then().spec(resSpec).extract().response();
		assertEquals(res.getStatusCode(), statusCode);	
		
	}
	
}
