package Resource;

//enum is special class in java which hase collection of constant or methods.
public enum ConstantAPIResource {

	AddPlace("/maps/api/place/add/json"), DeletePlace("/maps/api/place/delete/json"),
	UpdatePlace("/maps/api/place/update/json"), GetPlace("/maps/api/place/get/json");

	private String resource;

	private ConstantAPIResource(String ResourcesPath) {
		// TODO Auto-generated constructor stub
		this.resource = ResourcesPath;
	}

	public String getResource() {
		return resource;
	}
}
