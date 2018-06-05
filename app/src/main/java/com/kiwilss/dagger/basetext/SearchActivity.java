package com.kiwilss.dagger.basetext;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.kiwilss.dagger.R;

/**
 * FileName: SearchActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/5
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class SearchActivity extends AppCompatActivity {
    public static final String TAG = "MMM";
    private android.widget.LinearLayout llsearchll;
    //private com.miguelcatalan.materialsearchview.MaterialSearchView searchview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.llsearchll = (LinearLayout) findViewById(R.id.ll_search_ll);


        for (int i = 0; i < 5; i++) {
            View view = LayoutInflater.from(this).inflate(R.layout.item_search, null);
            llsearchll.addView(view);
        }

    }
}
