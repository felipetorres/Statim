package app.controller;

import static br.com.caelum.vraptor.view.Results.status;

import java.io.IOException;
import java.util.List;

import app.constant.Message;
import app.dao.DeviceDao;
import app.dao.SenderDao;
import app.manager.PingManager;
import app.model.Device;
import app.model.Sender;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

@Resource
public class PingController {

	private final DeviceDao devices;
	private final SenderDao senders;
	private final Result result;

	public PingController(DeviceDao devices, SenderDao senders, Result result) {
		this.devices = devices;
		this.senders = senders;
		this.result = result;
	}
	
	@Path("/ping/{email}")
	public void ping(String email) {
		Sender sender = senders.findByEmail(email);
		List<Device> devices = senders.findDevicesOf(sender);
		System.out.println("Ping...");
		PingManager manager = new PingManager(sender, this.devices);
		for (Device device : devices) {
			try {
				manager.ping(device, Message.GPS.toJson(""));
			} catch (IOException e) {
				e.printStackTrace();
				result.use(status()).badRequest("Problem when ping: " + sender.getEmail() + " " + device.getRegistrationId());
			}
		}
		result.nothing();
	}
}
