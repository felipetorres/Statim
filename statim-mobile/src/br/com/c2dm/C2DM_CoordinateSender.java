package br.com.c2dm;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import constants.Constants;

public class C2DM_CoordinateSender extends Service {
	
	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		send(intent.getStringExtra("latitude"), intent.getStringExtra("longitude"));
		return START_STICKY;
	}

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}
	
	private void send(String lat, String lon) {
		String url = Constants.server_url + "/map/add/" + lat + "/" + lon;
		HttpClient httpClient = new DefaultHttpClient();
		HttpContext context = new BasicHttpContext();
		HttpGet get = new HttpGet(url);
		try {
			httpClient.execute(get, context);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
