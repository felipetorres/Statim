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
			if(!genes.get(i+1).isSpecial()) {
				totalDistance += matrix.getDistanceAtPosition(i, i+1);
			}
		}
		cromossomo.setFitness(1/totalDistance);
	}
}
