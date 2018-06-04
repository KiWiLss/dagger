package com.kiwilss.dagger.activity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiwilss.dagger.MainActivity;
import com.kiwilss.dagger.R;

/**
 * FileName: AlarmActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/1
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class AlarmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alarm);
    }

    public void alarmTimer(View view) {
        //10秒后跳转到首页
        Intent intent = new Intent(this, MainActivity.class);
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, 0);
        AlarmManager manager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        long triggerAtTime = SystemClock.elapsedRealtime() + 10 * 1000;
        manager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP,triggerAtTime, pi);
    }
}
