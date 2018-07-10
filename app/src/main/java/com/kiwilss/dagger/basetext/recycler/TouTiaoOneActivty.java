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
import com.chad.library.adapter.base.callback.ItemDragAndSwipeCallback;
import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.kiwilss.dagger.R;
import com.kiwilss.dagger.activity.TouTiaoDetailActivity;
import com.kiwilss.dagger.adapter.toutiao_one.TouTiaoOneAdapter;
import com.kiwilss.dagger.adapter.toutiao_one.TouTiaoTwoAdapter;

import java.util.ArrayList;

/**
 * FileName: TouTiaoOneActivty
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/10
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}无法限制前两个保持不动,拖拽依然会动
 */
public class TouTiaoOneActivty extends AppCompatActivity {
    public static final String TAG = "MMM";
    private android.widget.TextView tvtoutiaoonemy;
    private android.widget.TextView tvtoutiaooneedit;
    private android.support.v7.widget.RecyclerView rvtoutioaonemy;
    private android.support.v7.widget.RecyclerView rvtoutioaoneadd;
    private ArrayList<String> mDataOne;

    private ArrayList<String> mDataTwo;
    private TouTiaoOneAdapter mTouTiaoOneAdapter;
    private TouTiaoTwoAdapter mTouTiaoTwoAdapter;

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
                mTouTiaoOneAdapter.showDeleteIcon(false);
                //禁用拖拽
                mTouTiaoOneAdapter.disableDragItem();
            }else {
                //点击变成编辑状态
                tvtoutiaooneedit.setText("完成");
                tvtoutiaoonemy.setText("拖拽可以排序");
                //我的频道右上角图标显示
                mTouTiaoOneAdapter.showDeleteIcon(true);
                // 开启拖拽
                mTouTiaoOneAdapter.enableDragItem(itemTouchHelper);
            }
            isEdit=!isEdit;
        });
    }
    boolean isEdit = false;
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
                Log.e(TAG, "onItemClick: "+position+"||"+title );
                //加入到我的频道
                mDataOne.add(title);
                mTouTiaoOneAdapter.notifyItemInserted(mDataOne.size()-1);

                mDataTwo.remove(position);
                mTouTiaoTwoAdapter.notifyItemRemoved(position);
                //mTouTiaoTwoAdapter.notifyDataSetChanged();
            }
        });
    }
    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos){
            Log.e(TAG, "onItemDragStart: "+pos );


        }
        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source,
                                     int from, RecyclerView.ViewHolder target, int to) {



        }
        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {}
    };

    ItemTouchHelper itemTouchHelper;
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
        mTouTiaoOneAdapter = new TouTiaoOneAdapter(R.layout.item_toutiao_one, mDataOne);
        rvtoutioaonemy.setAdapter(mTouTiaoOneAdapter);

        ItemDragAndSwipeCallback itemDragAndSwipeCallback =
                new ItemDragAndSwipeCallback(mTouTiaoOneAdapter);
         itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(rvtoutioaonemy);
        //长按可以拖动
        mTouTiaoOneAdapter.setOnItemDragListener(onItemDragListener);

        //设置添加,移除动画
        rvtoutioaonemy.setItemAnimator(new DefaultItemAnimator());

        //点击事件监听
        mTouTiaoOneAdapter.setOnItemClickListener(new BaseQuickAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                //处于编辑状态
                if (isEdit){
                    //点击移除,前两个除外
                    if (position>1){
                        //加入频道推荐,//将其移动到第一个位置
                        String title = mDataOne.get(position);
                        Log.e(TAG, "onItem--my--Click: "+position+"||"+title );
                        mDataTwo.add(0,title);
                        mTouTiaoTwoAdapter.notifyItemInserted(0);

                        //mTouTiaoTwoAdapter.notifyDataSetChanged();
                        //我的频道,移除点击的数据
                        mDataOne.remove(position);
                        mTouTiaoOneAdapter.notifyItemRemoved(position);
                        //mTouTiaoOneAdapter.notifyDataSetChanged();
                    }
                }else {
                    //点击进入对应详情页
                    String title = mDataOne.get(position);
                    Intent intent = new Intent(TouTiaoOneActivty.this, TouTiaoDetailActivity.class);
                    intent.putExtra("title",title);
                    startActivity(intent);
                }
            }
        });



      //长按监听
        mTouTiaoOneAdapter.setOnItemLongClickListener(new BaseQuickAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(BaseQuickAdapter adapter, View view, int position) {

                if (position > 1){
                    //长按处于编辑状态
                    isEdit=true;
                    //点击变成编辑状态
                    tvtoutiaooneedit.setText("完成");
                    tvtoutiaoonemy.setText("拖拽可以排序");
                    //我的频道右上角图标显示
                    mTouTiaoOneAdapter.showDeleteIcon(true);
                    // 开启拖拽
                    mTouTiaoOneAdapter.enableDragItem(itemTouchHelper);
                    return true;
                }
                return false;
            }
        });
    }
}
