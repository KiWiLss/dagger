package com.kiwilss.dagger;

import android.app.Application;
import android.content.res.Configuration;
import android.util.DisplayMetrics;

/**
 * FileName: MyApplication
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/7
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        resetdensity();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        resetdensity();
    }


    /**
     * 重置屏幕密度
     */
    private void resetdensity() {
        //绘制页面时参照的设计图尺寸
        final float DESIGN_WIDTH = 1080f;
        final float DESIGN_HEIGHT = 1920f;
        final float DESTGN_INCH = 5.0f;
        //大屏调节因子，范围0~1，因屏幕同比例放大视图显示非常傻大憨，用于调节感官度
        final float BIG_SCREEN_FACTOR = 0.2f;

        DisplayMetrics dm = getResources().getDisplayMetrics();
        //确定放大缩小比率
        float rate = Math.min(dm.widthPixels, dm.heightPixels) / Math.min(DESIGN_WIDTH, DESIGN_HEIGHT);
        //确定参照屏幕密度
        float referenceDensity = (float) Math.sqrt(DESIGN_WIDTH * DESIGN_WIDTH + DESIGN_HEIGHT * DESIGN_HEIGHT) / DESTGN_INCH / 160;
        //确定最终屏幕密度
        float relativeDensity = referenceDensity * rate;
        if (relativeDensity > dm.density) {
            relativeDensity = relativeDensity - (relativeDensity - dm.density) * BIG_SCREEN_FACTOR;
        }
        dm.density = relativeDensity;
    }


}
