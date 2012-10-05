package optimizer.engine;

import java.util.List;

import optimizer.Cromossomo;
import optimizer.Gene;
import optimizer.Mapper;

public class OptimizerEngine {

	//gera populacao inicial
	
	
	//calcula aptidao dos cromossomos
	
	
	//seleciona os mais aptos
	
	
	
	//gera descendentes

	private List<Cromossomo> geraPopulacaoInicial(int n) {
		int max = Mapper.size();
		for (int i=0; i < n; i++) {
			//cria random e passa pro gene
			new Gene(i, false); //como passar pro gene que ele é especial?? O device sabe...
		}
		return null;
	}
}
