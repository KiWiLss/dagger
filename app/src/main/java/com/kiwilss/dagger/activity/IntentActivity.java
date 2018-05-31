package com.kiwilss.dagger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.service.MyIntentService;
import com.kiwilss.dagger.service.MyService;

/**
 * FileName: IntentActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/31
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class IntentActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);


    }

    public void startListener(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void startIntentListener(View view) {
        Log.e("MMM", "startIntentListener: "+Thread.currentThread().getId());
        Intent intent = new Intent(this, MyIntentService.class);
        startService(intent);
    }
}
