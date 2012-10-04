package optimizer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Crossover {
	
	public static List<Cromossomo> pmxTestWrapper(Cromossomo pai, Cromossomo mae) {
		int[] loci = {2,6};
		return pmx(pai, mae, loci);
	}

	public static List<Cromossomo> pmx(Cromossomo pai, Cromossomo mae, int[] loci) {
		
		List<Cromossomo> filhos = new ArrayList<Cromossomo>();
		
		if(loci == null) {
			loci = twoRandomLessThan(pai.size());
		}
		
		List<Gene> paiSeq = pai.sequenceAt(loci[0], loci[1]);
		List<Gene> maeSeq = mae.sequenceAt(loci[0], loci[1]);
		
		List<Gene> filho_pai = arrayListWithSize(pai.size()); 
		List<Gene> filho_mae = arrayListWithSize(pai.size());
		
		setGenes(loci[0], maeSeq, filho_mae);
		setGenes(loci[0], paiSeq, filho_pai);

		copiaGenesDiferentes(pai, filho_mae);
		copiaGenesDiferentes(mae, filho_pai);
		
		copiaGenesComMapeamento(pai, filho_mae);
		copiaGenesComMapeamento(mae, filho_pai);
		
		Cromossomo f1 = new Cromossomo(filho_pai);
		Cromossomo f2 = new Cromossomo(filho_mae);

		filhos.add(f1);
		filhos.add(f2);
		
		return filhos;
	}

	private static void setGenes(int startAt, List<Gene> origin, List<Gene> dest) {
		int i = startAt;
		for (Gene gene : origin) {
			dest.set(i, gene);
			i++;
		}
	}
	
	private static List<Gene> arrayListWithSize(int size) {
		List<Gene> list = new ArrayList<Gene>();
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
		return list;
	}

	private static int[] twoRandomLessThan(int n) {
		int[] randomNumbers = new int[2];
		Random random = new Random();
		
		randomNumbers[0] = random.nextInt(n);
		randomNumbers[1] = random.nextInt(n);
		
		Arrays.sort(randomNumbers);
		
		return randomNumbers;
	}
	
	private static void copiaGenesDiferentes(Cromossomo origem, List<Gene> destino) {
		for(int i=0; i<origem.size(); i++) {
			Gene gene = origem.getGenes().get(i);
			if(destino.get(i) == null && !destino.contains(gene)) {
				destino.set(i, gene);
			}
		}
	}
	
	private static void copiaGenesComMapeamento(Cromossomo c, List<Gene> destino) {
		List<Gene> genes = c.getGenes();
		
		for(int i=0; i<destino.size(); i++) {
			if(destino.get(i) == null) {
				Gene borderGene = genes.get(i);
				int destinoIndex = destino.indexOf(borderGene);
				destino.set(i, genes.get(destinoIndex));
			}
		}
	}
}