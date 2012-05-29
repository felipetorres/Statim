package br.com.c2dm;

import java.io.IOException;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import constants.StatimConstants;

public class C2DM_RegistrationReceiver extends BroadcastReceiver {
	
    public void onReceive(Context context, Intent intent) {
  
        String action = intent.getAction();
        
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String registrationId = intent.getStringExtra("registration_id");
            sendToServer(registrationId);
            Log.i("REGISTRO","registrationId=" + registrationId);
        }
    }
    
    private void sendToServer(String registrationId) {
    	String url = StatimConstants.server_url + "/new/" + StatimConstants.sender_email + "/" + registrationId;
    	HttpClient client = new DefaultHttpClient();
    	HttpPost post = new HttpPost(url);
    	try {
			client.execute(post);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
}