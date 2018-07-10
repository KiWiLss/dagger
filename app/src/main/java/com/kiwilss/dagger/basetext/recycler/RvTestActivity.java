package com.kiwilss.dagger.basetext.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiwilss.dagger.R;

/**
 * FileName: RvTestActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvTestActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtest);



    }

    public void linearListener(View view) {
        startActivity(new Intent(this, RvLinearActivity.class));
    }

    public void linearHearderFooterListener(View view) {
        startActivity(new Intent(this, RvLinearActivity2.class));
    }

    public void linearHearderFooterListener2(View view) {
        startActivity(new Intent(this, RvHeaderFooterActivity.class));
    }

    public void gridHearderFooterListener(View view) {
        startActivity(new Intent(this, GridActivity.class));
    }

    public void gridLineListener(View view) {
        startActivity(new Intent(this, GridLineActivity.class));
    }

    public void itemTouchListener(View view) {
        startActivity(new Intent(this, RvItemTouchActivity.class));
    }

    public void toutiaoOne(View view) {
        startActivity(new Intent(this, TouTiaoOneActivty.class));
    }

    public void toutiaoTwo(View view) {
        startActivity(new Intent(this, TouTiaoTwoActivity.class));
    }
}
