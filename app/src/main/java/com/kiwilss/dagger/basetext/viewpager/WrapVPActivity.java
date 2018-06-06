package com.kiwilss.dagger.basetext.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;

import com.kiwilss.dagger.R;

/**
 * FileName: WrapVPActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class WrapVPActivity extends AppCompatActivity {
    private android.widget.LinearLayout rightlayout;

    public static final String content[] = new String []{"First","Second","Third","Four"};
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wrap_vp);
        this.rightlayout = (LinearLayout) findViewById(R.id.right_layout);






    }
}
