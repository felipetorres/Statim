package optimizer.selection;

import java.util.Collections;
import java.util.List;

import optimizer.Cromossomo;

public class Ranking implements SelectionStrategy{

	@Override
	public List<Cromossomo> select(int amount, List<Cromossomo> population) {
		Collections.sort(population);
		Collections.reverse(population);
		return population.subList(0, amount-1);
	}
}
