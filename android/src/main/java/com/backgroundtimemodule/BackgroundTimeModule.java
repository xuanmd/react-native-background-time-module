package com.backgroundtimemodule;

import androidx.annotation.NonNull;
import android.app.Application;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;

@ReactModule(name = BackgroundTimeModule.NAME)
public class BackgroundTimeModule extends ReactContextBaseJavaModule {
  public static final String NAME = "BackgroundTimeModule";
  private static long lastBackgroundTime = System.nanoTime();

  public BackgroundTimeModule(ReactApplicationContext reactContext) {
    super(reactContext);

    // Register listener to track app's background/foreground state
    Application application = (Application) reactContext.getApplicationContext();
    application.registerActivityLifecycleCallbacks(new AppLifecycleHandler(reactContext));
  }

  @Override
  @NonNull
  public String getName() {
    return NAME;
  }

  @ReactMethod
  public void getElapseTime(Promise promise) {
    long currentTime = System.nanoTime();
    long elapsedTime = currentTime - lastBackgroundTime;

    // Convert elapsed time from nanoseconds to seconds
    double elapsedTimeInSeconds = elapsedTime / 1_000_000_000.0;

    promise.resolve(elapsedTimeInSeconds);
  }

  // Method to update lastBackgroundTime when the app goes into the background
  static void setLastBackgroundTime() {
    lastBackgroundTime = System.nanoTime();
  }
}
