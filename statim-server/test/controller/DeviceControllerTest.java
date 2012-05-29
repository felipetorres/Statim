package controller;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import model.Device;
import model.Sender;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import br.com.caelum.vraptor.Result;
import br.com.caelum.vraptor.util.test.MockResult;
import dao.DeviceDao;
import dao.SenderDao;

public class DeviceControllerTest {

	private @Mock DeviceDao devices;
	private @Mock SenderDao senders;
	private Result result = new MockResult();
	private DeviceController controller;

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		controller = new DeviceController(result, senders, devices);
	}
	
	@Test
	public void shouldSaveNewDevice() throws Exception {
		Sender sender = new Sender();
		when(senders.findByEmail("sender@email.com")).thenReturn(sender);
		controller.save("sender@email.com", "deviceRegistrationHash");
		verify(devices).save(Mockito.any(Device.class));
	}
	
	@Test
	public void shouldNotSaveDeviceIfItAlreadyIsOnDB() throws Exception {
		Sender sender = new Sender();
		when(senders.findByEmail("sender@email.com")).thenReturn(sender);
		when(devices.contains("deviceRegistrationHash")).thenReturn(true);
		controller.save("sender@email.com", "deviceRegistrationHash");
		verify(devices, never()).save(Mockito.any(Device.class));
	}
}
