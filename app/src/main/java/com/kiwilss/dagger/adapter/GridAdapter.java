package com.kiwilss.dagger.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.kiwilss.dagger.R;

import java.util.List;

/**
 * FileName: RvLinearAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class GridAdapter extends  RecyclerView.Adapter<GridAdapter.ViewHolder>{

    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String>mData;

    //Type
    private int TYPE_NORMAL = 1000;
    private int TYPE_HEADER = 1001;
    private int TYPE_FOOTER = 1002;


    public GridAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = mLayoutInflater.inflate(R.layout.item_rv_linear, parent, false);
        return new ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvText.setText(mData.get(position));
        //点击监听
        holder.tvText.setOnClickListener(v->{
            Toast.makeText(mContext, mData.get(position), Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        public ViewHolder(View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tv_item_rv_linear_text);
        }
    }
}
