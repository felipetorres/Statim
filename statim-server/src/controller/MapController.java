package controller;

import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class MapController {

	private final Result result;

	public MapController(Result result) {
		this.result = result;
	}

	@Path("/{latitude}/{longitude}")
	public void showMap(String latitude, String longitude) {
		result.include("latitude", latitude);
		result.include("longitude", longitude);
		System.out.println("Latitude: " + latitude + " Longitude: " + longitude);
	}
	
}
