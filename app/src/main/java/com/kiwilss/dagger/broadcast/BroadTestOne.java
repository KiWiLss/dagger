package com.kiwilss.dagger.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/**
 * FileName: BroadTestOne
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/30
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class BroadTestOne extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String key = intent.getStringExtra("key");
        Log.e("MMM", "onReceive: "+key);
    }
}
