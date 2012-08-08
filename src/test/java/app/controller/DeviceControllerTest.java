package app.controller;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import app.dao.DeviceDao;
import app.dao.SenderDao;
import app.model.Device;
import app.model.Sender;

public class DeviceControllerTest {

	private @Mock DeviceDao devices;
	private @Mock SenderDao senders;
	private DeviceController controller;

	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);
		controller = new DeviceController(senders, devices);
	}
	
	@Test
	public void shouldSaveNewDevice() throws Exception {
		Sender sender = new Sender();
		when(senders.findByEmail("sender@email.com")).thenReturn(sender);
		controller.save("sender@email.com", "", "deviceRegistrationHash");
		verify(devices).save(Mockito.any(Device.class));
	}
	
	@Test
	public void shouldNotSaveDeviceIfItAlreadyIsOnDB() throws Exception {
		Sender sender = new Sender();
		when(senders.findByEmail("sender@email.com")).thenReturn(sender);
		when(devices.contains("deviceRegistrationHash")).thenReturn(true);
		controller.save("sender@email.com", "", "deviceRegistrationHash");
		verify(devices, never()).save(Mockito.any(Device.class));
	}
}
