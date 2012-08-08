package app.manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import app.dao.DeviceDao;
import app.model.Device;
import app.model.Sender;

public class PingManager {
	
	private final Sender sender;
	private final DeviceDao devices;

	public PingManager(Sender sender, DeviceDao devices) {
		this.sender = sender;
		this.devices = devices;
	}

	public int ping(Device device, String message) throws IOException {
		String data = "{ "
					+ "\"registration_ids\": [\"" + device.getRegistrationId() + "\"]," 
					+ "\"data\": " + message 
					+ "}";
		
		System.out.println(data);	
		
		URL url = new URL("https://android.googleapis.com/gcm/send");
		HttpsURLConnection.setDefaultHostnameVerifier(new CustomizedHostnameVerifier());
		HttpsURLConnection connection = (HttpsURLConnection) url.openConnection();
		connection.setDoOutput(true);
		connection.setUseCaches(false);
		connection.setRequestMethod("POST");
		connection.setRequestProperty("Content-Type", "application/json ; charset=utf-8");
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
