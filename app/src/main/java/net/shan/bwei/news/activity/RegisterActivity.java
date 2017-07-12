package net.shan.bwei.news.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

import net.shan.bwei.news.R;
import net.shan.bwei.news.view.CountDownButton;
import net.shan.bwei.news.view.ImageTextView;

import java.util.HashMap;

import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.RegisterPage;


/**
 * Created by shanlianting on 2017/7/9.
 */

public class RegisterActivity extends AppCompatActivity{
    ImageTextView imageTextView;
    CountDownButton button;
    CheckBox checkBox;
    Button getCodeButton;
    EventHandler eventHandler;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        button = (CountDownButton) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                button.startCountDown();
            }
        });
        imageTextView = (ImageTextView) findViewById(R.id.imageTextView);
        imageTextView.image(R.drawable.ic_qq_login_normal).textView("qq");
        checkBox = (CheckBox) findViewById(R.id.change);


        SMSSDK.setAskPermisionOnReadContact(true);

        // 创建EventHandler对象
         eventHandler = new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                if (data instanceof Throwable) {
                    Throwable throwable = (Throwable)data;
                    String msg = throwable.getMessage();
                    Toast.makeText(RegisterActivity.this, msg, Toast.LENGTH_SHORT).show();
                } else {
                    if (event == SMSSDK.EVENT_GET_VERIFICATION_CODE) {
                        // 处理你自己的逻辑
                    }
                }
            }
        };

        // 注册监听器
        SMSSDK.registerEventHandler(eventHandler);





        getCodeButton = (Button) findViewById(R.id.getCodeButton);

        getCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.setRegisterCallback(new EventHandler() {
                    public void afterEvent(int event, int result, Object data) {
                        if (result == SMSSDK.RESULT_COMPLETE) {
                            HashMap<String,Object> phoneMap = (HashMap<String, Object>) data;
                            String country = (String) phoneMap.get("country");
                            String phone = (String) phoneMap.get("phone");

                        }
                    }


                });
                registerPage.show(RegisterActivity.this);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        SMSSDK.unregisterEventHandler(eventHandler);
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

    }
}
