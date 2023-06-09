package Resource;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Properties;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	public static RequestSpecification Req;
	ResponseSpecification Res;

	public io.restassured.specification.RequestSpecification RequestSpecification() throws Throwable {
		if (Req == null) {
			PrintStream printStream = new PrintStream(new FileOutputStream("Files/Logging.txt"));

			Req = new RequestSpecBuilder().setBaseUri(GetGlobalVal("baseUrl")).addQueryParam("key", "qaclick123")
					.setContentType(ContentType.JSON).addFilter(RequestLoggingFilter.logRequestTo(printStream))
					.addFilter(ResponseLoggingFilter.logResponseTo(printStream)).build();
			return Req;
		}
		return Req;

	}

	public io.restassured.specification.ResponseSpecification ResponseSpecification() {
		Res = new ResponseSpecBuilder().expectStatusCode(200).expectContentType(ContentType.JSON).build();
		return Res;
	}

	public static String GetGlobalVal(String Key) throws Throwable {
		Properties properties = new Properties();
		FileInputStream FIS = new FileInputStream(
				"/Users/anubhavgupta/eclipse-workspace/API_AdvanceFramework/Files/Global.properties");
		properties.load(FIS);
		return properties.getProperty(Key);

	}
	public String getJsonPath( Response response, String key) {
		String responseString = response.asString();
		JsonPath jsonPath = new JsonPath(responseString);
		return jsonPath.getString(key);
		
	}

}
