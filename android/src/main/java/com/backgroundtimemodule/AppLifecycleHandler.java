package com.backgroundtimemodule;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.facebook.react.bridge.ReactApplicationContext;

public class AppLifecycleHandler implements Application.ActivityLifecycleCallbacks {
  private final ReactApplicationContext reactContext;

  public AppLifecycleHandler(ReactApplicationContext reactContext) {
    this.reactContext = reactContext;
  }

  @Override
  public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
  }

  @Override
  public void onActivityStarted(Activity activity) {
  }

  @Override
  public void onActivityResumed(Activity activity) {
  }

  @Override
  public void onActivityPaused(Activity activity) {
  }

  @Override
  public void onActivityStopped(Activity activity) {
      BackgroundTimeModule.setLastBackgroundTime();
  }

  @Override
  public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
  }

  @Override
  public void onActivityDestroyed(Activity activity) {
  }
}
