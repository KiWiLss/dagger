package com.kiwilss.dagger.basetext.textview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.coorchice.library.SuperTextView;
import com.kiwilss.dagger.R;

/**
 * FileName: SuperTextView
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/5
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class SuperTextViewActivity extends AppCompatActivity {

    private SuperTextView mSv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_super_textview);


        mSv = findViewById(R.id.stv_2_1);



     /*   //设置圆角
        mSv.setCorner(20);
        //获取圆角
        mSv.getCorner();
        //设置边框颜色
        mSv.setStrokeColor(1);
        //设置边框宽度
        mSv.setStrokeWidth(1);*/


    }
}
