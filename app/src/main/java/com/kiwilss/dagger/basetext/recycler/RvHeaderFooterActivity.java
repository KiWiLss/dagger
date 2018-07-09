package com.kiwilss.dagger.basetext.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.RvHFAdapter;

import java.util.ArrayList;

/**
 * FileName: RvHeaderFooterActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}加固定数目的头和尾
 */
public class RvHeaderFooterActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvlinearlist;
    private ArrayList<String> mData;
    private RvHFAdapter mRvHFAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        this.rvlinearlist = (RecyclerView) findViewById(R.id.rv_linear_list);
        initData();

        rvlinearlist.setLayoutManager(new LinearLayoutManager(this));

        mRvHFAdapter = new RvHFAdapter(this, mData);
        rvlinearlist.setAdapter(mRvHFAdapter);

    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            mData.add("频道"+i);
        }
    }
}
