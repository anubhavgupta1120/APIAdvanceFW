package StepDefinitions;

import io.cucumber.java.Before;

public class Hooks {

	@Before("@DeletePlace")
	public void beforeScenario() throws Throwable {
		SD_1 sd_1 = new SD_1();
		if (SD_1.Place_id == null) {

			sd_1.add_place_payload_with_something_something_something_something("Anubhav", "English", "France",
					"7078466107");
			sd_1.user_calls_something_api_with_something_http_request("AddPlace", "POST");
			sd_1.verify_placeid_created_maps_to_something_using_something_api("Anubhav", "GetPlace");
			
			
			
		}
		
	}

}
