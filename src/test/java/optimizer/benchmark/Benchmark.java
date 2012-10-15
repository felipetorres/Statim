package optimizer.benchmark;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import optimizer.Coordenada;
import optimizer.crossover.CrossoverStrategy;
import optimizer.crossover.Cycle;
import optimizer.crossover.PMX;
import optimizer.selection.Ranking;
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
		
//		bench(100, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(250, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(500, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(1000, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(2000, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(3000, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(4000, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(5000, coordinates, new Ranking(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		
//		bench(100, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(250, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(500, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(1000, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(2000, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(3000, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(4000, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
//		bench(5000, coordinates, new Wheel(), new Cycle(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
		
//		bench(100, coordinates, new Ranking(), new PMX(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
		
		
	}

	private void bench(int instancias, List<Coordenada> coordinates, SelectionStrategy selector, CrossoverStrategy crossover, 
			int popInicial, int geracoes, int fitnessAmount) throws FileNotFoundException {
		
		String otimo = "865.0";
		
		BenchmarkEngine engine = new BenchmarkEngine(otimo, selector, crossover);
		
		String selectorName = selector.getName();
		String crossoverName = crossover.getName();
		
		PrintWriter out = new PrintWriter(new File("./src/test/java/optimizer/benchmark/" + selectorName + "_" + crossoverName + "_" + instancias + ".out"));
		
		out.println(selectorName + " "+ crossoverName + " " + otimo);
		out.println(instancias);
		out.println(popInicial + " " + geracoes + " " + fitnessAmount);
		
		for(int i=0; i<instancias; i++) {
			engine.minimizeRouteUsingPopularity(coordinates, popInicial, 0.95, fitnessAmount, out);
		}
		
		out.close();
	}
}
