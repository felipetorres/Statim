package optimizer.selection;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import optimizer.Cromossomo;
import optimizer.GeneTest;

import org.junit.Test;
import org.mockito.Mockito;

public class WheelTest extends GeneTest{
	
	@Test
	public void deveSelecionarMaisVezesOsMaisAptos() throws Exception {
		
		Cromossomo c1 = mockWithFitnessAndGenes(1.0, 1,2,3,4,5,6,7,8);
		Cromossomo c2 = mockWithFitnessAndGenes(2.0, 2,1,3,4,5,6,7,8);
		Cromossomo c3 = mockWithFitnessAndGenes(5.0, 5,2,3,4,1,6,7,8);
		
		SelectionContext selection = new SelectionContext(new Wheel());
		
		List<Cromossomo> selected = selection.select(1000, listWithCromossomos(c1,c2,c3));
		
		int[] count = conta(selected);
		
		assertTrue(count[2] >= count[1]);
		assertTrue(count[1] >= count[0]);
	}

	private Cromossomo mockWithFitnessAndGenes(double fitness, int... genes) {
		Cromossomo c = Mockito.mock(Cromossomo.class);
		when(c.getFitness()).thenReturn(fitness);
		List<Integer> info = new ArrayList<Integer>();
		for (int gene : genes) {
			info.add(Integer.valueOf(gene));
		}
		when(c.getInfoOfAllGenes()).thenReturn(info);
		return c;
	}
	
	private int[] conta(List<Cromossomo> selected) {
		int[] count = new int[3];
		
		for (Cromossomo cromossomo : selected) {
			Integer val = cromossomo.getInfoOfAllGenes().get(0);
			if (val == 1) 		count[0]++;
			else if (val == 2) 	count[1]++;
			else 				count[2]++;
		}
		return count;
	}
}
