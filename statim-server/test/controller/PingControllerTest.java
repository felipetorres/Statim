package controller;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.Device;
import model.Sender;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import dao.SenderDao;

public class PingControllerTest {

	private @Mock SenderDao senders;
	private PingController controller;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		controller = new PingController(senders);
	}
	
	@Test
	public void shouldPingAllRegisteredDevices() throws Exception {
		Sender senderMock = Mockito.mock(Sender.class);
		when(senderMock.getHash()).thenReturn("sender-hash");
		List<Device> devices = new ArrayList<Device>();
		
		addADeviceWith(senderMock, "registration-id-1", devices);
		addADeviceWith(senderMock, "registration-id-2", devices);
		
		when(senders.findByEmail("sender@email.com")).thenReturn(senderMock);
		when(senders.findDevicesOf(senderMock)).thenReturn(devices);
		
		assertEquals(401, controller.ping("sender@email.com"));
	}
	
	private List<Device> addADeviceWith(Sender sender, String registrationId, List<Device> devices) {
		devices.add(new Device(sender, registrationId));
		return devices;
	}
}
