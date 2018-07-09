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
 * FileName: RvHFAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/6
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvHFAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {


    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String>mData;

    private final static int ITEM_HEADER=0;
    private final static int ITEM_CONTENT=1;
    private final static int ITEM_FOOT=2;

    /**
     * 头布局和尾布局的数量
     */
    private int mHeader=1;
    private int mFoot=1;

    public RvHFAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType==ITEM_CONTENT){
            View view = mLayoutInflater.inflate(R.layout.item_rv_linear, parent, false);
            return new ViewHolder(view);
        }
        if (viewType==ITEM_HEADER){
            View view = mLayoutInflater.inflate(R.layout.header_rv_linear, parent, false);
            return new HeaderViewHolder(view);
        }
        if (viewType==ITEM_FOOT){
            View view = mLayoutInflater.inflate(R.layout.footer_rv_linear, parent, false);
            return new FooterViewHolder(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        //Log.e("MMM", "onBindViewHolder: "+position);

        if (holder instanceof ViewHolder){
            ((ViewHolder) holder).tvText.setText(mData.get(position-mHeader));
            ((ViewHolder) holder).tvText.setOnClickListener(view ->
                    Toast.makeText(mContext, mData.get(position-mHeader), Toast.LENGTH_SHORT).show());
        }
    }

    @Override
    public int getItemCount() {
        //固定数目,一个头,一个尾
        return mData.size()+mHeader+mFoot;
    }


    @Override
    public int getItemViewType(int position) {
        if (mHeader!=0&&position<mHeader){
            return ITEM_HEADER;
        }
        if (mFoot!=0&&position>=mData.size()+mHeader){
            return ITEM_FOOT;
        }
        return ITEM_CONTENT;
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvText;
        public ViewHolder(View itemView) {
            super(itemView);
            tvText=itemView.findViewById(R.id.tv_item_rv_linear_text);
        }
    }
    class HeaderViewHolder extends RecyclerView.ViewHolder {
        public HeaderViewHolder(View itemView) {
            super(itemView);
        }
    }
    class FooterViewHolder extends RecyclerView.ViewHolder {
        public FooterViewHolder(View itemView) {
            super(itemView);
        }
    }
}
