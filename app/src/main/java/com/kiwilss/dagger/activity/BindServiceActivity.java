package com.kiwilss.dagger.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.service.MyServiceTwo;

/**
 * FileName: BindServiceActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class BindServiceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bind_service);

    }
    MyServiceTwo.DownloadBinder downloadBinder;
    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
             downloadBinder = (MyServiceTwo.DownloadBinder) iBinder;
            downloadBinder.startDownload();
            downloadBinder.getProgress();


        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {

        }
    };

    public void startService(View view) {
        Intent intent = new Intent(this, MyServiceTwo.class);
        bindService(intent,mConnection,BIND_AUTO_CREATE);
    }

    public void stopService(View view) {
        unbindService(mConnection);
    }
}
