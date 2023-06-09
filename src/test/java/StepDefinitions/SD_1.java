package StepDefinitions;

import static io.restassured.RestAssured.given;

import org.junit.Assert;
import org.junit.runner.RunWith;

import Resource.ConstantAPIResource;
import Resource.TestDataBuild;
import Resource.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@RunWith(Cucumber.class)
public class SD_1 {
	RequestSpecification Given;
	Utils utils = new Utils();
	Response response;
	TestDataBuild data = new TestDataBuild();
	static String Place_id;

	@Given("^Add Place PayLoad with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
	public void add_place_payload_with_something_something_something_something(String name, String language,
			String address, String phonenumber) throws Throwable {
		// throw new PendingException();
		Given = given().spec(utils.RequestSpecification())
				.body(data.AddPlacePayload(name, language, address, phonenumber));
	}

	@When("^User calls \"([^\"]*)\" API with \"([^\"]*)\" Http request$")
	public void user_calls_something_api_with_something_http_request(String APIResource, String MethodName)
			throws Throwable {
		// throw new PendingException();
		ConstantAPIResource resourceAPI = ConstantAPIResource.valueOf(APIResource);
		if (MethodName.equalsIgnoreCase("POST")) {
			response = Given.when().post(resourceAPI.getResource());
		} else if (MethodName.equalsIgnoreCase("GET")) {
			response = Given.when().get(resourceAPI.getResource());
		} else if (MethodName.equalsIgnoreCase("PUT")) {
			response = Given.when().put(resourceAPI.getResource());
		} else if (MethodName.equalsIgnoreCase("DELETE")) {
			response = Given.when().delete(resourceAPI.getResource());
		}

	}

	@Then("^the API call got success with status code \"([^\"]*)\"$")
	public void the_api_call_got_success_with_status_code_something(String strArg1) throws Throwable {
		// throw new PendingException();
		Assert.assertEquals(response.getStatusCode(), 200);
	}

	@And("^\"([^\"]*)\" in response body is \"([^\"]*)\"$")
	public void something_in_response_body_is_something(String responseParam, String ParamValue) throws Throwable {
		// throw new PendingException();

		String actualStatusString = utils.getJsonPath(response, responseParam);
		Assert.assertEquals(actualStatusString, ParamValue);
	}

	@And("^Verify Place_Id created maps to \"([^\"]*)\" using \"([^\"]*)\" API$")
	public void verify_placeid_created_maps_to_something_using_something_api(String name, String APIResource)
			throws Throwable {

		Place_id = utils.getJsonPath(response, "place_id");
		System.out.println(Place_id);
		Given = given().spec(utils.RequestSpecification()).queryParam("place_id", Place_id);
		user_calls_something_api_with_something_http_request(APIResource, "GET");
		String nameString = utils.getJsonPath(response, "name");
		System.out.println(nameString);
		Assert.assertEquals(nameString, name);
		

	}

	@Given("^Delete Place payload$")
	public void delete_place_payload() throws Throwable {

		Given = given().spec(utils.RequestSpecification()).body(data.DeletePlacePayload(Place_id));
		System.out.println("Delete Initiated");

	}

}
