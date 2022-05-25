package resources;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import io.cucumber.gherkin.internal.com.eclipsesource.json.JsonObject;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import stepDefinitions.StepDefinition;

public class Utils {
	
	public static RequestSpecification reqSpec;
	
	public RequestSpecification requestSpecification() throws IOException
	{
		if(reqSpec==null)
		{
		PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
		reqSpec = new RequestSpecBuilder().setBaseUri(getGlobalValues("baseUrl"))
				.addHeader("countryCode", getGlobalValues("countryCode"))
				.addFilter(RequestLoggingFilter.logRequestTo(log))
				.addFilter(ResponseLoggingFilter.logResponseTo(log))
				.setContentType(ContentType.JSON).build();
		return reqSpec;
		}
		return reqSpec;
	}
	
	public static String getGlobalValues(String value) throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//configuration//global.properties");
		prop.load(fis);
		System.out.println(prop.getProperty(value));
		return prop.getProperty(value);
	}

	public static String getCurrentDateTimeMS() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("yyyyMMddHHmmss");
		String datetime = ft.format(dNow);
		return datetime;
		}
	
	public static String getJsonPath(Response response, String value)
	{
		String res = response.asString();
		JsonPath js = new JsonPath(res);
		if(!(js.get("message")==null))
		{
			return js.get(value).toString();
		}
		else
		{
			List<String> error= js.get("errors");
			return error.get(0);
		}
		
		
	}
	
	public static String getAPI(String apiName)
	{
		StepDefinition ps = new StepDefinition();
		String serviceIdentifierPrimary = ps.primaryServiceIdentifier;
		String serviceIdentifierSecondary= ps.secondaryServiceIdentifier;
		String invalidServiceIdentifier = "123459865";
		String resource = "";
		switch(apiName)
		{
			case "primarySubscription":
				return resource = "/apilayer/v1/subscriptions";
			case "secondarySubscription":
				return resource = "/apilayer/v1/subscriptions";
			case "changeServiceIdentifierPrimary":
				return resource = "/apilayer/v1/subscriptions/"+serviceIdentifierPrimary+"/serviceIdentifier";
			case "changeServiceIdentifierSecondary":
				return resource = "/apilayer/v1/subscriptions/"+serviceIdentifierSecondary+"/serviceIdentifier";
			case "invalidOldServiceIdentifier":
				return resource = "/apilayer/v1/subscriptions/"+invalidServiceIdentifier+"/serviceIdentifier";
			case "serviceIdentifierGreaterThan15":
				return resource = "/apilayer/v1/subscriptions/"+serviceIdentifierPrimary+"/serviceIdentifier";
								
		    default:
		    	return resource = ""; 
				
		}
	}
}
