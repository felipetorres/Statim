package app.controller;

import java.io.IOException;
import java.util.List;

import app.constant.Constants;
import app.constant.Message;
import app.dao.DeviceDao;
import app.dao.SenderDao;
import app.manager.PingManager;
import app.model.Address;
import app.model.Device;
import app.model.Sender;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;
import br.com.caelum.vraptor.Result;

import com.google.gson.Gson;

@Resource
public class ItineraryController {

	private final DeviceDao devices;
	private final Result result;
	private final SenderDao senders;

	public ItineraryController(DeviceDao devices, SenderDao senders, Result result) {
		this.devices = devices;
		this.senders = senders;
		this.result = result;
	}
	
	public void create() {
		Sender sender = senders.findByEmail(Constants.email);
		result.include("devices", senders.findDevicesOf(sender));
	}
	
	@Path("/itinerary/sendTo/{deviceId}")
	public void sendTo(String deviceId, List<Address> itinerary) {
		Device device = devices.findById(Long.valueOf(deviceId));
		Sender sender = senders.findByEmail(Constants.email);
		PingManager manager = new PingManager(sender, devices);
		try {
			Gson gson = new Gson();
			String itineraryJson = gson.toJson(itinerary);
			manager.ping(device, Message.ITINERARY.toJson(itineraryJson));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
