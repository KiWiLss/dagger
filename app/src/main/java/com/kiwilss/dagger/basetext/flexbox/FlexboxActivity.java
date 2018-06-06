package com.kiwilss.dagger.basetext.flexbox;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kiwilss.dagger.R;

/**
 * FileName: FlexboxActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/5
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class FlexboxActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flexbox);


    }


    /**自身实现瀑布流
     * @param view
     */
    public void rvOneListener(View view) {
        startActivity(new Intent(this,RvOneActivity.class));
    }

    /**结合实现的流式布局
     * @param view
     */
    public void rvTwo(View view) {

    }
}
