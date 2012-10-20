package optimizer.benchmark.responsability;

import java.util.List;

import app.model.GoogleDistanceMatrixObject;

import optimizer.Cromossomo;
import optimizer.selection.SelectionContext;


public class Step2 implements Chain<Step2>{

	private List<Cromossomo> populacao;
	private SelectionContext context;
	private int amount;
	private Step1 step1;

	public Step2(Step1 step1, SelectionContext context, int amount) {
		this.step1 = step1;
		this.context = context;
		this.amount = amount;
		populacao = step1.getPopulacao();
	}
	
	@Override
	public Step2 execute() {
		populacao = selectsTheFittestUsing(context, amount);
		return this;
	}
	
	@Override
	public List<Cromossomo> getPopulacao() {
		return populacao;
	}
	
	public GoogleDistanceMatrixObject getInicialMatrix() {
		return step1.getMatrix();
	}
	
	private List<Cromossomo> selectsTheFittestUsing(SelectionContext context, int amount) {
		return context.select(amount, populacao);
	}

}
