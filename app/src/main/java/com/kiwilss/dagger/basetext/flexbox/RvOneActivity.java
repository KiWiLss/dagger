package com.kiwilss.dagger.basetext.flexbox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kiwilss.dagger.R;

import java.util.Arrays;
import java.util.List;

/**
 * FileName: RvOneActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/5
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION} 瀑布流布局
 */
public class RvOneActivity extends AppCompatActivity {

    private static final Integer []CATS = new Integer[]{
            R.drawable.cat_1,
            R.drawable.cat_2,
            R.drawable.cat_3,
            R.drawable.cat_4,
            R.drawable.cat_5,
            R.drawable.cat_6,
            R.drawable.cat_7,
            R.drawable.cat_8,
            R.drawable.cat_9,
            R.drawable.cat_10,
            R.drawable.cat_11,
            R.drawable.cat_12,
            R.drawable.cat_13,
            R.drawable.cat_14,
            R.drawable.cat_15,
            R.drawable.cat_16,
            R.drawable.cat_17,
            R.drawable.cat_18,
            R.drawable.cat_19,
    } ;
    private RecyclerView rvone;

    List<Integer> data;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvone);
        this.rvone = (RecyclerView) findViewById(R.id.rv_one);


        //new LinearLayoutManager()
        //new GridLayoutManager()

        StaggeredGridLayoutManager staggeredGridLayoutManager =
                new StaggeredGridLayoutManager(4,
                        StaggeredGridLayoutManager.VERTICAL);
        rvone.setLayoutManager(staggeredGridLayoutManager);

         data = Arrays.asList(CATS);

         rvone.setAdapter(new MyAdapter());

    }

    public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{


        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(RvOneActivity.this).inflate(R.layout.item_rvone, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
            holder.ivIcon.setImageResource(data.get(position));
        }

        @Override
        public int getItemCount() {
            return data.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivIcon;
            public ViewHolder(View itemView) {
                super(itemView);
                ivIcon = itemView.findViewById(R.id.iv_item_icon);
            }
        }
    }


}
