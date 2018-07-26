package app.fynnjason.com.mosbymvpdemo.utils;

/**
 * Created by FynnJason on on 2018/7/26.
 * Function：字符串工具类
 */
public class StringUtils {
    public static boolean noNetWork(String msg) {
        return msg.contains("No address associated with hostname");
    }
}
