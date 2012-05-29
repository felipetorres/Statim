package br.com.c2dm;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import constants.StatimConstants;

public class C2DM_Activity extends Activity {
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        TextView tv = new TextView(this);
        tv.setText("Conecte o celular a um computador, abra o LogCat e pegue seu registrationId.");
        setContentView(tv);
        
        register();
    }

	private void register() {
		Intent intent = new Intent("com.google.android.c2dm.intent.REGISTER");
        
        intent.putExtra("app", PendingIntent.getBroadcast(this, 0, new Intent(), 0));
        intent.putExtra("sender", StatimConstants.sender_email);
        
        startService(intent);
	}
}
