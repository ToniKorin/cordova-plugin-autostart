package com.tonikorin.cordova.plugin.autostart;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import com.tonikorin.cordova.plugin.autostart.AppStarter;
 
public class UserPresentReceiver extends BroadcastReceiver {
    
    @Override
    public void onReceive(Context context, Intent intent) {
    
        AppStarter appStarter = new AppStarter();
        appStarter.run(context, intent, PackageManager.COMPONENT_ENABLED_STATE_DISABLED, true);
    }
}
