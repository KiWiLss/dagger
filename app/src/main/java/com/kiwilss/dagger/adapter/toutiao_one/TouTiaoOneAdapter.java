package com.kiwilss.dagger.adapter.toutiao_one;

import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kiwilss.dagger.R;

import java.util.List;

/**
 * FileName: TouTiaoOneAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/10
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class TouTiaoOneAdapter extends BaseItemDraggableAdapter<String,BaseViewHolder> {
    public TouTiaoOneAdapter(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        TextView tvText = helper.getView(R.id.tv_item_toutiao_one_title);
        tvText.setText(item);
        View ivDelete = helper.getView(R.id.iv_item_toutiao_one_delete);
        if (isShowIcon){
            //前两个不显示
            int position = helper.getAdapterPosition();
            if (position==0||position==1){
                ivDelete.setVisibility(View.GONE);
            }else {
                ivDelete.setVisibility(View.VISIBLE);
            }
        }else {
            ivDelete.setVisibility(View.GONE);
        }
    }

    private boolean isShowIcon;
    public void showDeleteIcon(boolean isShowIcon){
        this.isShowIcon=isShowIcon;
        notifyDataSetChanged();
    }
}
