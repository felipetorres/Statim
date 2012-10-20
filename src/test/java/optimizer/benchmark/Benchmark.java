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
		
		bench(100, "865.0", Example.matrix, coordinates, new Ranking(), new PMX(), 10*coordinates.size(), 10*coordinates.size(), 10*coordinates.size());
	}
	
	
	@Test
	public void doBenchmark2() throws Exception {
		Coordenada c1 = new Coordenada(-23.581815,-46.577033);
		Coordenada c2 = new Coordenada(-23.582228,-46.576357);
		Coordenada c3 = new Coordenada(-23.579701,-46.578149);
		Coordenada c4 = new Coordenada(-23.581186,-46.577323);
		Coordenada c5 = new Coordenada(-23.580173,-46.577881);
		Coordenada c6 = new Coordenada(-23.580852,-46.577516);
		Coordenada c7 = new Coordenada(-23.582012,-46.575896);
		Coordenada c8 = new Coordenada(-23.578334,-46.5789);
		Coordenada c9 = new Coordenada(-23.579003,-46.578567);
		Coordenada c10 = new Coordenada(-23.582189,-46.576851);
		
		List<Coordenada> list = new ArrayList<Coordenada>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		list.add(c4);
		list.add(c5);
		list.add(c6);
		list.add(c7);
		list.add(c8);
		list.add(c9);
		list.add(c10);
		
		bench(100, "602.0", Example.matrix2, list, new Ranking(), new Cycle(), 30*list.size(), 20*list.size(), 20*list.size());
	}
	

	private void bench(int instancias, String otimo, String jsonMatrix, List<Coordenada> coordinates, SelectionStrategy selector, 
			CrossoverStrategy crossover, int popInicial, int geracoes, int fitnessAmount) throws FileNotFoundException {
		
		BenchmarkEngine engine = new BenchmarkEngine(otimo, selector, crossover, jsonMatrix);
		
		String selectorName = selector.getName();
		String crossoverName = crossover.getName();
		
		PrintWriter out = new PrintWriter(new File("./src/test/java/optimizer/benchmark/" + selectorName + "_" + crossoverName + "_" + instancias + ".out"));
		
		out.println(selectorName + " "+ crossoverName + " " + otimo);
		out.println(instancias);
		out.println(popInicial + " " + geracoes + " " + fitnessAmount);
		
		for(int i=0; i<instancias; i++) {
			engine.minimizeRoute(coordinates, popInicial, geracoes, fitnessAmount, out);
		}
		
		out.close();
	}
}
