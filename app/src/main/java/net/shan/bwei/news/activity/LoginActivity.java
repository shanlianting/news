package net.shan.bwei.news.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.umeng.socialize.bean.SHARE_MEDIA;

import net.shan.bwei.news.R;
import net.shan.bwei.news.helper.UmengHelper;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity implements View.OnClickListener{

    ImageView weiboImageView;
    ImageView weixinImageView;
    ImageView qqImageView;
    Button loginButton;
    private UmengHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        weiboImageView = (ImageView) findViewById(R.id.wb_login_imageView);
        weiboImageView.setOnClickListener(this);
        weixinImageView = (ImageView) findViewById(R.id.wx_login_imageView);
        weixinImageView.setOnClickListener(this);
        qqImageView = (ImageView) findViewById(R.id.qq_login_imageView);
        loginButton = (Button) findViewById(R.id.email_sign_in_button);
        loginButton.setOnClickListener(this);
        qqImageView.setOnClickListener(this);
        helper = new UmengHelper(this);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        helper.onDestory();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        helper.onActivityResult(requestCode,resultCode,data);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.wb_login_imageView:
                helper.doAuth(SHARE_MEDIA.SINA);
                break;
            case R.id.wx_login_imageView:
                helper.doAuth(SHARE_MEDIA.WEIXIN);
                break;
            case R.id.qq_login_imageView:
                helper.doAuth(SHARE_MEDIA.QQ);
                break;
            case R.id.email_sign_in_button:
                changeMode();
                break;
        }

    }

     void changeMode() {
         AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
    }
}

