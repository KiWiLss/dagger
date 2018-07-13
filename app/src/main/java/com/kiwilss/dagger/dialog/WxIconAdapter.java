package com.kiwilss.dagger.dialog;

import android.support.annotation.Nullable;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kiwilss.dagger.R;

import java.util.List;

/**
 * FileName: WxIconAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/11
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class WxIconAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public WxIconAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        ImageView iv = helper.getView(R.id.iv_item_main_activity_image);


        Glide.with(mContext).load(mData.get(helper.getAdapterPosition()))
                //.placeholder(R.mipmap.ic_launcher).dontAnimate()
                .into(iv);
    }
}
