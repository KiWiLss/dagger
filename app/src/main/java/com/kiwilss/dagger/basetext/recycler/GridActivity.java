package com.kiwilss.dagger.basetext.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.GridAdapter;
import com.kiwilss.dagger.adapter.RvHFAdapter;

import java.util.ArrayList;

/**
 * FileName: GridActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class GridActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvlinearlist;
    private ArrayList<String> mData;
    private GridAdapter mGridAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        this.rvlinearlist = (RecyclerView) findViewById(R.id.rv_linear_list);

        initData();

        initAdapter();

    }

    private void initAdapter() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        rvlinearlist.setLayoutManager(gridLayoutManager);

        mGridAdapter = new GridAdapter(this, mData);
        //rvlinearlist.setAdapter(mGridAdapter);
        //使用添加头和尾的适配器
        RvHFAdapter rvHFAdapter = new RvHFAdapter(this, mData);
        rvlinearlist.setAdapter(rvHFAdapter);

        //处理头和尾布局,使其占据一行
        gridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                //判断是否是头或者尾布局
                if (position==0||position==mData.size()+1){
                    return gridLayoutManager.getSpanCount();
                }
                return 1;
            }
        });

        //添加分割线
        //rvlinearlist.addItemDecoration(new Divider2(this));
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("频道"+i);
        }
    }
}
