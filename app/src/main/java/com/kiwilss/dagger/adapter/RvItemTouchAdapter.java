package com.kiwilss.dagger.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.utils.rvutils.MyItemTouchHandler;

import java.util.Collections;
import java.util.List;

/**
 * FileName: RvItemTouchAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvItemTouchAdapter extends MyItemTouchHandler.ItemTouchAdapterImpl {

    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String>mData;

    public RvItemTouchAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {
        //移动时交换位置
        Collections.swap(mData,fromPosition,toPosition);
    }

    @Override
    public void onItemRemove(int position) {
        //移除监听
        mData.remove(position);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_rv_linear2, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tvTv.setText(mData.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTv;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTv=itemView.findViewById(R.id.tv_item_rv_linear_text);
        }
    }
}
