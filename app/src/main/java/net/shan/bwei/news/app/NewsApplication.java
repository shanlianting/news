package net.shan.bwei.news.app;

import android.app.Application;

import org.xutils.x;

/**
 * Created by shanlianting on 2017/7/6.
 */

public class NewsApplication  extends Application{
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);
    }
}
