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
		
		int c2_count = 0, c3_count = 0, c1_count = 0;
		
		for (Cromossomo cromossomo : selected) {
			Integer val = cromossomo.getInfoOfAllGenes().get(0);
			if (val == 2) {
				c2_count++;
			} else if (val == 5){
				c3_count++;
			} else {
				c1_count++;
			}
		}
		
		assertTrue(c3_count >= c2_count);
		assertTrue(c2_count >= c1_count);
	}
}
