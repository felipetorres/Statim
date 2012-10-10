package optimizer.benchmark;

import java.util.ArrayList;
import java.util.List;

import optimizer.Coordenada;
import optimizer.crossover.CrossoverStrategy;
import optimizer.crossover.PMX;
import optimizer.selection.SelectionStrategy;
import optimizer.selection.Wheel;

import org.junit.Test;

public class Benchmark {

	@Test
	public void doBenchmark() throws Exception {
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
		
//		bench(coordinates, 1000, 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
		bench(100, coordinates, new Wheel(), new PMX(), 10*coordinates.size(), 100*coordinates.size(), 5*coordinates.size());
	}

	private void bench(int instancias, List<Coordenada> coordinates, SelectionStrategy wheel, CrossoverStrategy crossover, 
			int popInicial, int geracoes, int fitnessAmount) {
		
		BenchmarkEngine engine = new BenchmarkEngine("865.0", wheel, crossover);
		System.out.println(instancias);
		
		for(int i=0; i<instancias; i++) {
			engine.minimizeRoute(coordinates, popInicial, geracoes, fitnessAmount);
		}
		
		System.out.println(".");
	}
}
