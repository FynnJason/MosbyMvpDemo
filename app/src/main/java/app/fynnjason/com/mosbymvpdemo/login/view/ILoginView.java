package app.fynnjason.com.mosbymvpdemo.login.view;

import com.hannesdorfmann.mosby3.mvp.MvpView;

/**
 * Created by FynnJason on on 2018/7/26.
 * Function：登录View
 */
public interface ILoginView extends MvpView {
    void loginSuccess();

    void loginFailure(String msg);
}
