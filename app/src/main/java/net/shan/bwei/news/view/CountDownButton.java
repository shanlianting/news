package net.shan.bwei.news.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.Button;

/**
 * Created by shanlianting on 2017/7/9.
 */

@SuppressLint("AppCompatCustomView")
public class CountDownButton extends Button {
    private static final int TIME_TO_COUNT = 60; // 60s

    private CharSequence mText;
    private int mCount = TIME_TO_COUNT;
    private boolean mIsCounting = false;
    public CountDownButton(Context context) {
        super(context);
    }

    public CountDownButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CountDownButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void startCountDown() {
        post(new Runnable() {
            @Override
            public void run() {
                setEnabled(false);
                mText = getText();
                mIsCounting = true;
                doCountDown();
            }
        });
    }

    public void stopCountDown() {
        post(new Runnable() {
            @Override
            public void run() {
                setEnabled(true);
                setText(mText);
                mIsCounting = false;
                mCount = TIME_TO_COUNT;
            }
        });
    }

    private void doCountDown() {
        setText(String.format("%s秒后重试", mCount));
        postDelayed(new Runnable() {
            @Override
            public void run() {
                if (!mIsCounting) {
                    return;
                }

                mCount --;
                if (mCount == 0) {
                    stopCountDown();
                } else {
                    doCountDown();
                }
            }
        }, 1000);
    }
}
