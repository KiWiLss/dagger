package com.kiwilss.dagger.wxpull.adapter;

import android.support.annotation.Nullable;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kiwilss.dagger.R;

import java.util.List;

/**
 * FileName: WxPullAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/11
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class WxPullAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public WxPullAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_wx_pull_title,item);
        helper.itemView.setOnClickListener(view ->
                Toast.makeText(mContext, item, Toast.LENGTH_SHORT).show());
    }
}
