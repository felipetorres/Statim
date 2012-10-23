package optimizer.benchmark.responsability;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import app.model.GoogleDistanceMatrixObject;

import com.google.gson.Gson;

import optimizer.Cromossomo;
import optimizer.Gene;
import optimizer.fitness.FitnessCalculator;

public class Step1 implements Chain<Step1>{

	private int n;
	private GoogleDistanceMatrixObject matrix;
	private List<Cromossomo> populacao;
	
	public Step1(int n, String jsonMatrix) {
		this.n = n;
		this.matrix = (new Gson()).fromJson(jsonMatrix, GoogleDistanceMatrixObject.class);
		this.populacao = geraPopulacaoInicial(this.n);
	}
	
	public Step1(List<Cromossomo> populacao, GoogleDistanceMatrixObject matrix) {
		this.populacao = populacao;
		this.matrix = matrix;
	}

	@Override
	public Step1 execute() {
		evaluateFitness(populacao);
		return this;
	}
	
	@Override
	public List<Cromossomo> getPopulacao() {
		return populacao;
	}
	
	public GoogleDistanceMatrixObject getMatrix() {
		return matrix;
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
	
	private void evaluateFitness(List<Cromossomo> populacao) {
		for (Cromossomo cromossomo : populacao) {
			new FitnessCalculator(cromossomo, matrix).calculateTotalDistance();
		}
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
