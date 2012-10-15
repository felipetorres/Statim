package optimizer.crossover;

import static org.junit.Assert.assertEquals;

import java.util.List;

import optimizer.Cromossomo;
import optimizer.GeneTest;

import org.junit.Test;

public class CycleTest extends GeneTest {

	@Test
	public void cycle() throws Exception {
		
		CrossoverContext crossover = new CrossoverContext(new Cycle(1));
		
		Cromossomo c1 = cromossomoWithGenes(1,3,2,4,5,6,7);
		Cromossomo c2 = cromossomoWithGenes(2,1,3,5,4,7,6);
		
		Cromossomo expected_f1 = cromossomoWithGenes(1,3,2,5,4,6,7);
		Cromossomo expected_f2 = cromossomoWithGenes(2,1,3,4,5,7,6);

		List<Cromossomo> children = crossover.cross(c1, c2);

		assertEquals(expected_f1, children.get(0));
		assertEquals(expected_f2, children.get(1));
	}
}
