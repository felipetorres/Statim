package optimizer.benchmark.responsability;

import java.util.List;

import optimizer.Cromossomo;

public interface Chain<T> {

	public T execute();
	public List<Cromossomo> getPopulacao();
}
