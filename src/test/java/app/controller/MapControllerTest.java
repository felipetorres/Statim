package app.controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Queue;

import javax.servlet.http.HttpServletRequest;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import app.manager.CoordinateManager;
import app.model.EnhancedCoordinate;
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
	
	@Test
	public void shouldParseCorrectyIgnoringTheLastComma() throws Exception {
		String json = "[\"-23.588104933333337\",\"-46.632236299999995\",\"Rua do Proximo Destino, 1234\",\"email@do.device\"]";
		
		ArrayList<String> strings = controller.parse(json);
		
		assertEquals(strings.get(0), "-23.588104933333337");
		assertEquals(strings.get(1), "-46.632236299999995");
		assertEquals(strings.get(2), "Rua do Proximo Destino, 1234");
		assertEquals(strings.get(3), "email@do.device");
		
	}
	
	@Test
	public void shouldParseCorrectyWhenAddressHasNoComma() throws Exception {
		String json = "[\"-23.588104933333337\",\"-46.632236299999995\",\"Rua do Proximo Destino 1234\",\"email@do.device\"]";
		
		ArrayList<String> strings = controller.parse(json);
		
		assertEquals(strings.get(0), "-23.588104933333337");
		assertEquals(strings.get(1), "-46.632236299999995");
		assertEquals(strings.get(2), "Rua do Proximo Destino 1234");
		
	}
	
	@Test
	public void shouldAddCoordinateToArray() throws Exception {
		
		String json = "[\"-23.588104933333337\",\"-46.632236299999995\",\"Rua do Proximo Destino 1234\",\"email@do.device\"]";
		
		BufferedReader mockReader = mock(BufferedReader.class);
		when(request.getReader()).thenReturn(mockReader);
		when(mockReader.readLine()).thenReturn(json);
		
		controller.addNewCoordinate();
		Queue<EnhancedCoordinate> coordinates = manager.getCoordinates();
		
		assertEquals(1, coordinates.size());
		EnhancedCoordinate coordinate = coordinates.element();
		
		assertEquals(-23.588104933333337, coordinate.getLatitude(), 0);
		assertEquals(-46.632236299999995, coordinate.getLongitude(), 0);
		assertEquals("email@do.device", coordinate.getDeviceName());
	}
}
