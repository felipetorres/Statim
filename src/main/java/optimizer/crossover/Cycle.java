package optimizer.crossover;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import optimizer.Cromossomo;
import optimizer.Gene;

public class Cycle implements CrossoverStrategy{
	
	private int random = -1;

	public Cycle(int... random) {
		if(random.length > 0) {
			this.random = random[0];
		}
	}

	@Override
	public List<Cromossomo> cross(Cromossomo pai, Cromossomo mae) {
		int size = pai.getGenes().size();
		
		List<Gene> f1 = arrayListWithSize(size);
		List<Gene> f2 = arrayListWithSize(size);
		
		if(random == -1) {
			random = (new Random()).nextInt(size);
		}
		
		recursiveCross(pai.getGenes(), mae.getGenes(), null, random, f1, f2);
		
		List<Cromossomo> children = new ArrayList<Cromossomo>();
		children.add(new Cromossomo(f1));
		children.add(new Cromossomo(f2));
		
		return children;
	}
	
	private void recursiveCross (List<Gene> from, List<Gene> to, Gene gene, int start_index, List<Gene> f1, List<Gene> f2) {
		int index1 = start_index, index2 = -1;
		
		while(index2 != start_index) {
			gene = from.get(index1);
			f1.set(index1, gene);
			
			index2 = to.indexOf(gene);
			f2.set(index2, gene);
			index1 = index2;
		}
		
		for (int i=0; i<from.size(); i++) {
			if(f1.get(i) == null) {
				recursiveCross(from, to, gene, i, f2, f1);
			}
		}
	}
	
	private List<Gene> arrayListWithSize(int size) {
		List<Gene> list = new ArrayList<Gene>();
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
		return list;
	}

	@Override
	public String getName() {
		return "cycle";
	}

}
