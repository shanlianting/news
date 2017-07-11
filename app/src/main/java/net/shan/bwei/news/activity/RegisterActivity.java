package net.shan.bwei.news.activity;

import android.content.res.Resources;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import net.shan.bwei.news.R;
import net.shan.bwei.news.view.CountDownButton;
import net.shan.bwei.news.view.ImageTextView;


/**
 * Created by shanlianting on 2017/7/9.
 */

public class RegisterActivity extends AppCompatActivity{
    ImageTextView imageTextView;
    CountDownButton button;
    CheckBox checkBox;
    int theme;
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
