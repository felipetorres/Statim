package optimizer;

import java.util.ArrayList;
import java.util.List;

import app.model.GoogleDistanceMatrixObject;

public class Cromossomo {
	
	private List<Gene> genes;
	private double fitness;
	
	public Cromossomo(List<Gene> genes) {
		this.genes = genes;
		this.fitness = genes.get(0).getInfo();
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
	
	private double calculateTotalDistance() {
		
		double totalDistance = 0;
		GoogleDistanceMatrixObject matrix = DistanceMatrix.matrix;
		
		for (int i=0; i-1<genes.size(); i++) {
			if(!genes.get(i+1).isSpecial()) {
				totalDistance += matrix.getDistanceAtPosition(i, i+1);
			}
		}
		return totalDistance;
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
}
