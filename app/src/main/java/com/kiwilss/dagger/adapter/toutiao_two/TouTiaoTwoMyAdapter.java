package com.kiwilss.dagger.adapter.toutiao_two;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.utils.rvutils.MyItemTouchHandler;

import java.util.List;

/**
 * FileName: TouTiaoTwoMyAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/10
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class TouTiaoTwoMyAdapter extends MyItemTouchHandler.ItemTouchAdapterImpl {


    private final LayoutInflater mLayoutInflater;
    private Context mContext;
    private List<String>mData;
    AdapterCallBack mAdapterCallBack;

    public TouTiaoTwoMyAdapter(Context context, List<String> data,AdapterCallBack adapterCallBack) {
        mContext = context;
        mData = data;
        this.mAdapterCallBack=adapterCallBack;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public void onItemMove(int fromPosition, int toPosition) {

    }

    /**禁止自动拖拽
     * @return
     */
//    @Override
//    protected boolean autoOpenDrag() {
//        return false;
//    }



    /**禁止滑动删除
     * @return
     */
    @Override
    protected boolean autoOpenSwipe() {
        return false;
    }

    @Override
    public void onItemRemove(int position) {

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_toutiao_one, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder,
                                 @SuppressLint("RecyclerView") int position) {
        if (holder instanceof ViewHolder) {
            ((ViewHolder) holder).tvTitle.setText(mData.get(position));

                if (isDelete){
                    if (position > 1) {
                        ((ViewHolder) holder).ivDelete.setVisibility(View.VISIBLE);
                    }
                }else {
                    ((ViewHolder) holder).ivDelete.setVisibility(View.GONE);
                }

            holder.itemView.setOnClickListener(view -> {
                //点击监听
                mAdapterCallBack.onItemClickListener((ViewHolder) holder,position);
            });

//            //长按点击监听
            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mAdapterCallBack.onItemLongClickListener((ViewHolder) holder,position);
                    return false;
                }
            });

        }
    }
    private boolean isDelete;
    public void showDeleteIcon(boolean isDelete){
        this.isDelete = isDelete;
        notifyDataSetChanged();
    }

    public interface AdapterCallBack{
        void onItemClickListener(ViewHolder viewHolder,int pos);
        boolean onItemLongClickListener(ViewHolder viewHolder,int pos);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView ivDelete;
        public ViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tv_item_toutiao_one_title);
            ivDelete = itemView.findViewById(R.id.iv_item_toutiao_one_delete);
        }
    }
}
