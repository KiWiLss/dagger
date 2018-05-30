package com.kiwilss.dagger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.kiwilss.dagger.R;

/**
 * FileName: ReceiverTwoActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/5/30
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class ReceiverTwoActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receiver_two);



    }

    public void sendListener2(View view) {
        Log.e("MMM", "sendListener2: ");
        Intent intent = new Intent();
        intent.setAction("com.broadcast");
        intent.putExtra("key","broad1");
        sendBroadcast(intent);
    }
}
