package com.kiwilss.dagger.basetext.recycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.kiwilss.dagger.R;
import com.kiwilss.dagger.activity.TouTiaoDetailActivity;
import com.kiwilss.dagger.adapter.toutiao_one.TouTiaoTwoAdapter;
import com.kiwilss.dagger.adapter.toutiao_two.TouTiaoTwoMyAdapter;
import com.kiwilss.dagger.utils.rvutils.MyItemTouchHandler;

import java.util.ArrayList;

/**
 * FileName: TouTiaoTwoActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/10
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class TouTiaoTwoActivity extends AppCompatActivity {
    private android.widget.TextView tvtoutiaoonemy;
    private android.widget.TextView tvtoutiaooneedit;
    private android.support.v7.widget.RecyclerView rvtoutioaonemy;
    private android.support.v7.widget.RecyclerView rvtoutioaoneadd;
    private ArrayList<String> mDataOne;
    private ArrayList<String> mDataTwo;
    private TouTiaoTwoMyAdapter mTouTiaoTwoMyAdapter;
    private TouTiaoTwoAdapter mTouTiaoTwoAdapter;

    boolean isEdit = false;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toutioa_one);
        this.rvtoutioaoneadd = (RecyclerView) findViewById(R.id.rv_toutioa_one_add);
        this.rvtoutioaonemy = (RecyclerView) findViewById(R.id.rv_toutioa_one_my);
        this.tvtoutiaooneedit = (TextView) findViewById(R.id.tv_toutiao_one_edit);
        this.tvtoutiaoonemy = (TextView) findViewById(R.id.tv_toutiao_one_my);

        //初始化第一个列表
        initOneList();
        //初始化第二个列表
        initTwoList();

        //编辑点击
        tvtoutiaooneedit.setOnClickListener(view -> {
            if(isEdit){
                //处于编辑状态,点击变成正常状态
                tvtoutiaooneedit.setText("编辑");
                tvtoutiaoonemy.setText("点击进入频道");
                //我的频道右上角图标隐藏
                mTouTiaoTwoMyAdapter.showDeleteIcon(false);
                //禁用拖拽
                //mTouTiaoOneAdapter.disableDragItem();
            }else {
                //点击变成编辑状态
                tvtoutiaooneedit.setText("完成");
                tvtoutiaoonemy.setText("拖拽可以排序");
                //我的频道右上角图标显示
                mTouTiaoTwoMyAdapter.showDeleteIcon(true);
                // 开启拖拽
                //mTouTiaoOneAdapter.enableDragItem(itemTouchHelper);
            }
            isEdit=!isEdit;
        });

    }
    private void initTwoList() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mDataTwo = new ArrayList<>();
        mDataTwo.add("本地");
        mDataTwo.add("房产");
        mDataTwo.add("直播");
        mDataTwo.add("时尚");
        mDataTwo.add("小说");
        mDataTwo.add("历史");
        mDataTwo.add("育儿");
        mDataTwo.add("搞笑");
        mDataTwo.add("美食");
        mDataTwo.add("养生");
        mDataTwo.add("电影");
        mDataTwo.add("手机");
        mDataTwo.add("旅游");
        rvtoutioaoneadd.setLayoutManager(gridLayoutManager);

        mTouTiaoTwoAdapter = new TouTiaoTwoAdapter(R.layout.item_toutiao_two, mDataTwo);
        rvtoutioaoneadd.setAdapter(mTouTiaoTwoAdapter);
        //设置添加,移除动画
        rvtoutioaoneadd.setItemAnimator(new DefaultItemAnimator());
        mTouTiaoTwoAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {

                String title = mDataTwo.get(position);
                Log.e("MMM", "onItemClick: "+position+"||"+title );
                //加入到我的频道
                mDataOne.add(title);
                mTouTiaoTwoMyAdapter.notifyItemChanged(mDataOne.size()-1);
                //mTouTiaoTwoAdapter.notifyItemInserted(mDataOne.size()-1);
//
                mDataTwo.remove(position);
                mTouTiaoTwoAdapter.notifyItemRemoved(position);
                //mTouTiaoTwoAdapter.notifyDataSetChanged();
            }
        });
    }
    private void initOneList() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        mDataOne = new ArrayList<>();
        mDataOne.add("关注");
        mDataOne.add("推荐");
        mDataOne.add("热点");
        mDataOne.add("世界杯");
        mDataOne.add("军事");
        mDataOne.add("国际");
        mDataOne.add("问答");
        mDataOne.add("视频");
        mDataOne.add("图片");
        mDataOne.add("娱乐");
        mDataOne.add("科技");
        mDataOne.add("国风");
        mDataOne.add("地理");
        mDataOne.add("地球仪");
        rvtoutioaonemy.setLayoutManager(gridLayoutManager);

        mTouTiaoTwoMyAdapter = new TouTiaoTwoMyAdapter(this, mDataOne, new TouTiaoTwoMyAdapter.AdapterCallBack() {
            @Override
            public void onItemClickListener(TouTiaoTwoMyAdapter.ViewHolder viewHolder, int pos) {
                //点击监听
                //处于编辑状态
                if (isEdit){
                    //点击移除,前两个除外
                    if (pos>1){
                        //加入频道推荐,//将其移动到第一个位置
                        String title = mDataOne.get(pos);
                        //Log.e(TAG, "onItem--my--Click: "+position+"||"+title );
                        mDataTwo.add(0,title);
                        mTouTiaoTwoAdapter.notifyItemInserted(0);
                        //mTouTiaoTwoAdapter.notifyDataSetChanged();
                        //我的频道,移除点击的数据
                        mDataOne.remove(pos);
                        mTouTiaoTwoMyAdapter.notifyItemRemoved(pos);
                        //刷新数据
                        mTouTiaoTwoMyAdapter.notifyItemChanged(pos,mDataOne.size()-pos);
                        //mTouTiaoOneAdapter.notifyDataSetChanged();
                    }
                }else {
                    //点击进入对应详情页
                    String title = mDataOne.get(pos);
                    Intent intent = new Intent(TouTiaoTwoActivity.this, TouTiaoDetailActivity.class);
                    intent.putExtra("title",title);
                    startActivity(intent);
                }
            }

            @Override
            public boolean onItemLongClickListener(TouTiaoTwoMyAdapter.ViewHolder viewHolder, int pos) {
                if (isEdit){
                    return false;
                }
                if (pos > 1){
                    //长按处于编辑状态
                    isEdit=true;
                    //点击变成编辑状态
                    tvtoutiaooneedit.setText("完成");
                    tvtoutiaoonemy.setText("拖拽可以排序");
                    //我的频道右上角图标显示
                    mTouTiaoTwoMyAdapter.showDeleteIcon(true);
                    return true;
                }
                return false;
            }
        });

        //自定义类实现拖拽,侧滑删除
        MyItemTouchHandler myItemTouchHandler = new MyItemTouchHandler(mTouTiaoTwoMyAdapter);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new MyItemTouchHandler(mTouTiaoTwoMyAdapter));
        itemTouchHelper.attachToRecyclerView(rvtoutioaonemy);

        rvtoutioaonemy.setAdapter(mTouTiaoTwoMyAdapter);
        //设置添加,移除动画
        rvtoutioaonemy.setItemAnimator(new DefaultItemAnimator());
    }
}
