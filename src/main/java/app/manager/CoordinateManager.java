package app.manager;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import app.model.EnhancedCoordinate;
import br.com.caelum.vraptor.ioc.ApplicationScoped;
import br.com.caelum.vraptor.ioc.Component;

@Component
@ApplicationScoped
public class CoordinateManager {

	private Queue<EnhancedCoordinate> coordinates = new ConcurrentLinkedQueue<EnhancedCoordinate>();
	
	public void add(EnhancedCoordinate coordinate) {
		coordinates.add(coordinate);
	}
	
	public Queue<EnhancedCoordinate> getCoordinates() {
		return coordinates; 
	}

	public void clear() {
		coordinates.clear();
	}
	
}
