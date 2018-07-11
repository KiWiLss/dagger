package com.kiwilss.dagger;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kiwilss.dagger.activity.AlarmActivity;
import com.kiwilss.dagger.activity.BindServiceActivity;
import com.kiwilss.dagger.activity.BroadcastOneActivity;
import com.kiwilss.dagger.activity.ContentActivity;
import com.kiwilss.dagger.activity.IntentActivity;
import com.kiwilss.dagger.activity.LayoutAnimActivity;
import com.kiwilss.dagger.activity.LocalReceiverActivity;
import com.kiwilss.dagger.activity.LottieActivity;
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
import com.kiwilss.dagger.basetext.recycler.RvTestActivity;
import com.kiwilss.dagger.basetext.textview.SuperTextViewActivity;
import com.kiwilss.dagger.basetext.viewpager.RvVpActivity;
import com.kiwilss.dagger.dialog.DialogFragmentTestActivity;
import com.kiwilss.dagger.dialog.WxIconActivity;
import com.kiwilss.dagger.fragment.ActResultRequest;
import com.kiwilss.dagger.model.ManualBean;
import com.kiwilss.dagger.test.DaggerMainComponent;
import com.kiwilss.dagger.test.MainComponent;
import com.kiwilss.dagger.test.MainModule;


// 在支持路由的页面上添加注解(必选)
// 这里的路径需要注意的是至少需要有两级，/xx/xx
// 路径标签个人建议写在一个类里面 这样方便统一管理和维护
@Route(path = Constance.ACTIVITY_URL_MAIN)
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


        ARouter.getInstance().inject(this);
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

    /**对recyclerview使用练习
     * @param view
     */
    public void rvUse(View view) {
        startActivity(new Intent(this, RvTestActivity.class));
    }

    public void lottlieListener(View view) {

        Intent intent = new Intent(this, LottieActivity.class);

        ActResultRequest request = new ActResultRequest(this);
        request.startForResult(intent, new ActResultRequest.Callback() {
            @Override
            public void onActivityResult(int resultCode, Intent data) {
                Toast.makeText(MainActivity.this, "" + resultCode, Toast.LENGTH_SHORT).show();
            }
        });
        //startActivity(new Intent(this, LottieActivity.class));
    }

    /**路由测试  /**
     * Activity 跳转 (普通跳转)
     * @param view
     */
    public void arouterListener(View view) {
        ARouter.getInstance().build( Constance.ACTIVITY_URL_ONE).
                navigation();

    }

    /**携带参数跳转
     * @param view
     */
    public void arouterParamsListener(View view) {
        ARouter.getInstance().
                build(Constance.ACTIVITY_URL_SECOND).
                withString("key", "android").
                withInt("age", 3).
                withParcelable("test", new ManualBean("tzw", 26)).
                navigation(MainActivity.this,123);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e("MMM", "onActivityResult: " +requestCode+"||"+resultCode);
    }

    public void arouterURiListener(View view) {
        Uri uri = Uri.parse(Constance.ACTIVITY_URL_ONE2);
        ARouter.getInstance().build(uri)
                .navigation();
    }

    public void dialogListener(View view) {
        startActivity(new Intent(this, DialogFragmentTestActivity.class));
    }

    public void wxiconCheckListener(View view) {
        startActivity(new Intent(this, WxIconActivity.class));
    }
}
