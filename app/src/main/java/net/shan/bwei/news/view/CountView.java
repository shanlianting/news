package net.shan.bwei.news.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import net.shan.bwei.news.R;

/**
 * Created by shanlianting on 2017/7/11.
 */

public class CountView extends LinearLayout {

    ImageView addImageView;
    ImageView minusImageView;
    EditText numberEditText;

    private int count = 1;

    public CountView(Context context) {
        super(context);
        init(context, null);
    }


    public CountView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);

    }

    public CountView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    void init(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R.layout.view_countview_content, this, true);
        addImageView = findViewById(R.id.addImageView);
        minusImageView = findViewById(R.id.minusImageView);
        numberEditText = findViewById(R.id.numberEditText);
        numberEditText.setText(String.valueOf(count));

        minusImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                count--;
                if (count <= 0) {
                    count = 0;
                }
                numberEditText.setText(String.valueOf(count));
            }
        });

        addImageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                numberEditText.setText(String.valueOf(count));
            }
        });

        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.CountViewAttr);
        int addResource=typedArray.getResourceId(R.styleable.CountViewAttr_iconAdd,R.mipmap.ic_launcher);
        int minusResource = typedArray.getResourceId(R.styleable.CountViewAttr_iconMinus,R.mipmap.ic_launcher);
        addImageView.setImageResource(addResource);
        minusImageView.setImageResource(minusResource);
        typedArray.recycle();


    }


}
