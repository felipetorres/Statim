package optimizer.crossover;

import java.util.List;

import optimizer.Cromossomo;

public class CrossoverContext {

	private final CrossoverStrategy strategy;

	public CrossoverContext(CrossoverStrategy strategy) {
		this.strategy = strategy;
	}
	
	public List<Cromossomo> cross(Cromossomo pai, Cromossomo mae) {
		return strategy.cross(pai, mae);
	}
	
	public String getName() {
		return strategy.getName();
	}
}
