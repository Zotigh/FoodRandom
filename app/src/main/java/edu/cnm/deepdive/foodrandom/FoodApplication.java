package edu.cnm.deepdive.foodrandom;

import android.app.Application;
import com.facebook.stetho.Stetho;
//TODO Ask if this is ok since i took it from nasa apod
/**
 * Extends {@link Application}, in order to initialize <a href="http://facebook.github.io/stetho/">Stetho</a>
 * inspection and set up access to this instance via the singleton pattern. At runtime, any instance
 * of an {@link Application} subclass is a de facto singleton; the common {@link #getInstance()}
 * implementation is used here to enable access to the singleton by other classes in the app.
 */
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
