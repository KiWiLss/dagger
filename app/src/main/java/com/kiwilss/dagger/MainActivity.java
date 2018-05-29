package com.kiwilss.dagger;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.kiwilss.dagger.interface_all.RedCloth;
import com.kiwilss.dagger.test.Cloth;
import com.kiwilss.dagger.test.DaggerMainComponent;
import com.kiwilss.dagger.test.MainComponent;
import com.kiwilss.dagger.test.MainModule;
import com.kiwilss.dagger.test2.Clothes;
import com.kiwilss.dagger.test2.Shoe;

import javax.inject.Inject;
import javax.inject.Named;

public class MainActivity extends AppCompatActivity {

    private TextView mTvOne;

//    @Inject
//    Cloth mCloth;
    //获取红色布料
    @Inject
    //@Named("red")
        @RedCloth
    Cloth mRedCloth;
    //获取蓝色布料
    @Inject
    @Named("blue")
    Cloth mBlueCloth;

    @Inject
    Shoe mShoe;

    @Inject
    Clothes mClothes;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        //
        MainComponent build = DaggerMainComponent.builder().mainModule(new MainModule()).build();
        build.inject(this);
        //mTvOne.setText("我现在有"+mCloth);
//        mTvOne.setText("我现在有"+mRedCloth+"和"+mShoe);
//        mTvOne.setText("我现在有"+mBlueCloth+"和"+mShoe+"和"+mClothes);
        mTvOne.setText("我现在有"+mRedCloth+","+mBlueCloth+","+mShoe+","+mClothes);





    }

    private void initView() {
        mTvOne = (TextView) findViewById(R.id.tv_main_one);
    }


}
