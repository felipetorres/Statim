package app.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import app.manager.CoordinateManager;
import app.model.EnhancedCoordinate;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.view.Results;

import com.google.gson.Gson;

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
	public void addNewCoordinate() throws IOException {
		String json = request.getReader().readLine();
		ArrayList<String> coordinates = parse(json);
		
		String latitude = coordinates.get(0);
		String longitude = coordinates.get(1);
		String proximoEndereco = coordinates.get(2);
		String emailDoDevice = coordinates.get(3);
		
		EnhancedCoordinate coordinate = new EnhancedCoordinate(Double.valueOf(latitude), Double.valueOf(longitude), emailDoDevice);
		manager.add(coordinate);
	}

	public ArrayList<String> parse(String json) {
		Gson gson = new Gson();
		return gson.fromJson(json, ArrayList.class);
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
