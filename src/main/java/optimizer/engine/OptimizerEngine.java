package optimizer.engine;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import optimizer.Coordenada;
import optimizer.Cromossomo;
import optimizer.DistanceMatrix;
import optimizer.Gene;
import optimizer.crossover.CrossoverContext;
import optimizer.crossover.PMX;
import optimizer.fitness.FitnessCalculator;
import optimizer.selection.Ranking;
import optimizer.selection.SelectionContext;
import app.model.GoogleDistanceMatrixObject;

public class OptimizerEngine {
	
	private GoogleDistanceMatrixObject matrix;
	private List<Cromossomo> populacao;
	private SelectionContext fittnessContext = new SelectionContext(new Ranking());
	private CrossoverContext crossoverContext = new CrossoverContext(new PMX());

	public List<Cromossomo> minimizeRoute(List<Coordenada> coordenadas, int popInicial, int geracoes, int fitness_amount) {
		preprocessa(coordenadas);
		populacao = geraPopulacaoInicial(popInicial);
		for(int i=0;i<geracoes;i++) {
			evaluateFitness();
			List<Cromossomo> fittest = selectsTheFittestUsing(fittnessContext, fitness_amount);
			System.out.println(fittest.get(0).getInfoOfAllGenes() + " " + fittest.get(0).getFitness());
			populacao = crossover(crossoverContext, fittest);
		}
		return populacao;
	}
	
	private void preprocessa(List<Coordenada> coordenadas) {
		this.matrix = new DistanceMatrix(coordenadas).getDistanceMatrix();
	}

	private List<Cromossomo> geraPopulacaoInicial(int n) {
		int dimension = matrix.getDimension();
		List<Gene> genes = geneListWithSize(dimension);

		List<Cromossomo> populacao = new ArrayList<Cromossomo>();
		
		for (int i=0; i<n; i++) {
			List<Gene> copy = new ArrayList<Gene>(genes);
			Collections.shuffle(copy);
			populacao.add(new Cromossomo(copy));
		}
		return populacao;
	}
	
	private void evaluateFitness() {
		for (Cromossomo cromossomo : populacao) {
			new FitnessCalculator(cromossomo, matrix).calculateTotalDistance();
		}
	}
	
	private List<Cromossomo> selectsTheFittestUsing(SelectionContext context, int amount) {
		return context.select(amount, populacao);
	}
	
	private List<Cromossomo> crossover(CrossoverContext context, List<Cromossomo> from) {
		Collections.shuffle(from);
		List<Cromossomo> born = new ArrayList<Cromossomo>();
		
		for(int i=0,j=from.size()-1; i<j; i++, j--) {
			Cromossomo dad = from.get(i);
			Cromossomo mom = from.get(j);
			List<Cromossomo> children = context.cross(dad, mom);
			born.add(children.get(0));
			born.add(children.get(1));
		}
		from.addAll(born);
		return from;
	}
	
	private List<Gene> geneListWithSize(int dimension) {
		List<Gene> genes = new ArrayList<Gene>();
		for(int i=0; i<dimension; i++) {
			Gene gene = new Gene(i, false); //verificar se o gene inicia uma rota.
			genes.add(gene);
		}
		return genes;
	}
}
