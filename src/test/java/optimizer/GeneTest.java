package optimizer;

import java.util.ArrayList;
import java.util.List;

public class GeneTest {

	public Cromossomo cromossomoWithGenes(int... infos) {
		List<Gene> genes = new ArrayList<Gene>();
		for (int info : infos) {
			Gene gene = new Gene(info, false);
			genes.add(gene);
		}
		return new Cromossomo(genes);
	}
	
	public List<Cromossomo> listWithCromossomos(Cromossomo... cromossomos) {
		List<Cromossomo> list = new ArrayList<Cromossomo>();
		for (Cromossomo cromossomo : cromossomos) {
			list.add(cromossomo);
		}
		return list;
	}
}
