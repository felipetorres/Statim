package optimizer.crossover;

import java.util.List;

import optimizer.Cromossomo;

public interface CrossoverStrategy {

	public List<Cromossomo> cross(Cromossomo pai, Cromossomo mae);
	
	public String getName();
}
