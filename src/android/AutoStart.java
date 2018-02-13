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
    public static final String ACTIVITY_CLASS_NAME = "class";
    public static final String SERVICE_CLASS_NAME = "service";

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
            enableAutoStart(cordova.getActivity().getLocalClassName(), false);
            return true;
        } else if ( action.equalsIgnoreCase("enableService") ) {
            final String serviceClassName = args.getString(0);
            enableAutoStart(serviceClassName, true);
            return true;
        } else if ( action.equalsIgnoreCase("disable") ) {
            disableAutoStart();
            return true;
        }
        return false;
    }

    private void enableAutoStart(final String className, boolean isService) {
        if (className != null) {
            setAutoStart(className, true, isService);
        }
    }

    private void disableAutoStart() {
        setAutoStart(null, false, false);
    }

    private void setAutoStart(final String className, boolean enabled, boolean isService) {

        Context context = cordova.getActivity().getApplicationContext();
        int componentState;
        SharedPreferences sp = context.getSharedPreferences(PREFS, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        if ( enabled ) {
            componentState = PackageManager.COMPONENT_ENABLED_STATE_ENABLED;
            // Store the class name of your service or main activity for AppStarter
            final String preferenceKey = isService ? SERVICE_CLASS_NAME : ACTIVITY_CLASS_NAME;
            editor.putString(preferenceKey, className);
        } else {
            componentState = PackageManager.COMPONENT_ENABLED_STATE_DISABLED;
            editor.remove(ACTIVITY_CLASS_NAME);
            editor.remove(SERVICE_CLASS_NAME);
        }
        editor.commit();
        // Enable or Disable BootCompletedReceiver
        ComponentName bootCompletedReceiver = new ComponentName(context, BootCompletedReceiver.class);
        PackageManager pm = context.getPackageManager();
        pm.setComponentEnabledSetting(bootCompletedReceiver, componentState, PackageManager.DONT_KILL_APP);
    }
}
