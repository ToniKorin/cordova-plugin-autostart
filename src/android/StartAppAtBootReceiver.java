package com.tonikorin.cordova.plugin.autostart;
 
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import com.tonikorin.cordova.plugin.autostart.AutoStart;
 
public class StartAppAtBootReceiver extends BroadcastReceiver {
    
    @Override
    public void onReceive(Context context, Intent intent) {
        SharedPreferences sp = context.getSharedPreferences(AutoStart.PREFS, Context.MODE_PRIVATE);
        Boolean enabled = sp.getBoolean(AutoStart.ENABLED, false);
        if (enabled) {
            String packageName = context.getPackageName();
            String className = sp.getString(AutoStart.CLASS_NAME, "");
            Intent serviceIntent = new Intent();
            serviceIntent.setClassName(context, packageName + "." + className);
            serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(serviceIntent);
        }
    }
}
