package optimizer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class CrossoverTest {

	@Test
	public void bla() throws Exception {
		Cromossomo c1 = cromossomoWithGenes(12,2,7,3,15,8,1,10,4);
		Cromossomo c2 = cromossomoWithGenes(4,7,12,9,1,5,2,3,11);
		
		List<Cromossomo> pmx = Crossover.pmxTestWrapper(c1, c2);
		
		Cromossomo f1 = cromossomoWithGenes(4,12,7,3,15,8,2,9,11);
		Cromossomo f2 = cromossomoWithGenes(7,2,12,9,1,5,15,10,4);
		
		List<Integer> f1_expected = f1.getInfoOfAllGenes();
		List<Integer> f1_pmx = pmx.get(0).getInfoOfAllGenes();
		
		List<Integer> f2_expected = f2.getInfoOfAllGenes();
		List<Integer> f2_pmx = pmx.get(1).getInfoOfAllGenes();
		
		assertEquals(f1_expected, f1_pmx);
		assertEquals(f2_expected, f2_pmx);
	}
	
	private Cromossomo cromossomoWithGenes(int... infos) {
		List<Gene> genes = new ArrayList<Gene>();
		for (int info : infos) {
			Gene gene = new Gene(info, false);
			genes.add(gene);
		}
		return new Cromossomo(genes);
	}
}
