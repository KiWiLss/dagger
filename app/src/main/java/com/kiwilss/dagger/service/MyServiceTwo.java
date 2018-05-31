package com.kiwilss.dagger.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * FileName: MyServiceTwo
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyServiceTwo extends Service {
    public static final String TAG="MMM";
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        Log.e(TAG, "onBind: ");

        return mDownloadBinder;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.e(TAG, "onCreate: ");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy: ");
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.e(TAG, "onUnbind: ");

        return super.onUnbind(intent);
    }

    private DownloadBinder mDownloadBinder= new DownloadBinder();

    public class DownloadBinder extends Binder{
        public void startDownload(){
            Log.e(TAG, "startDownload: startdownload" );
        }

        public int getProgress(){
            Log.e(TAG, "getProgress: " );
            return 0;
        }
    }
}
