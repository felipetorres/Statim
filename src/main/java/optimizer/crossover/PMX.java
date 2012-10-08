package optimizer.crossover;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import optimizer.Cromossomo;
import optimizer.Gene;

public class PMX implements CrossoverStrategy {
	
	private int[] loci;

	public PMX(int...loci) {
		this.loci = loci;
	}
	
	public List<Cromossomo> cross(Cromossomo pai, Cromossomo mae) {
		
		List<Cromossomo> filhos = new ArrayList<Cromossomo>();
		
		if(loci.length != 2) loci = twoRandomLessThan(pai.size());
		
		filhos.add(pmxEngine(mae, pai));
		filhos.add(pmxEngine(pai, mae));
		
		return filhos;
	}

	private Cromossomo pmxEngine(Cromossomo c1, Cromossomo c2) {
		
		List<Gene> genes_c2 = c2.sequenceAt(loci[0], loci[1]);
		List<Gene> filho = arrayListWithSize(c1.size());
		
		setGenes(loci[0], genes_c2, filho);
		copiaGenesDiferentes(c1, filho);
		copiaGenesComMapeamento(c1, filho);
		
		Cromossomo gerado = new Cromossomo(filho);

		Set<Integer> set = new HashSet<Integer>(gerado.getInfoOfAllGenes());
		
		if(set.size() < gerado.getInfoOfAllGenes().size()) {
			System.out.println("Erro:\nCorte:" + loci[0] + "," + loci[1] + "\npai: " + c1.getInfoOfAllGenes() + "\nmae: " + c2.getInfoOfAllGenes() + "\nFilho:" + gerado.getInfoOfAllGenes());
		}
		
		return gerado;
	}

	private void setGenes(int startAt, List<Gene> origin, List<Gene> dest) {
		int i = startAt;
		for (Gene gene : origin) {
			dest.set(i, gene);
			i++;
		}
	}
	
	private void copiaGenesDiferentes(Cromossomo origem, List<Gene> destino) {
		for(int i=0; i<origem.size(); i++) {
			Gene gene = origem.getGenes().get(i);
			if(destino.get(i) == null && !destino.contains(gene)) {
				destino.set(i, gene);
			}
		}
	}
	
	private void copiaGenesComMapeamento(Cromossomo c, List<Gene> destino) {
		List<Gene> genes = c.getGenes();
		
		for(int i=0; i<destino.size(); i++) {
			if(destino.get(i) == null) {
				Gene borderGene = genes.get(i);
				int destinoIndex = destino.indexOf(borderGene);
				while(destino.contains(borderGene)) {
					destinoIndex = destino.indexOf(borderGene);
					borderGene = genes.get(destinoIndex);
				}
				destino.set(i, genes.get(destinoIndex));
			}
		}
	}

	private int[] twoRandomLessThan(int n) {
		int[] randomNumbers = new int[2];
		Random random = new Random();
		
		randomNumbers[0] = random.nextInt(n);
		randomNumbers[1] = random.nextInt(n);
		
		Arrays.sort(randomNumbers);
		
		return randomNumbers;
	}
	
	private List<Gene> arrayListWithSize(int size) {
		List<Gene> list = new ArrayList<Gene>();
		for (int i = 0; i < size; i++) {
			list.add(null);
		}
		return list;
	}
}