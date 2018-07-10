package com.kiwilss.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kiwilss.dagger.R;

/**
 * FileName: TouTiaoDetailActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/10
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class TouTiaoDetailActivity extends AppCompatActivity {
    private android.widget.TextView tvtoutiaodetailcontent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toutiao_detail);
        this.tvtoutiaodetailcontent = (TextView) findViewById(R.id.tv_toutiao_detail_content);

        String title = getIntent().getStringExtra("title");
        tvtoutiaodetailcontent.setText(title);
    }
}
