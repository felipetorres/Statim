package optimizer.benchmark.responsability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import optimizer.Cromossomo;
import optimizer.crossover.CrossoverContext;

public class Step3 implements Chain<Step1>{

	private List<Cromossomo> populacao;
	private CrossoverContext context;
	private Step2 step2;

	public Step3(Step2 step2, CrossoverContext context) {
		this.step2 = step2;
		this.context = context;
		populacao = step2.getPopulacao();
	}

	@Override
	public Step1 execute() {
		populacao = crossover(context);
		Collections.sort(populacao, Collections.reverseOrder());
		return new Step1(populacao, step2.getInicialMatrix());
	}

	@Override
	public List<Cromossomo> getPopulacao() {
		return populacao;
	}
	
	private List<Cromossomo> crossover(CrossoverContext context) {
		Collections.shuffle(populacao);
		List<Cromossomo> born = new ArrayList<Cromossomo>();
		
		for(int i=0,j=populacao.size()-1; i<j; i++, j--) {
			Cromossomo dad = populacao.get(i);
			Cromossomo mom = populacao.get(j);
			List<Cromossomo> children = context.cross(dad, mom);
			born.add(children.get(0));
			born.add(children.get(1));
		}
		populacao.addAll(born);
		return populacao;
	}
}
