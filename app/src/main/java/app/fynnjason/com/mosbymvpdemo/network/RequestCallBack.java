package app.fynnjason.com.mosbymvpdemo.network;

/**
 * Created by FynnJason on on 2018/7/26.
 * Function：网络请求回调
 */
public interface RequestCallBack<T> {
    void success(T model);

    void error(int errorCode, String errorMsg);
}
