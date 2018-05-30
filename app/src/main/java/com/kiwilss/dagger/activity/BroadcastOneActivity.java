package com.kiwilss.dagger.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.kiwilss.dagger.R;

/**
 * FileName: BroadcastOneActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/30
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class BroadcastOneActivity extends AppCompatActivity {

    private NetworkChangeReceiver mNetworkChangeReceiver;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_broadcast_one);
        //动态注册,必须要取消注册
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        mNetworkChangeReceiver = new NetworkChangeReceiver();
        //注册广播
        registerReceiver(mNetworkChangeReceiver,intentFilter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //取消注册
        if (mNetworkChangeReceiver!=null){
            unregisterReceiver(mNetworkChangeReceiver);
        }
    }

    class NetworkChangeReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
//            String key = intent.getStringExtra("key");
//            Log.e("MMM", "onReceive: "+key);
            //监控网络状况
            ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
            assert cm != null;
            NetworkInfo ni = cm.getActiveNetworkInfo();
            if (ni!=null&&ni.isAvailable()){
                Toast.makeText(context, "network is available", Toast.LENGTH_SHORT).show();
            }else {
                Toast.makeText(context, "network is unavailable", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void sendListener(View view) {
        //发送广播
//        Intent intent = new Intent();
//        intent.setAction("android.net.conn.custom");
//        intent.putExtra("key","value");
//        sendBroadcast(intent);
    }
}
