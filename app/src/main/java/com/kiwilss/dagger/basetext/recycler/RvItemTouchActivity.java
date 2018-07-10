package com.kiwilss.dagger.basetext.recycler;

import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;

import com.chad.library.adapter.base.listener.OnItemDragListener;
import com.chad.library.adapter.base.listener.OnItemSwipeListener;
import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.RvItemTouchAdapter;
import com.kiwilss.dagger.utils.rvutils.MyItemTouchHandler;

import java.util.ArrayList;

/**
 * FileName: RvItemTouchActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvItemTouchActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvlinearlist;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        this.rvlinearlist = (RecyclerView) findViewById(R.id.rv_linear_list);
        initData();
        initAdapter();

    }

    private void initAdapter() {

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 4);
        //线性布局拖拽
        //rvlinearlist.setLayoutManager(new LinearLayoutManager(this));
        rvlinearlist.setLayoutManager(gridLayoutManager);

        //自定义类实现拖拽,侧滑删除
        RvItemTouchAdapter adapter = new RvItemTouchAdapter(this, mData);

        MyItemTouchHandler myItemTouchHandler = new MyItemTouchHandler(adapter);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new MyItemTouchHandler(adapter));
        itemTouchHelper.attachToRecyclerView(rvlinearlist);

        rvlinearlist.setAdapter(adapter);



       /* //库实现
        RvItemTouchAdapter2 adapter2 = new RvItemTouchAdapter2(R.layout.item_rv_linear2, mData);
        rvlinearlist.setAdapter(adapter2);

        ItemDragAndSwipeCallback itemDragAndSwipeCallback = new ItemDragAndSwipeCallback(adapter2);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemDragAndSwipeCallback);
        itemTouchHelper.attachToRecyclerView(rvlinearlist);

// 开启拖拽
        adapter2.enableDragItem(itemTouchHelper);
        adapter2.setOnItemDragListener(onItemDragListener);

// 开启滑动删除
        adapter2.enableSwipeItem();
        adapter2.setOnItemSwipeListener(onItemSwipeListener);
*/


    }
    OnItemDragListener onItemDragListener = new OnItemDragListener() {
        @Override
        public void onItemDragStart(RecyclerView.ViewHolder viewHolder, int pos){}
        @Override
        public void onItemDragMoving(RecyclerView.ViewHolder source, int from, RecyclerView.ViewHolder target, int to) {

            //移动位置互换
            //Collections.swap(mData,from,to);

        }
        @Override
        public void onItemDragEnd(RecyclerView.ViewHolder viewHolder, int pos) {}
    };

    OnItemSwipeListener onItemSwipeListener = new OnItemSwipeListener() {
        @Override
        public void onItemSwipeStart(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.e("MMM", "onItemSwipeStart: "+pos );
        }
        @Override
        public void clearView(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.e("MMM", "clearView: "+pos);
        }
        @Override
        public void onItemSwiped(RecyclerView.ViewHolder viewHolder, int pos) {
            Log.e("MMM", "onItemSwiped: "+pos);
        }

        @Override
        public void onItemSwipeMoving(Canvas canvas, RecyclerView.ViewHolder viewHolder, float dX, float dY, boolean isCurrentlyActive) {
            //正在滑动监听

        }
    };



    private void initData() {
        mData = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            mData.add("频道"+i);
        }
    }
}
