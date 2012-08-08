package app.manager;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import app.model.Coordinate;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class CoordinateManager {

	private Queue<Coordinate> coordinates = new ConcurrentLinkedQueue<Coordinate>();
	
	public void add(Coordinate coordinate) {
		coordinates.add(coordinate);
	}
	
	public Queue<Coordinate> getCoordinates() {
		return coordinates; 
	}

	public void clear() {
		coordinates.clear();
	}
	
}
