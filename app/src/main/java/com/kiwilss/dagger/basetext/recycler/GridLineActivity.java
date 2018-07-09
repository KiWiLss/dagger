package com.kiwilss.dagger.basetext.recycler;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.GridAdapter;
import com.kiwilss.dagger.utils.rvutils.ItemDivider;

import java.util.ArrayList;

/**
 * FileName: GridLineActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}网格布局添加分割线
 */
public class GridLineActivity extends AppCompatActivity {
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
//使用添加头和尾的适配器
        mGridAdapter = new GridAdapter(this, mData);
        rvlinearlist.setAdapter(mGridAdapter);
        //添加分割线
        //rvlinearlist.addItemDecoration(new Divider2(this));
        //添加分割线

        ItemDivider itemDivider = new ItemDivider();
        itemDivider.setDividerColor(Color.YELLOW).setDividerWith(5);
        rvlinearlist.addItemDecoration(itemDivider);
    }

    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("频道"+i);
        }
    }
}
