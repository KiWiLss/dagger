package com.kiwilss.dagger.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kiwilss.dagger.R;

/**
 * FileName: LocalReceiverActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/30
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class LocalReceiverActivity extends AppCompatActivity {

    private LocalBroadcastManager mLocalBroadcastManager;
    private LocalReceiver mLocalReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local);

        //获取实例
        mLocalBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.broadcasttest.LOCAL_BROADCAST");
        mLocalReceiver = new LocalReceiver();
        //注册本地广播
        mLocalBroadcastManager.registerReceiver(mLocalReceiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //解除注册
        mLocalBroadcastManager.unregisterReceiver(mLocalReceiver);
    }

    public void sendLocal(View view) {
        //发送广播
        Intent intent = new Intent("com.example.broadcasttest.LOCAL_BROADCAST");
        //intent.putExtra()
            //发送本地广播
        mLocalBroadcastManager.sendBroadcast(intent);
    }

    class LocalReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            Toast.makeText(context, "receciver local broadcast", Toast.LENGTH_SHORT).show();
        }
    }
}
