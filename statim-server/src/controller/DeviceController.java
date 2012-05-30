package controller;

import model.Device;
import model.Sender;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import dao.DeviceDao;
import dao.SenderDao;

@Resource
public class DeviceController {

	private final SenderDao senders;
	private final DeviceDao devices;

	public DeviceController(SenderDao senders, DeviceDao devices) {
		this.senders = senders;
		this.devices = devices;
	}
	
	@Path("/new/{senderEmail}/{deviceRegistrationId}")
	public void save(String senderEmail, String deviceRegistrationId) {
		Sender sender = senders.findByEmail(senderEmail);
		System.out.println("Verificando a existencia do sender...");
		if(sender != null) {
			System.out.println("Sender reconhecido.");
			if(!devices.contains(deviceRegistrationId)) {
				System.out.println("Device novo. Cadastrando...");
				Device device = new Device(sender, deviceRegistrationId);
				devices.save(device);
			} else {
				System.out.println("Device já existe no banco.");
			}
		}
	}
}
