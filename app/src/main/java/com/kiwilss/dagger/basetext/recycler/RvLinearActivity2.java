package com.kiwilss.dagger.basetext.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.RvLinearAdapter2;
import com.kiwilss.dagger.utils.rvutils.ListViewHeadDecoration;

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
public class RvLinearActivity2 extends AppCompatActivity {
    private RecyclerView rvlinearlist;
    private ArrayList<String> mData;
    private RvLinearAdapter2 mAdapter;

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
        for (int i = 0; i < 20; i++) {
            mData.add("频道"+i);
        }

        //直接在adapter里面加上了头布局
        mAdapter = new RvLinearAdapter2(this, mData);
        rvlinearlist.setAdapter(mAdapter);

        //自定义分割线,顶部有线
        rvlinearlist.addItemDecoration(new ListViewHeadDecoration
                (this,R.drawable.listview_decoration));
    }
}
