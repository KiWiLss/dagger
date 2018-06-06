package com.kiwilss.dagger.basetext.flexbox;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.google.android.flexbox.AlignItems;
import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexWrap;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.kiwilss.dagger.R;

import java.util.Arrays;
import java.util.List;

/**
 * FileName: RvTwoActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvTwoActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvtwo;
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
    private List<Integer> mAsList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rvtwo);
        this.rvtwo = (RecyclerView) findViewById(R.id.rv_two);

        FlexboxLayoutManager manager = new FlexboxLayoutManager(this);
        //设置主轴排列方式
        manager.setFlexDirection(FlexDirection.ROW);
        //设置是否换行
        manager.setFlexWrap(FlexWrap.WRAP);
        manager.setAlignItems(AlignItems.STRETCH);

        rvtwo.setLayoutManager(manager);
        mAsList = Arrays.asList(CATS);

        rvtwo.setAdapter(new MyAdapter());

    }

    class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{
        @NonNull
        @Override
        public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(RvTwoActivity.this).inflate(R.layout.image_layout, parent, false);
            return new ViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

            holder.ivIcon .setImageResource(mAsList.get(position));

            ViewGroup.LayoutParams lp = holder.ivIcon.getLayoutParams();
            if (lp instanceof FlexboxLayoutManager.LayoutParams) {
                FlexboxLayoutManager.LayoutParams flexboxLp =
                        (FlexboxLayoutManager.LayoutParams) holder.ivIcon.getLayoutParams();
                flexboxLp.setFlexGrow(1.0f);
            }

        }

        @Override
        public int getItemCount() {
            return mAsList.size();
        }

        class ViewHolder extends RecyclerView.ViewHolder {
            ImageView ivIcon;
            public ViewHolder(View itemView) {
                super(itemView);
                ivIcon = itemView.findViewById(R.id.image_src);
            }
        }
    }
}
