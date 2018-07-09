package com.kiwilss.dagger.arouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.kiwilss.dagger.Constance;
import com.kiwilss.dagger.R;

/**
 * FileName: ArouterOneActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */

@Route(path = Constance.ACTIVITY_URL_ONE)
public class ArouterOneActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter);




    }
}
