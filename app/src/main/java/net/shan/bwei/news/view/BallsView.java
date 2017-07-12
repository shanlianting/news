package net.shan.bwei.news.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by shanlianting on 2017/7/12.
 */

public class BallsView extends View {
    public static final String TAG = "BallView";
    private int width;
    private int height;
    int radis = 40;

    private double cicleX;
    private double cicleY;

    private double downX;
    private double downY;

    public BallsView(Context context) {
        this(context, null);

    }

    public BallsView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BallsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        width = this.getMeasuredWidth();
        height = this.getMeasuredHeight();
        Log.d(TAG, "width = " + width + ",height =" + height);
        cicleX = width / 2;
        cicleY = height / 2;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        canvas.drawCircle((float) cicleX, (float) cicleY, radis, paint);

    }
    boolean isInball;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:

                downX = event.getX();
                downY = event.getY();
                isInball = isInBall(downX,downY);
                Log.d(TAG, event.getX() + "," + event.getY() +", is in ball = ");
                break;
            case MotionEvent.ACTION_MOVE:

                downX = event.getX();
                downY = event.getY();
                isInball = isInBall(downX,downY);
                if (isInball){
                    cicleX = downX;
                    cicleY = downY;
                    postInvalidate();
                }

                break;
            case MotionEvent.ACTION_UP:
                break;
        }

        return true;


        //return super.onTouchEvent(event);
    }


    public boolean isInBall(double downX, double downY) {
        double distance = Math.sqrt((downX - cicleX) * (downX - cicleX) + (downY - cicleY) * (downY - cicleY));
        if (distance > radis) {
            return false;
        }
        return true;
    }
}
