package app.fynnjason.com.mosbymvpdemo.login.presenter;

import android.support.annotation.NonNull;

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter;

import app.fynnjason.com.mosbymvpdemo.login.model.LoginModel;
import app.fynnjason.com.mosbymvpdemo.login.view.ILoginView;
import app.fynnjason.com.mosbymvpdemo.network.Request;
import app.fynnjason.com.mosbymvpdemo.network.RequestCallBack;

/**
 * Created by FynnJason on on 2018/7/26.
 * Function：登录Presenter
 */
public class LoginPresenter extends MvpBasePresenter<ILoginView> {
    public void login(String mobile, String password) {

        Request.getInstance().login(mobile, password, new RequestCallBack<LoginModel.DataBean>() {
            @Override
            public void success(LoginModel.DataBean model) {
                ifViewAttached(new ViewAction<ILoginView>() {
                    @Override
                    public void run(@NonNull ILoginView view) {
                        view.loginSuccess();
                    }
                });
            }

            @Override
            public void error(int errorCode, final String errorMsg) {
                ifViewAttached(new ViewAction<ILoginView>() {
                    @Override
                    public void run(@NonNull ILoginView view) {
                        view.loginFailure(errorMsg);
                    }
                });
            }
        });
    }
}
