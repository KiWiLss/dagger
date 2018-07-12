package com.kiwilss.dagger.basetext.scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kiwilss.dagger.R;

import java.util.ArrayList;

/**
 * FileName: RecyclerHorizontalActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/12
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RecyclerHorizontalActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvrecyclerhorizontallist;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycelr_horizontal);
        this.rvrecyclerhorizontallist = (RecyclerView) findViewById(R.id.rv_recycler_horizontal_list);

        initData();

        initAdapter();

    }

    private void initAdapter() {
        RvHorizontalAdapter rvHorizontalAdapter = new RvHorizontalAdapter(R.layout.item_wx_pull2, mData);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rvrecyclerhorizontallist.setLayoutManager(linearLayoutManager);
        rvrecyclerhorizontallist.setAdapter(rvHorizontalAdapter);

        rvHorizontalAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();
                int lastVisibleItemPosition = linearLayoutManager.findLastVisibleItemPosition();

                int left = rvrecyclerhorizontallist.getChildAt(position - firstVisibleItemPosition).getLeft();
                int right = rvrecyclerhorizontallist.getChildAt(lastVisibleItemPosition - position).getLeft();

                rvrecyclerhorizontallist.scrollBy((left - right)/2,0);

                Toast.makeText(RecyclerHorizontalActivity.this, ""+position, Toast.LENGTH_SHORT).show();
            }
        });
    }



    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 40; i++) {
            mData.add("英文"+i);
        }
    }
}
