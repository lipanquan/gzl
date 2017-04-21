package com.example.gzl.myapplication.service;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

import com.example.gzl.myapplication.activity.MySerActivity;

/**
 * 我的服务
 * Created by 智光 on 2016/7/7.
 */
public class MyService extends Service {
    public static String TAG = "MyService";

    public static Handler handler = new Handler();

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.e(TAG, "---> Service onStart()");
    }

    public void onCreate() {

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "---> Service onStartCommand()");
        handler.post(MySerActivity.runnable);
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        Log.e(TAG, "---> Service onDestroy()");
    }


}
