package br.com.c2dm;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;
import constants.StatimConstants;

public class C2DM_MessageReceiver extends BroadcastReceiver {
	
	private static String SERVIDOR = "192.168.84.122";

    public void onReceive(Context context, Intent intent) {

        String action = intent.getAction();
        
        if ("com.google.android.c2dm.intent.RECEIVE".equals(action)) {
            String message = intent.getStringExtra("message");
            
            if("gps".equals(message)) {
        		localiza(context);
            }
        }
    }

	private void localiza(Context context) {
		LocationListener listener = myLocationListener(context);
		LocationManager manager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		
		if (manager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
			Log.i("Provider", "GPS");
			manager.requestSingleUpdate(LocationManager.GPS_PROVIDER, listener, null);
		}
		if (manager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
			Log.i("Provider", "NETWORK");
			manager.requestSingleUpdate(LocationManager.NETWORK_PROVIDER, listener, null);
		}
	}
	private void enviaPara(String ip, double lat, double lon) {
		String url = StatimConstants.server_url + "/map/add/" + String.valueOf(lat) + "/" + String.valueOf(lon);
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

	private LocationListener myLocationListener(final Context context) {
		return new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				double lat = location.getLatitude();
				double lon = location.getLongitude();
				enviaPara(SERVIDOR, lat,lon);
				String texto = "Latitude:" + lat + " ,longitude:" + lon;
				Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
				Log.i("COORDENADAS", texto);
			}
			@Override
			public void onStatusChanged(String provider, int status, Bundle extras) {}
			@Override
			public void onProviderEnabled(String provider) {}
			@Override
			public void onProviderDisabled(String provider) {}
		}; 
	}
}
