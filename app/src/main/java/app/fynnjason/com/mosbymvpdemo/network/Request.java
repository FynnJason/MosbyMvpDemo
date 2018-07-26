package app.fynnjason.com.mosbymvpdemo.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import app.fynnjason.com.mosbymvpdemo.BuildConfig;
import app.fynnjason.com.mosbymvpdemo.R;
import app.fynnjason.com.mosbymvpdemo.api.ApiService;
import app.fynnjason.com.mosbymvpdemo.base.BaseApplication;
import app.fynnjason.com.mosbymvpdemo.login.model.LoginModel;
import app.fynnjason.com.mosbymvpdemo.utils.RxSchedulers;
import app.fynnjason.com.mosbymvpdemo.utils.StringUtils;
import io.reactivex.functions.Consumer;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by FynnJason on on 2018/7/26.
 * Function：网络请求
 */
public class Request {

    private static final int SUCCESS = 200;
    private static final int NETWORK_ERROR = 500; //没有网的情况
    private static final int JSON_ERROR = 501; //Json解析错误的情况

    private final ApiService mApiService;

    private Request() {
        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();

        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(loggingInterceptor);
        }

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://zhepm.com/api/")
                .client(builder.build())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        mApiService = retrofit.create(ApiService.class);
    }

    private static class Holder {
        private static Request sRequest = new Request();
    }

    public static Request getInstance() {
        return Holder.sRequest;
    }

    public void login(String mobile, String password, final RequestCallBack<LoginModel.DataBean> callBack) {
        mApiService.login(mobile, password)
                .compose(RxSchedulers.<LoginModel>compose())
                .subscribe(new Consumer<LoginModel>() {
                    @Override
                    public void accept(LoginModel loginModel) throws Exception {
                        if (loginModel.getCode() == SUCCESS) {
                            callBack.success(loginModel.getData());
                        } else {
                            callBack.error(loginModel.getCode(), loginModel.getMsg());
                        }
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        if (StringUtils.noNetWork(throwable.getMessage())) {
                            callBack.error(NETWORK_ERROR, BaseApplication.getApplication().getString(R.string.no_network));
                        } else {
                            callBack.error(JSON_ERROR, BaseApplication.getApplication().getString(R.string.json_error));
                        }
                    }
                });
    }
}
