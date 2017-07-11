package net.shan.bwei.news.helper;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.utils.SocializeUtils;

import java.util.Map;

/**
 * Created by shanlianting on 2017/7/8.
 */

public class UmengHelper {
    Activity activity;
    private ProgressDialog dialog;

    public UmengHelper(Activity activity) {
        this.activity = activity;
        dialog = new ProgressDialog(activity);
    }

    public void doAuth(SHARE_MEDIA platform) {
        UMShareAPI.get(activity).doOauthVerify(activity, platform, authListener);

    }

    UMAuthListener authListener = new UMAuthListener() {
        @Override
        public void onStart(SHARE_MEDIA platform) {

        }

        @Override
        public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
             SocializeUtils.safeCloseDialog(dialog);
            Log.d("UmengHelper",""+platform);
           Toast.makeText(activity, "成功了", Toast.LENGTH_LONG).show();

        }

        @Override
        public void onError(SHARE_MEDIA platform, int action, Throwable t) {
            SocializeUtils.safeCloseDialog(dialog);
          Toast.makeText(activity, "失败：" + t.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCancel(SHARE_MEDIA platform, int action) {
            SocializeUtils.safeCloseDialog(dialog);
            Toast.makeText(activity, "取消了", Toast.LENGTH_LONG).show();
        }
    };

    public void onActivityResult(int requestCode, int resultCode, Intent data){
        UMShareAPI.get(activity).onActivityResult(requestCode, resultCode, data);
    }

    public void onDestory(){
        UMShareAPI.get(activity).release();
    }

}



