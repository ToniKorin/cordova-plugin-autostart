/*
 Author: Toni Korin

 Licensed to the Apache Software Foundation (ASF) under one
 or more contributor license agreements.  See the NOTICE file
 distributed with this work for additional information
 regarding copyright ownership.  The ASF licenses this file
 to you under the Apache License, Version 2.0 (the
 "License"); you may not use this file except in compliance
 with the License.  You may obtain a copy of the License at

 http://www.apache.org/licenses/LICENSE-2.0

 Unless required by applicable law or agreed to in writing,
 software distributed under the License is distributed on an
 "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 KIND, either express or implied.  See the License for the
 specific language governing permissions and limitations
 under the License.
 */
 
package com.tonikorin.cordova.plugin.autostart;
 
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.SharedPreferences;
import com.tonikorin.cordova.plugin.autostart.AutoStart;
import android.util.Log;
 
public class StartAppAtBootReceiver extends BroadcastReceiver {
    
    private static boolean firstUserPresent = false;
    private static boolean bootCompleted    = false;
    
    @Override
    public void onReceive(Context context, Intent intent) {
        if ( intent.getAction().equals(Intent.ACTION_USER_PRESENT) ){
            if( firstUserPresent ){
                return; // Start the app only after the first unlock 
            } else {
                firstUserPresent = true;
            }
        }
        else if ( intent.getAction().equals(Intent.ACTION_BOOT_COMPLETED) ){
            bootCompleted = true; // ACTION_USER_PRESENT comes always after ACTION_BOOT_COMPLETED
        }
        if ( bootCompleted && firstUserPresent ) {
            SharedPreferences sp = context.getSharedPreferences(AutoStart.PREFS, Context.MODE_PRIVATE);
            Boolean enabled = sp.getBoolean(AutoStart.ENABLED, false);
            if ( enabled ) {
                String packageName = context.getPackageName();
                String className = sp.getString(AutoStart.CLASS_NAME, "");
                Intent serviceIntent = new Intent();
                serviceIntent.setClassName(context, packageName + "." + className);
                serviceIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(serviceIntent);
            }
        }
    }
}
