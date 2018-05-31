package com.kiwilss.dagger.service;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * FileName: MyIntentService
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

//    public MyIntentService(String name) {
//        super(name);
//    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.e("MMM", "onHandleIntent: "+Thread.currentThread().getId() );
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("MMM", "onDestroy: ");
    }
}
