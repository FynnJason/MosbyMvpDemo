package app.fynnjason.com.mosbymvpdemo.login.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.widget.Button;
import android.widget.EditText;

import app.fynnjason.com.mosbymvpdemo.R;
import app.fynnjason.com.mosbymvpdemo.base.BaseActivity;
import app.fynnjason.com.mosbymvpdemo.login.presenter.LoginPresenter;
import butterknife.BindView;
import butterknife.OnClick;

public class LoginActivity extends BaseActivity<ILoginView, LoginPresenter> implements ILoginView {

    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public Context getContext() {
        return this;
    }

    @NonNull
    @Override
    public LoginPresenter createPresenter() {
        return new LoginPresenter();
    }

    @Override
    public void initView() {

    }

    @Override
    public void initListener() {

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String mobile = etAccount.getText().toString();
        String password = etPassword.getText().toString();
        presenter.login(mobile, password);
    }

    @Override
    public void loginSuccess() {
        toast("登录成功！");
    }

    @Override
    public void loginFailure(final String msg) {
        toast(msg);
    }
}
