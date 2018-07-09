package com.kiwilss.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.airbnb.lottie.LottieAnimationView;
import com.kiwilss.dagger.R;

/**
 * FileName: LottieActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class LottieActivity extends AppCompatActivity {
    private com.airbnb.lottie.LottieAnimationView lav;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lottie);
        this.lav = (LottieAnimationView) findViewById(R.id.lav);

        lav.setAnimation("kodio_logo_reveal.json");
        //lav.loop(true);//过时的方法,可用下面的方法代替,无限循环
        lav.setRepeatCount(-1);

//        lav.pauseAnimation();
//        lav.resumeAnimation();
//        lav.

        lav.playAnimation();
    }

    /**更换动画
     * @param view
     */
    public void changeAnim(View view) {

        //lav.resumeAnimation();//重置动画
        lav.cancelAnimation();//取消动画

        lav.setAnimation("plane.json");

        lav.playAnimation();
    }
}
