package app.controller;

import app.dao.DeviceDao;
import app.dao.SenderDao;
import app.model.Device;
import app.model.Sender;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Post;
import br.com.caelum.vraptor.Resource;

@Resource
public class DeviceController {

	private final SenderDao senders;
	private final DeviceDao devices;

	public DeviceController(SenderDao senders, DeviceDao devices) {
		this.senders = senders;
		this.devices = devices;
	}
	
	@Post("/new/{senderEmail}/{deviceName}/{deviceRegistrationId}")
	public void save(String senderEmail, String deviceName, String deviceRegistrationId) {
		Sender sender = senders.findByEmail(senderEmail);
		if(sender != null) {
			if(!devices.contains(deviceRegistrationId)) {
				System.out.println("Device novo. Cadastrando...");
				Device device = new Device(sender, deviceName, deviceRegistrationId);
				devices.save(device);
			} else {
				System.out.println("Device já existe no banco.");
			}
		}
	}
	
	@Path("/update/{oldDeviceRegistrationId}/{newName}/{newDeviceRegistrationId}")
	public void update(String oldDeviceRegistrationId, String newName, String newDeviceRegistrationId) {
		System.out.println("Atualizando id do device...");
		devices.update(oldDeviceRegistrationId, newName, newDeviceRegistrationId);
	}
}
