package com.kiwilss.dagger.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.kiwilss.dagger.utils.rvutils.StickyRecyclerView;

import java.util.List;

/**
 * FileName: RvStickyAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvStickyAdapter extends StickyRecyclerView.StickyAdapter {

    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String>mData;

    public RvStickyAdapter(Context context, List<String> data) {
        mContext = context;
        mData = data;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public String getItemViewTitle(int position) {
        return "随意设置的标题";
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
