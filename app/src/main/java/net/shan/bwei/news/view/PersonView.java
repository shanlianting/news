package net.shan.bwei.news.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import net.shan.bwei.news.R;

/**
 * Created by shanlianting on 2017/7/9.
 */

public class PersonView extends AppCompatTextView {
    public PersonView(Context context) {
        super(context);
    }

    public PersonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.PersonAttr);
        String name = typedArray.getString(R.styleable.PersonAttr_name);
        int age = typedArray.getInt(R.styleable.PersonAttr_age,1);
        boolean adult = typedArray.getBoolean(R.styleable.PersonAttr_adult,true);
        int  weight = typedArray.getInt(R.styleable.PersonAttr_weight,1);
        int sex = typedArray.getIndex(R.styleable.PersonAttr_sex);
        typedArray.recycle();
        setText(name+",\n"+age+"\n"+isAdult(adult));

    }

    public String isAdult(boolean isAdult){
        if (isAdult){
            return  "已经成年";
        }else {
            return "未成年";
        }
    }

    public PersonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
