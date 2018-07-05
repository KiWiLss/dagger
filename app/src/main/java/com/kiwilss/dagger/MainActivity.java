package com.kiwilss.dagger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.kiwilss.dagger.activity.AlarmActivity;
import com.kiwilss.dagger.activity.BindServiceActivity;
import com.kiwilss.dagger.activity.BroadcastOneActivity;
import com.kiwilss.dagger.activity.ContentActivity;
import com.kiwilss.dagger.activity.IntentActivity;
import com.kiwilss.dagger.activity.LayoutAnimActivity;
import com.kiwilss.dagger.activity.LocalReceiverActivity;
import com.kiwilss.dagger.activity.OneServiceActivity;
import com.kiwilss.dagger.activity.ReceiverTwoActivity;
import com.kiwilss.dagger.activity.XmlActivity;
import com.kiwilss.dagger.basetext.ConstrainlayoutActivity;
import com.kiwilss.dagger.basetext.SearchActivity;
import com.kiwilss.dagger.basetext.ShaLayoutActivity;
import com.kiwilss.dagger.basetext.TextViewActivity;
import com.kiwilss.dagger.basetext.WebviewActivity;
import com.kiwilss.dagger.basetext.flexbox.FlexboxActivity;
import com.kiwilss.dagger.basetext.recycler.RecyclerOneActivity;
import com.kiwilss.dagger.basetext.textview.SuperTextViewActivity;
import com.kiwilss.dagger.basetext.viewpager.RvVpActivity;
import com.kiwilss.dagger.test.DaggerMainComponent;
import com.kiwilss.dagger.test.MainComponent;
import com.kiwilss.dagger.test.MainModule;

public class MainActivity extends AppCompatActivity {

    private TextView mTvOne;

//    @Inject
//    Cloth mCloth;
    //获取红色布料
//    @Inject
//    //@Named("red")
//        @RedCloth
//    Cloth mRedCloth;
//    //获取蓝色布料
//    @Inject
//    @Named("blue")
//    Cloth mBlueCloth;

//    @Inject
//    Shoe mShoe;
//
//    @Inject
//    Clothes mClothes;

//    @Inject
//    Cloth mRedCloth;
//    @Inject
//    ClothHandler mClothHandler;

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
//        mTvOne.setText("我现在有"+mCloth+","+","+mShoe+","+mClothes+"||"
//        +(mCloth==mClothes.getCloth()));

        //mTvOne.setText("红布料加工后变成了"+mClothHandler.handle(mRedCloth)+ "\nclothHandler地址:" + mClothHandler);

    }
    private void initView() {
        mTvOne = (TextView) findViewById(R.id.tv_main_one);
    }
    /**动态注册广播
     * @param view
     */
    public void broadcastOne(View view) {
        startActivity(new Intent(this, BroadcastOneActivity.class));
    }

    /**静态注册,无序
     * @param view
     */
    public void broadcastTwo(View view) {
        startActivity(new Intent(this, ReceiverTwoActivity.class));
    }

    /**本地广播
     * @param view
     */
    public void localReceiver(View view) {
        startActivity(new Intent(this, LocalReceiverActivity.class));
    }

    public void serviceListener(View view) {
        startActivity(new Intent(this, OneServiceActivity.class));
    }

    //绑定开启服务
    public void serviceBindListener(View view) {
        startActivity(new Intent(this, BindServiceActivity.class));
    }

    public void intentserviceBindListener(View view) {
        startActivity(new Intent(this, IntentActivity.class));
    }

    public void xmlListener(View view) {
        startActivity(new Intent(this, XmlActivity.class));
    }

    public void alarmListener(View view) {
        startActivity(new Intent(this, AlarmActivity.class));
    }

    public void contentListener(View view) {
        startActivity(new Intent(this, ContentActivity.class));
    }

    public void searchView(View view) {
        startActivity(new Intent(this, SearchActivity.class));
    }

    public void flexboxListener(View view) {
        startActivity(new Intent(this, FlexboxActivity.class));
    }

    public void layoutanim(View view) {
        startActivity(new Intent(this, LayoutAnimActivity.class));
    }

    public void rvvpListener(View view) {
        startActivity(new Intent(this, RvVpActivity.class));
    }

    public void constrianlayout(View view) {
        startActivity(new Intent(this, ConstrainlayoutActivity.class));
    }

    public void webviewListener(View view) {
        startActivity(new Intent(this, WebviewActivity.class));
    }

    public void textviewListener(View view) {
        startActivity(new Intent(this, TextViewActivity.class));
    }

    public void trvOneListener(View view) {
        startActivity(new Intent(this, RecyclerOneActivity.class));
    }

    public void showLayout(View view) {
        startActivity(new Intent(this, ShaLayoutActivity.class));
    }

    public void supertextview(View view) {
        startActivity(new Intent(this, SuperTextViewActivity.class));
    }
}
