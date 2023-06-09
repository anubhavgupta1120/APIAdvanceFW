package Resource;

import java.util.ArrayList;
import java.util.List;

import POJO.AddPlace.AddPlaceReqBody;
import POJO.AddPlace.LattitudeAndLongitude;
import POJO.DeletePlace.DeletePlaceReqBody;

public class TestDataBuild {
	
	public AddPlaceReqBody AddPlacePayload(String name, String language, String address, String PhoneNumber) {
		
		AddPlaceReqBody addPlace = new AddPlaceReqBody();
		LattitudeAndLongitude lattitudeAndLongitute = new LattitudeAndLongitude();
		lattitudeAndLongitute.setLat(-38.383494);
		lattitudeAndLongitute.setLng(33.427362);
		addPlace.setLocation(lattitudeAndLongitute);
		addPlace.setAccuracy(50);
		addPlace.setName(name);
		addPlace.setPhone_number(PhoneNumber);
		addPlace.setAddress(address);
		List<String> myList = new ArrayList<String>();
		myList.add("Shop");
		myList.add("Serums");

		addPlace.setTypes(myList);

		addPlace.setWebsite("http://google.com");
		addPlace.setLanguage(language);
		
		
		return addPlace;
	}
	
	public DeletePlaceReqBody DeletePlacePayload(String PlaceId) {
		DeletePlaceReqBody deletePlace = new DeletePlaceReqBody();
		deletePlace.setPlace_id(PlaceId);
		return deletePlace;
	}

}
