package app.fynnjason.com.mosbymvpdemo.api;

import app.fynnjason.com.mosbymvpdemo.login.model.LoginModel;
import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by FynnJason on on 2018/7/26.
 * Function：接口地址
 */
public interface ApiService {
    @POST("user/login")
    @FormUrlEncoded
    Observable<LoginModel> login(@Field("mobile") String mobile, @Field("password") String password);
}
