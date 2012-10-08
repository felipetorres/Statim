package optimizer.engine;

import java.util.ArrayList;
import java.util.List;

import optimizer.Coordenada;

import org.junit.Test;

public class OptimizerEngineTest {

	@Test
	public void runThisAllShit() throws Exception {
		Coordenada c1 = new Coordenada(-23.580517, -46.581046);
		Coordenada c2 = new Coordenada(-23.579146, -46.577649);
		Coordenada c3 = new Coordenada(-23.578802, -46.576083);
		Coordenada c4 = new Coordenada(-23.580660, -46.575144);
		Coordenada c5 = new Coordenada(-23.581127, -46.574802);
		
		List<Coordenada> coordinates = new ArrayList<Coordenada>();
		coordinates.add(c2);
		coordinates.add(c1);
		coordinates.add(c5);
		coordinates.add(c4);
		coordinates.add(c3);
		
		OptimizerEngine engine = new OptimizerEngine();
		engine.minimizeRoute(coordinates, 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
		
	}
}
