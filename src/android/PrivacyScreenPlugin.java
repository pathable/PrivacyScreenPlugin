/**
 * PrivacyScreenPlugin.java Cordova Plugin Implementation
 * Created by Tommy-Carlos Williams on 18/07/14.
 * Copyright (c) 2014 Tommy-Carlos Williams. All rights reserved.
 * MIT Licensed
 */
package org.devgeeks.privacyscreen;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import android.app.Activity;
import android.view.Window;
import android.view.WindowManager;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.content.Context;
import android.os.Bundle;

/**
 * This class sets the FLAG_SECURE flag on the window to make the app
 *  private when shown in the task switcher
 */
public class PrivacyScreenPlugin extends CordovaPlugin {

  private String SET_FLAG_SECURE_ACTION = "set";
  private String UNSET_FLAG_SECURE_ACTION = "unset";

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

    if (action.equalsIgnoreCase(SET_FLAG_SECURE_ACTION)) {
      this.setFlagSecure(callbackContext);
    } else if (action.equalsIgnoreCase(UNSET_FLAG_SECURE_ACTION)) {
      this.unsetFlagSecure(callbackContext);
    }

    return false;
  }

  private void setFlagSecure(CallbackContext callbackContext) {
    this.cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Activity activity = this.cordova.getActivity();
        activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
        callbackContext.success("Screenshots disabled.");
      }
    });
  }

  private void unsetFlagSecure(CallbackContext callbackContext) {
    this.cordova.getActivity().runOnUiThread(new Runnable() {
      @Override
      public void run() {
        Activity activity = this.cordova.getActivity();
        int flags = activity.getWindow().getAttributes().flags;
        if ((flags & WindowManager.LayoutParams.FLAG_SECURE) = 0) {
          callbackContext.success("Screenshots are already enabled.");
          return;
        }
        activity.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
        callbackContext.success("Screenshots enabled.");
      }
    });
  }
}
