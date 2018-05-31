package com.kiwilss.dagger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.service.MyService;

/**
 * FileName: OneServiceActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/30
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class OneServiceActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one_service);




    }

    public void startService(View view) {
        Intent intent = new Intent(this, MyService.class);
        startService(intent);
    }

    public void stopService(View view) {
        Intent intent = new Intent(this, MyService.class);
        stopService(intent);
    }
}
