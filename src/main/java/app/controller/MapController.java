package app.controller;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import app.model.Coordinate;
import app.model.CoordinateManager;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

@Resource
public class MapController {

	private final Result result;
	private final CoordinateManager manager;
	private final HttpServletRequest request;

	public MapController(HttpServletRequest request, Result result, CoordinateManager coordinates) {
		this.request = request;
		this.result = result;
		this.manager = coordinates;
	}
	
	@Path("/map/addcoordinate")
	public void teste() {
		
		try {
		BufferedReader reader = request.getReader();
		String line = "";
			while((line = reader.readLine()) != null) {
				System.out.println(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Path("/map/add/{latitude}/{longitude}")
	public void addNewCoordinate(String latitude, String longitude) {
		
		Coordinate coordinate = new Coordinate(Double.valueOf(latitude), Double.valueOf(longitude));
		manager.add(coordinate);
	}

	@Path("/map.json")
	public void getJSON() {
		result.use(Results.json()).from(manager.getCoordinates(), "coordenadas").serialize();
	}
	
	@Path("/map")
	public void show() {}
	
	@Path("/map/clear")
	public void clearJSON() {
		manager.clear();
	}
}
