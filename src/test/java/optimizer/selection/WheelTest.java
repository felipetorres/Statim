package optimizer.selection;

import static org.junit.Assert.assertTrue;

import java.util.List;

import optimizer.Cromossomo;
import optimizer.GeneTest;

import org.junit.Test;

public class WheelTest extends GeneTest{
	
	@Test
	public void deveSelecionarMaisVezesOsMaisAptos() throws Exception {
		Cromossomo c1 = cromossomoWithGenes(1,2,3,4,5,6,7,8);
		Cromossomo c2 = cromossomoWithGenes(2,1,3,4,5,6,7,8);
		Cromossomo c3 = cromossomoWithGenes(5,2,3,4,1,6,7,8);
		
		SelectionContext selection = new SelectionContext(new Wheel());
		
		List<Cromossomo> selected = selection.select(1000, listWithCromossomos(c1,c2,c3));
		
		int[] count = conta(selected);
		
		System.out.println("aqui " + count[2] + " " + count[1] + " " + count[0]);
		
		assertTrue(count[2] <= count[1]);
		assertTrue(count[1] <= count[0]);
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
