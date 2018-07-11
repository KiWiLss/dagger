package com.kiwilss.dagger.basetext.recycler;

import android.app.Service;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.RelativeLayout;
import android.widget.ScrollView;

import com.kiwilss.dagger.R;

/**
 * FileName: WxPullActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/11
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class WxPullActivity extends AppCompatActivity {
    private float scale;
    ScrollView scrollView;
    RelativeLayout rel_top, rel_dot, rel_menu;
    View dot_1, dot_2, dot_3;

    float firstY, lastY;
    int height;
    boolean isPullDown = false;//是否是向下滑动 true 是
    boolean isAnimation = false;//动画是否已开启过 true 是
    final int HEIGHT=180;//菜单布局正常高度
    final int HEIGHT_DOT=120;//三个小球布局正常高度



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_pull);


        scale = this.getResources().getDisplayMetrics().density;
        scrollView = findViewById(R.id.scrollView);
        rel_top = findViewById(R.id.rel_top);
        rel_menu = findViewById(R.id.rel_menu);
        rel_dot = findViewById(R.id.rel_dot);
        dot_1 = findViewById(R.id.dot_1);
        dot_2 = findViewById(R.id.dot_2);
        dot_3 = findViewById(R.id.dot_3);
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                firstY = event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                lastY = event.getY();
                height = (int) ((Math.abs(lastY - firstY) / 5) * scale + 0.5f);//根据不同手机分辨率设置高度

                if (lastY - firstY > 0 && (Math.abs(lastY - firstY) > 25) && rel_top.getHeight() != HEIGHT && scrollView.getScrollY() == 0) {//向下滑动 (ScrollView滑动在顶部)
                    isPullDown = true;
                    setHeight(height);
                    if (height < HEIGHT_DOT) {//小球移动动画
                        //向左
                        setAnimation(0.0f,-3.0f,0.0f,0.0f,1000,dot_1);
                        //向右
                        setAnimation(0.0f,3.0f,0.0f,0.0f,1000,dot_3);
                    }else if (height >= HEIGHT_DOT) {
                        //3个小球向下消失动画
                        setAnimation(0.0f,0.0f,0.0f,1.5f,1500,rel_dot);
                        if (height >= 125 && height < 135) {
                            //震动
                            Vibrator vib = (Vibrator) getSystemService(Service.VIBRATOR_SERVICE);
                            vib.vibrate(60);

                            //菜单出现动画
                            setAnimation(0.0f,0.0f,-1.0f,0.0f,2000,rel_menu);
                            rel_menu.setVisibility(View.VISIBLE);
                        }
                    }
                    return true;
                } else if (lastY - firstY < 0 && rel_top.getHeight() > 0 && height <= HEIGHT) {//向上滑动
                    isPullDown = false;
                    setHeight(HEIGHT - height);
                    //菜单消失动画，只执行一次
                    if (!isAnimation) {
                        isAnimation = true;
                        setAnimation(0.0f,0.0f,0.0f,-1.0f,1000,rel_menu);
                        rel_menu.setVisibility(View.GONE);
                    }
                    return true;
                }
                break;
            case MotionEvent.ACTION_UP:
                isAnimation = false;//状态重置
                if (isPullDown) {
                    if (height < HEIGHT) {//向下滑动距离较小，直接消失
                        isPullDown = false;
                        rel_menu.setVisibility(View.GONE);//隐藏
                        setHeight(0);
                    } else if (height >= HEIGHT) {//向下滑动距离较大，直接固定高度
                        setHeight(HEIGHT);
                    }
                } else if (rel_top.getHeight() > 0) {//向上滑动，并且菜单已调出，直接隐藏菜单
                    setHeight(0);
                    rel_menu.setVisibility(View.GONE);
                }
                break;

        }
        return super.dispatchTouchEvent(event);
    }
    /**
     * 位移动画
     * @param fromX 初始X位置
     * @param toX   结束X位置
     * @param fromY 初始Y位置
     * @param toY   结束Y位置
     * @param time  动画时间
     * @param view  控件
     */
    private void setAnimation(float fromX,float toX,float fromY,float toY,long time,View view){
        TranslateAnimation translate = new TranslateAnimation(
                Animation.RELATIVE_TO_SELF, fromX,
                Animation.RELATIVE_TO_SELF, toX,
                Animation.RELATIVE_TO_SELF, fromY,
                Animation.RELATIVE_TO_SELF, toY);
        translate.setDuration(time);
        translate.setFillAfter(true);//true 设置动画结束后，控件位置保持不动，false 则是返回初始位置
        view.startAnimation(translate);
    }

    /**
     * 设置高度
     * @param height
     */
    private void setHeight(int height){
        RelativeLayout.LayoutParams lineParams = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        rel_top.setLayoutParams(lineParams);
    }

}
