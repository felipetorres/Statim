package br.com.c2dm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class C2DM_MessageReceiver extends BroadcastReceiver {
	
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

	private LocationListener myLocationListener(final Context context) {
		return new LocationListener() {
			@Override
			public void onLocationChanged(Location location) {
				double lat = location.getLatitude();
				double lon = location.getLongitude();

				String texto = "Latitude:" + lat + " ,longitude:" + lon;
				Toast.makeText(context, texto, Toast.LENGTH_LONG).show();
				Log.i("COORDENADAS", texto);
				
				Intent intent = new Intent(context, C2DM_CoordinateSender.class);
				intent.putExtra("latitude", String.valueOf(lat));
				intent.putExtra("longitude", String.valueOf(lon));
				context.startService(intent);
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
