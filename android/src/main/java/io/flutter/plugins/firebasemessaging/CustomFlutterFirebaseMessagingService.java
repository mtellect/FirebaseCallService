// Copyright 2017 The Chromium Authors. All rights reserved.
// Use of this source code is governed by a BSD-style license that can be
// found in the LICENSE file.

//package android.src.main.java.io.flutter.plugins.firebasemessaging;
package io.flutter.plugins.firebasemessaging;

import android.content.Intent;

import com.google.firebase.messaging.RemoteMessage;
import io.flutter.plugins.firebasemessaging.FlutterFirebaseMessagingService;

public class CustomFlutterFirebaseMessagingService extends FlutterFirebaseMessagingService {
  @Override
  public void onMessageReceived(RemoteMessage remoteMessage) {
    if (remoteMessage.getData().containsKey("is_call")) {
      Intent intent = getPackageManager().getLaunchIntentForPackage(getPackageName());
      startActivity(intent);
    } else
      super.onMessageReceived(remoteMessage);
  }
}