package app.fynnjason.com.mosbymvpdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import app.fynnjason.com.mosbymvpdemo.login.view.LoginActivity;
import app.fynnjason.com.mosbymvpdemo.network.Request;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_login_demo)
    Button btnLoginDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_login_demo)
    public void onViewClicked() {
        startActivity(new Intent(MainActivity.this, LoginActivity.class));
    }
}
