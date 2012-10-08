package optimizer.selection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import optimizer.Cromossomo;


public class Wheel implements SelectionStrategy {
	
	@Override
	public List<Cromossomo> select(int amount, List<Cromossomo> population) {
		
		Map<Double, Cromossomo> wheel = createWheel(population, wheelSize(population));
		
		Set<Double> sectors = wheel.keySet();
		
		List<Cromossomo> selected = new ArrayList<Cromossomo>();
		for (int i=0; i < amount; i++) {
			selected.add(runWheel(wheel, sectors));
		}
		return selected;
	}

	private Cromossomo runWheel(Map<Double, Cromossomo> wheel, Set<Double> sectors) {
		
		double random = (new Random()).nextDouble();
		
		ArrayList<Double> sectorList = new ArrayList<Double>(sectors);
		Collections.sort(sectorList);
		
		for (Double sector : sectorList) {
			if(random < sector) {
				return wheel.get(sector);
			}
		}
		return null;
	}

	private Map<Double, Cromossomo> createWheel(List<Cromossomo> population, double wheelSize) {
		Map<Double,Cromossomo> endingSectors = new HashMap<Double, Cromossomo>();

		double sectorSize;
		double sectorPosition = 0;
		
		for (Cromossomo cromossomo : population) {
			sectorSize = (1/cromossomo.getFitness())/wheelSize;
			sectorPosition += sectorSize;
			
			endingSectors.put(sectorPosition, cromossomo);
		}
		return endingSectors;
	}

	private double wheelSize(List<Cromossomo> population) {
		double wheelSize = 0;
		for (Cromossomo cromossomo : population) {
			wheelSize += 1/cromossomo.getFitness();
		}
		return wheelSize;
	}
}
