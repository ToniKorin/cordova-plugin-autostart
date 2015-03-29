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

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONArray;
import org.json.JSONException;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.ComponentName;

public class AutoStart extends CordovaPlugin {
    
    public static final String PREFS = "autostart";
    public static final String CLASS_NAME = "class";

    /**
     * Executes the request.
     *
     * @param action The action to execute.
     * @param args The exec() arguments.
     * @param callback The callback context used when calling back into
     * JavaScript.
     * @return Returning false results in a "MethodNotFound" error.
     *
     * @throws JSONException
     */
    @Override
    public boolean execute(String action, JSONArray args,
            CallbackContext callback) throws JSONException {

        if ( action.equalsIgnoreCase("enable") ) {
            setAutoStart(true);
            return true;
        } else if ( action.equalsIgnoreCase("disable") ) {
            setAutoStart(false);
            return true;
        }
        return false;
    }

    private void setAutoStart(boolean enabled) {

        Context context = cordova.getActivity().getApplicationContext();
        int componentState = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
        if ( enabled ) { 
            componentState = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
            // Store the class name of your activity for AppStarter
            SharedPreferences sp = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(CLASS_NAME, cordova.getActivity().getLocalClassName());
            editor.commit();  
        }
        // Enable or Disable BootCompletedReceiver
        ComponentName receiver = new ComponentName(context, BootCompletedReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(receiver, componentState, PackageManager.DONT_KILL_APP);
    }
}
