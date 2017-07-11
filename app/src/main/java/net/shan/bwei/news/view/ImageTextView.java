package net.shan.bwei.news.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import net.shan.bwei.news.R;

/**
 * Created by shanlianting on 2017/7/9.
 */

public class ImageTextView  extends LinearLayout{
    int count =0;
    private ImageView imageView;
    private TextView textView;
    public ImageTextView(Context context) {
        super(context);
        init(context);

    }

    public ImageTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);

    }


    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.image_text_content, this, true);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);

        imageView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                count++;
                textView.setText(String.valueOf(count));
            }
        });
    }

    public ImageTextView image(int image){
        imageView.setImageResource(image);
        return this;
    }
    public ImageTextView textView(String text){
        textView.setText(text);
        return this;
    }
}
