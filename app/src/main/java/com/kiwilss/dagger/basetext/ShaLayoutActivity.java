package com.kiwilss.dagger.basetext;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.widget.TextView;

import com.kiwilss.dagger.R;

import cn.davidsu.library.ShadowConfig;
import cn.davidsu.library.ShadowHelper;

/**
 * FileName: ShaLayoutActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/3
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class ShaLayoutActivity extends AppCompatActivity {
    private android.widget.TextView tvshalowobject;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shalout);
        this.tvshalowobject = (TextView) findViewById(R.id.tv_shalow_object);


        int mColor[]={Color.parseColor("#ffa726")};
        ShadowConfig.Builder config = new ShadowConfig.Builder()
                .setColor(mColor[0])//View颜色
                .setShadowColor(mColor[0])//阴影颜色
                .setGradientColorArray(mColor)//如果View是渐变色，则设置color数组
                .setRadius(dp2px(this,20))//圆角
                .setOffsetX(dp2px(this,1))//横向偏移
                .setOffsetY(dp2px(this,1));//纵向偏移
        ShadowHelper.setShadowBgForView(tvshalowobject, config);
    }



    public int dp2px(Context context, float dpValue) {
        return (int) getRawSize(context, 1, dpValue);
    }

    public float getRawSize(Context context, int unit, float size) {
        return TypedValue.applyDimension(unit, size, context.getResources().getDisplayMetrics());
    }
}
