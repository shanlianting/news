package net.shan.bwei.news.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import net.shan.bwei.news.R;
import net.shan.bwei.news.view.CountDownButton;
import net.shan.bwei.news.view.ImageTextView;


/**
 * Created by shanlianting on 2017/7/9.
 */

public class RegisterActivity extends AppCompatActivity{
    ImageTextView imageTextView;
    CountDownButton button;
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

    }
}
