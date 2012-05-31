package br.com.c2dm;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class C2DM_RegistrationReceiver extends BroadcastReceiver {
	
    public void onReceive(Context context, Intent intent) {
  
        String action = intent.getAction();
        
        if ("com.google.android.c2dm.intent.REGISTRATION".equals(action)) {
            String newRegistrationId = intent.getStringExtra("registration_id");
            RegistrationManager manager = new RegistrationManager(context);
            manager.manage(newRegistrationId);
            Log.i("REGISTRO","registrationId=" + newRegistrationId);
        }
    }
}