package com.kiwilss.dagger.basetext.recycler;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.RvLinearAdapter;
import com.kiwilss.dagger.utils.rvutils.ItemDivider;

import java.util.ArrayList;

/**
 * FileName: RvLinearActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvLinearActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvlinearlist;
    private ArrayList<String> mData;
    private RvLinearAdapter mAdapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        this.rvlinearlist = (RecyclerView) findViewById(R.id.rv_linear_list);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        //设置方向,默认方向(垂直)
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvlinearlist.setLayoutManager(linearLayoutManager);

        mData = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            mData.add("频道"+i);
        }
        mAdapter = new RvLinearAdapter(this, mData);
        rvlinearlist.setAdapter(mAdapter);

        //添加下划线
        //默认类型的分割线
//        rvlinearlist.addItemDecoration(new DividerItemDecoration
//                (this, LinearLayoutManager.VERTICAL));
        //自定义分割线,顶部有线
//        rvlinearlist.addItemDecoration(new ListViewHeadDecoration
//                (this,R.drawable.listview_decoration));
        //顶部无线
//        rvlinearlist.addItemDecoration(new ListViewDecoration
//                (this,R.drawable.listview_decoration));

        //添加分割线
        ItemDivider itemDivider = new ItemDivider();
        itemDivider.setDividerColor(Color.YELLOW).setDividerWith(5);
        rvlinearlist.addItemDecoration(itemDivider);



    }
}
