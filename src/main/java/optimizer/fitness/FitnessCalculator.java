package optimizer.fitness;

import java.util.List;

import optimizer.Cromossomo;
import optimizer.Gene;
import app.model.GoogleDistanceMatrixObject;

public class FitnessCalculator {

	private final Cromossomo cromossomo;
	private final GoogleDistanceMatrixObject matrix;

	public FitnessCalculator(Cromossomo cromossomo, GoogleDistanceMatrixObject matrix) {
		this.cromossomo = cromossomo;
		this.matrix = matrix;
	}
	
	public void calculateTotalDistance() {
		
		List<Gene> genes = cromossomo.getGenes();
		double totalDistance = 0;
		
		for (int i=0; i<genes.size()-1; i++) {
			Gene geneTo = genes.get(i+1);
			if(!geneTo.isSpecial()) {
				int from = genes.get(i).getInfo();
				int to = geneTo.getInfo();
				totalDistance += matrix.getDistanceAtPosition(from, to);
			}
		}
		cromossomo.setFitness(1/totalDistance);
	}
}
