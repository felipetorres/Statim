package app.controller;

import static org.junit.Assert.assertEquals;

import java.util.Queue;

import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import app.model.Coordinate;
import app.model.CoordinateManager;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

public class MapControllerTest {

	private Result result = new MockResult();
	private CoordinateManager manager = new CoordinateManager();
	private MapController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new MapController(result, manager);
	}
	
	@Test
	public void shouldAddCoordinateToArray() throws Exception {
		controller.addNewCoordinate("-23.123456789", "-42.987654321");
		Queue<Coordinate> coordinates = manager.getCoordinates();
		
		assertEquals(1, coordinates.size());
		Coordinate coordinate = coordinates.element();
		
		assertEquals(-23.123456789, coordinate.getLatitude(), 0);
		assertEquals(-42.987654321, coordinate.getLongitude(), 0);
	}
}
