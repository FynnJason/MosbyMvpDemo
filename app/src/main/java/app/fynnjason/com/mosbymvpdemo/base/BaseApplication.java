package app.fynnjason.com.mosbymvpdemo.base;

import android.app.Application;

/**
 * Created by FynnJason on on 2018/7/26.
 * Function：项目Application
 */
public class BaseApplication extends Application {

    private static BaseApplication sApplication;

    public static BaseApplication getApplication() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}
