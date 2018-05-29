package com.kiwilss.dagger;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kiwilss.dagger.test.Cloth;
import com.kiwilss.dagger.test.DaggerMainComponent;
import com.kiwilss.dagger.test.MainComponent;
import com.kiwilss.dagger.test.MainModule;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    private TextView mTvOne;

    @Inject
    Cloth mCloth;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //
        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        build.inject(this);
        mTvOne.setText("我现在有"+mCloth);

    }

    private void initView() {
        mTvOne = (TextView) findViewById(R.id.tv_main_one);
    }


}
