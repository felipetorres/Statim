package optimizer.selection;

import java.util.List;

import optimizer.Cromossomo;

public class SelectionContext {

	private final SelectionStrategy strategy;

	public SelectionContext(SelectionStrategy strategy) {
		this.strategy = strategy;
	}
	
	public List<Cromossomo> select(int amount, List<Cromossomo> population) {
		return strategy.select(amount, population);
	}
}
