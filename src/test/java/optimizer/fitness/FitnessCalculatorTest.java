package optimizer.fitness;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import optimizer.Cromossomo;
import optimizer.GeneTest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.model.GoogleDistanceMatrixObject;

public class FitnessCalculatorTest extends GeneTest{
	
	private @Mock GoogleDistanceMatrixObject matrix;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		
		when(matrix.getDistanceAtPosition(0, 1)).thenReturn(50);
		when(matrix.getDistanceAtPosition(1, 2)).thenReturn(45);
		when(matrix.getDistanceAtPosition(2, 3)).thenReturn(145);
		when(matrix.getDistanceAtPosition(3, 4)).thenReturn(5);
		when(matrix.getDistanceAtPosition(4, 5)).thenReturn(205);
		when(matrix.getDistanceAtPosition(5, 6)).thenReturn(105);
	}

	@Test
	public void shouldCalculateFitnessUsingMatrixDistances() throws Exception {
		Cromossomo cromossomo = cromossomoWithGenes(0,1,2,3,4,5,6);
		
		FitnessCalculator calculator = new FitnessCalculator(cromossomo, matrix);
		calculator.calculateTotalDistance();
		
		double expected = (double) 1/555;
		
		assertEquals(expected, cromossomo.getFitness(), 0.001);
	}
}
