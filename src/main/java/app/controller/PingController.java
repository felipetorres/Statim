package app.controller;

import static br.com.caelum.vraptor.view.Results.status;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import app.dao.DeviceDao;
import app.dao.SenderDao;
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
		for (Device device : devices) {
			try {
				pingDevice(sender, device);
			} catch (IOException e) {
				e.printStackTrace();
				result.use(status()).badRequest("Problem when ping: " + sender.getEmail() + " " + device.getRegistrationId());
			}
		}
		result.nothing();
	}

	public int pingDevice(Sender sender, Device device) throws IOException {
		String data = "registration_id=" + device.getRegistrationId() 
					+ "&collapse_key=0"
					+ "&data.message=gps";
		
		URL url = new URL("https://android.googleapis.com/gcm/send");
		HttpsURLConnection.setDefaultHostnameVerifier(new CustomizedHostnameVerifier());
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF=8");
		connection.setRequestProperty("Content-Length",Integer.toString(data.length()));
		connection.setRequestProperty("Authorization", "key=" + sender.getHash());
		System.out.println("Hash: " + sender.getHash());
		System.out.println("Device: " + device.getRegistrationId());
		OutputStream out = connection.getOutputStream();
		out.write(data.getBytes());
		out.close();
		
		try {
			parseResponseFrom(connection, device);
		} catch (IOException e) {
			
		}
		
		return connection.getResponseCode();
	}

	private void parseResponseFrom(HttpsURLConnection connection, Device device)
			throws IOException {
		InputStream inputStream = connection.getInputStream();
		BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
		
		String line = "";
		while((line = reader.readLine()) != null) {
			if(line.startsWith("id=")) {
				return;
			} else {
				devices.delete(device);
			}
		}
	}
	
	private static class CustomizedHostnameVerifier implements HostnameVerifier {
		@Override
		public boolean verify(String arg0, SSLSession arg1) {
			return true;
		}
	}
}
