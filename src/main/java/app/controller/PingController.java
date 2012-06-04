package app.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSession;

import app.dao.SenderDao;
import br.com.caelum.vraptor.Path;
import br.com.caelum.vraptor.Resource;

@Resource
public class PingController {

	private final SenderDao senders;

	public PingController(SenderDao senders) {
		this.senders = senders;
	}
	
	@Path("/ping/{email}")
	public int ping(String email) throws IOException {
//		Sender sender = senders.findByEmail(email);
//		List<Device> devices = senders.findDevicesOf(sender);
//		System.out.println("Ping...");
//		for (Device device : devices) {
//			try {
//				return pingDevice(sender, device);
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
		return pingDevice();
	}

	private int pingDevice() throws IOException {
		String data = "registration_id=" + "APA91bE1bRIk33acREVQFVT0UzBJNS_3H_WyJZUjdT4Vcb0s4o2wNmUas3xQxU1cS5qT-2zUjod8sqAEmsn6my2KdSyFEcgUohpY3b3auJ6rkEXeDzYC0Gn5bOr9gbz5fFasEPNbi5P1OIB1RxK_eTSuFbCJgL5u5g" 
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
		connection.setRequestProperty("Authorization", "GoogleLogin auth=" + "DQAAAMIAAADGTDhDS1Rr8gEBYj_Ed-ItH9nTdYr0Z62mO-W713roY-tOrMbBpCyRkfkwyuQqiSmx1wQtsQD0pXxLht7QFVkLZUzzhC2G_sModlN10MahxcC9NoTuT0yjDDEtGVIRa3a5ewLYM97hnFbKGMzAvjumYirNLSFKK1n1Hv5t6j5tv8_pZ9n_LKXqpA9MBd0fxnzMdjHu4Q_IpIWsv0tVRynuCGH_f3sfG1LImU1Ce75NpGVOSkSIX7opl8JmAmHOBogqiJHGK2hXlGL7JZVKnrdO");
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
