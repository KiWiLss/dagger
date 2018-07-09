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
public class RvLinearAdapter2 extends  RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String>mData;
    //Type
    private int TYPE_HEADER = 1001;
    public RvLinearAdapter2(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==TYPE_HEADER){
            View headerView = mLayoutInflater.inflate(R.layout.header_rv_linear, parent, false);
            return new HeaderViewHolder(headerView);
        }
        View inflate = mLayoutInflater.inflate(R.layout.item_rv_linear, parent, false);
        return new ViewHolder(inflate);

    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ViewHolder){
            //postion==0被头布局占据
            ((ViewHolder) holder).tvText.setText(mData.get(position-1));
            ((ViewHolder) holder).tvText.setOnClickListener(view ->
                    Toast.makeText(mContext, mData.get(position-1), Toast.LENGTH_SHORT).show() );
        }
    }

    @Override
    public int getItemCount() {
        //加了头布局,多一个
        return mData.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        //在第一个位置添加头
        if (position==0){
            return TYPE_HEADER;
        }
        return super.getItemViewType(position);
    }


    /**
     * 头布局的viewholder
     */
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }


    /**
     * 正常内容的viewholder
     */
    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        public ViewHolder(View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tv_item_rv_linear_text);
        }
    }
}
