package com.kiwilss.dagger.basetext.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.RvOneAdapter;

import java.util.ArrayList;

/**
 * FileName: RecyclerOneActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/20
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RecyclerOneActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvrecycleronelist;
    private android.widget.ImageView iv;
    private ArrayList<String> mData;
    private RvOneAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_one);
        this.iv = (ImageView) findViewById(R.id.iv);
        this.rvrecycleronelist = (RecyclerView) findViewById(R.id.rv_recycler_one_list);

//        ObjectAnimator rotation = ObjectAnimator.ofFloat(iv, "rotation", 0, 180);
//        rotation.setDuration(1000);
//        rotation.start();

        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("data"+i);
        }
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        rvrecycleronelist.setLayoutManager(gridLayoutManager);

        mAdapter = new RvOneAdapter(R.layout.item_rvone, mData);
        rvrecycleronelist.setAdapter(mAdapter);


    }
}
