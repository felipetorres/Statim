package optimizer.selection;

import java.util.List;

import optimizer.Cromossomo;

public interface SelectionStrategy {

	public List<Cromossomo> select(int amount, List<Cromossomo> population);
}
