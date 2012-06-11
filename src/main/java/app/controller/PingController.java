package app.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import java.util.List;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import app.dao.SenderDao;
import app.model.Device;
import app.model.Sender;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class PingController {

	private final SenderDao senders;

	public PingController(SenderDao senders) {
		this.senders = senders;
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
			}
		}
	}

	private int pingDevice(Sender sender, Device device) throws IOException {
		String data = "registration_id=" + device.getRegistrationId() 
					+ "&collapse_key=0"
					+ "&data.message=gps";
		
		URL url = new URL("https://android.apis.google.com/c2dm/send");
		HttpsURLConnection.setDefaultHostnameVerifier(new CustomizedHostnameVerifier());
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=UTF=8");
		connection.setRequestProperty("Content-Length",Integer.toString(data.length()));
		connection.setRequestProperty("Authorization", "GoogleLogin auth=" + sender.getHash());
		OutputStream out = connection.getOutputStream();
		out.write(data.getBytes());
		out.close();
		
		return connection.getResponseCode();
	}
	
	private static class CustomizedHostnameVerifier implements HostnameVerifier {
		@Override
		public boolean verify(String arg0, SSLSession arg1) {
			return true;
		}
	}
}
