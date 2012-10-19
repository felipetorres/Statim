package optimizer;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import app.model.GoogleDistanceMatrixObject;

public class DistanceMatrixTest {

	@Test
	public void shouldFormatCoordinates() throws Exception {
		
		List<Coordenada> list = listWithCoordinates();
		
		DistanceMatrix matrix = new DistanceMatrix(list);
		String coordinates = matrix.getFormattedCoordinates();
		
		assertEquals("11.111,22.222|33.333,44.444|55.555,66.666", coordinates);
	}
	
	@Test
	public void shouldReturnDistanceBetweenPoints() throws Exception {
		DistanceMatrix matrix = new DistanceMatrix(listWithCoordinates());
		GoogleDistanceMatrixObject matrixObject = matrix.getDistanceMatrix();
		
		int distance1 = matrixObject.getDistanceAtPosition(1, 2);
		int distance2 = matrixObject.getDistanceAtPosition(2, 1);
		
		assertEquals(4469501, distance1);
		assertEquals(4481922, distance2);
	}
	
	@Test
	public void shouldMapCoordinatesIntoPoints() throws Exception {
		List<Coordenada> listToMap = listWithCoordinates();
		DistanceMatrix matrix = new DistanceMatrix(listToMap);
		List<Coordenada> mapped = matrix.getDistanceMatrix().getCoordinates();
		
		for (int i=0; i<mapped.size(); i++) {
			assertEquals(mapped.get(i).getLatitude(), listToMap.get(i).getLatitude(), 0.001);
			assertEquals(mapped.get(i).getLongitude(), listToMap.get(i).getLongitude(), 0.001);
		}
	}
	
	private List<Coordenada> listWithCoordinates() {
		Coordenada c1 = new Coordenada(11.111, 22.222);
		Coordenada c2 = new Coordenada(33.333, 44.444);
		Coordenada c3 = new Coordenada(55.555, 66.666);
		
		List<Coordenada> list = new ArrayList<Coordenada>();
		list.add(c1);
		list.add(c2);
		list.add(c3);
		return list;
	}
}
