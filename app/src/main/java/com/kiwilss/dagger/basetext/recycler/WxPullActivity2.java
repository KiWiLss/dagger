package com.kiwilss.dagger.basetext.recycler;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.RvLinearAdapter;
import com.kiwilss.dagger.wxpull.ExtendListFooter;
import com.kiwilss.dagger.wxpull.ExtendListHeader;
import com.kiwilss.dagger.wxpull.PullExtendLayout;
import com.kiwilss.dagger.wxpull.adapter.WxPullAdapter;

import java.util.ArrayList;

/**
 * FileName: WxPullActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/11
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class WxPullActivity2 extends AppCompatActivity {


    private com.kiwilss.dagger.wxpull.ExtendListHeader extendheader;

    private com.kiwilss.dagger.wxpull.ExtendListFooter extendfooter;
    private com.kiwilss.dagger.wxpull.PullExtendLayout pullextend;
    private ArrayList<String> mData;
    private WxPullAdapter mWxPullAdapter;
    private RecyclerView rvwxpulllist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wx_pull2);
        this.rvwxpulllist = (RecyclerView) findViewById(R.id.rv_wx_pull_list);
        //获取控件
        this.pullextend = (PullExtendLayout) findViewById(R.id.pull_extend);
        this.extendfooter = (ExtendListFooter) findViewById(R.id.extend_footer);
        this.extendheader = (ExtendListHeader) findViewById(R.id.extend_header);

        //获取隐藏头部分的recyclerview
        RecyclerView rvHeader = extendheader.getRecyclerView();
        //获取隐藏底部的recyclerview
        RecyclerView rvFooter = extendfooter.getRecyclerView();

        //随便加几个数据
        mData = new ArrayList<>();
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");
        mData.add("英文");

        LinearLayoutManager llmHeader = new LinearLayoutManager(this);
        llmHeader.setOrientation(LinearLayoutManager.HORIZONTAL);
        LinearLayoutManager llmFooter = new LinearLayoutManager(this);
        llmFooter.setOrientation(LinearLayoutManager.HORIZONTAL);

        rvHeader.setLayoutManager(llmHeader);
        rvFooter.setLayoutManager(llmFooter);

        mWxPullAdapter = new WxPullAdapter(R.layout.item_wx_pull, mData);

        rvHeader.setAdapter(mWxPullAdapter);
        rvFooter.setAdapter(mWxPullAdapter);

        //内容的列表
        rvwxpulllist.setLayoutManager(new LinearLayoutManager(this));
        RvLinearAdapter mAdapter = new RvLinearAdapter(this, mData);
        rvwxpulllist.setAdapter(mAdapter);

    }


}
