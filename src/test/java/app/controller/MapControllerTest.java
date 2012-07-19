package app.controller;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.model.CoordinateManager;
import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;

public class MapControllerTest {

	private @Mock HttpServletRequest request;
	private Result result = new MockResult();
	private CoordinateManager manager = new CoordinateManager();
	private MapController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new MapController(request, result, manager);
	}
	
//	@Test
//	public void shouldAddCoordinateToArray() throws Exception {
//
//		controller.addNewCoordinate("-23.123456789", "-42.987654321");
//		Queue<Coordinate> coordinates = manager.getCoordinates();
//		
//		assertEquals(1, coordinates.size());
//		Coordinate coordinate = coordinates.element();
//		
//		assertEquals(-23.123456789, coordinate.getLatitude(), 0);
//		assertEquals(-42.987654321, coordinate.getLongitude(), 0);
//	}
}
