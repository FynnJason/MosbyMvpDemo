package app.fynnjason.com.mosbymvpdemo.utils;

import android.util.Log;

import app.fynnjason.com.mosbymvpdemo.BuildConfig;

/**
 * Created by FynnJason on on 2018/6/19.
 * Function：日志工具
 */
public class LogUtils {
    public static void e(String msg) {
        if (BuildConfig.DEBUG)
            Log.e("LogUtils", msg);
    }
}
