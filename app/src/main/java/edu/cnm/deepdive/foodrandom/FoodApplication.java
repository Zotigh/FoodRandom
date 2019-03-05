package edu.cnm.deepdive.foodrandom;

import android.app.Application;
import com.facebook.stetho.Stetho;

public class FoodApplication extends Application {

  private static FoodApplication instance = null;

  @Override
  public void onCreate() {
    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.
  }

  /**
   * Returns this instance, for access to application context across the app.
   *
   * @return singleton instance.
   */
  public static FoodApplication getInstance() {
    return instance;
  }

}
