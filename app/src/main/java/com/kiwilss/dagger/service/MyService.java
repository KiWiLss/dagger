package com.kiwilss.dagger.service;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * FileName: MyService
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyService extends Service {

    public static final String TAG="MMM";

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: " );
        return null;
    }

    public MyService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.e(TAG, "onStartCommand: " );
        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: " );
    }
}
