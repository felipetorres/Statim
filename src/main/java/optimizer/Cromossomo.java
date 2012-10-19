package optimizer;

import java.util.ArrayList;
import java.util.List;

public class Cromossomo implements Comparable<Cromossomo>{
	
	private List<Gene> genes;
	private double fitness;
	
	public Cromossomo(List<Gene> genes) {
		this.genes = genes;
		this.fitness = -1;
	}
	
	public int size() {
		return genes.size();
	}

	public List<Gene> sequenceAt(int locus1, int locus2) {
		return genes.subList(locus1, locus2);
	}
	
	public List<Gene> getGenes() {
		return genes;
	}
	
	public double getFitness() {
		return fitness;
	}

	public void setFitness(double fitness) {
		this.fitness = fitness;
	}
	
	public List<Integer> getInfoOfAllGenes() {
		List<Integer> infos = new ArrayList<Integer>();
		for (Gene gene : this.getGenes()) {
			infos.add(gene.getInfo());
		}
		return infos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cromossomo other = (Cromossomo) obj;
		if (genes == null) {
			if (other.genes != null)
				return false;
		} else if (!genes.equals(other.genes))
			return false;
		return true;
	}

	@Override
	public int compareTo(Cromossomo o) {
		if (this.fitness > o.getFitness()) return 1;
		else if (this.fitness < o.getFitness()) return -1;
		return 0;
	}
}
