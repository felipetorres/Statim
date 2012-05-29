package controller;

import static br.com.caelum.vraptor.view.Results.json;

import java.util.Queue;

import model.Coordinate;
import model.CoordinateManager;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.ioc.SessionScoped;

@Resource
@SessionScoped
public class MapController {

	private final Result result;
	private final CoordinateManager coordinates;
	private boolean modifyMap = true;

	public MapController(Result result, CoordinateManager coordinates) {
		this.result = result;
		this.coordinates = coordinates;
	}

	@Path("/map/add/{latitude}/{longitude}")
	public void addNewCoordinate(String latitude, String longitude) {
		Coordinate coordinate = new Coordinate(Double.valueOf(latitude), Double.valueOf(longitude));
		coordinates.add(coordinate);
		result.nothing();
		modifyMap = true;
	}

	@Path("/map.json")
	public void getJSON() {
		Queue<Coordinate> queue = coordinates.getCoordinates();
		result.use(json()).from(queue, "coordenadas").serialize();
		modifyMap = false;
	}
	
	@Path("/map")
	public void show() {}
	
	@Path("/map/clear")
	public void clearJSON() {
		coordinates.clear();
	}
}
