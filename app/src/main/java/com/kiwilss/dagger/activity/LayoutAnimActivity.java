package com.kiwilss.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.kiwilss.dagger.R;

/**
 * FileName: LayoutAnimActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class LayoutAnimActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout_anim);

        //可以不用加
        //AnimationUtils.loadLayoutAnimation(this,R.anim.text_alpha);

    }
}
