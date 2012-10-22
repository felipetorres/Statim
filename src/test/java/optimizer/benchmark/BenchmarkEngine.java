package optimizer.benchmark;

import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;

import optimizer.Coordenada;
import optimizer.Cromossomo;
import optimizer.benchmark.responsability.Step1;
import optimizer.benchmark.responsability.Step2;
import optimizer.benchmark.responsability.Step3;
import optimizer.crossover.CrossoverContext;
import optimizer.crossover.CrossoverStrategy;
import optimizer.selection.SelectionContext;
import optimizer.selection.SelectionStrategy;

public class BenchmarkEngine {
	
	private String jsonMatrix;
	private SelectionContext fitnessContext;
	private CrossoverContext crossoverContext;
	
	public BenchmarkEngine(String otimo, SelectionStrategy selection, CrossoverStrategy crossover, String jsonMatrix) {
		this.jsonMatrix = jsonMatrix;
		this.fitnessContext = new SelectionContext(selection);
		this.crossoverContext = new CrossoverContext(crossover);
	}

	public List<Cromossomo> minimizeRoute(List<Coordenada> coordenadas, int popInicial, int geracoes, int fitness_amount, PrintWriter out) {
		Cromossomo bestSolution = null;
		
		Step1 step1 = new Step1(popInicial, jsonMatrix);
		
		for(int i=0;i<geracoes;i++) {
			
			step1 = step1.execute();
			Step2 step2 = (new Step2(step1, fitnessContext, fitness_amount)).execute();
			step1 = (new Step3(step2, crossoverContext)).execute();
			
			bestSolution = step1.getPopulacao().get(0);
			
//			System.out.println(bestSolution.getInfoOfAllGenes() + " " + 1/bestSolution.getFitness());
		}
		
		out.println(1/bestSolution.getFitness());
//		System.out.println(1/bestSolution.getFitness());
		
		return step1.getPopulacao();
	}
	
	
	public List<Cromossomo> minimizeRouteUsingPopularity(List<Coordenada> coordenadas, int popInicial, double popularity_rate, int fitness_amount, PrintWriter out) {
		Step1 step1 = new Step1(popInicial, jsonMatrix);
		
		List<Cromossomo> populacao = step1.getPopulacao();
		Cromossomo bestSolution = populacao.get(0);
		
		while((double) Collections.frequency(populacao, bestSolution)/populacao.size() < popularity_rate) {
			
			step1 = step1.execute();
			Step2 step2 = (new Step2(step1, fitnessContext, fitness_amount)).execute();
			step1 = (new Step3(step2, crossoverContext)).execute();
			
			populacao = step1.getPopulacao();
			bestSolution = populacao.get(0);
			
			System.out.println(bestSolution.getInfoOfAllGenes() + " " + 1/bestSolution.getFitness());
		}

		out.println(1/bestSolution.getFitness());
		System.out.println(1/bestSolution.getFitness());
		
		return populacao;
	}
}
