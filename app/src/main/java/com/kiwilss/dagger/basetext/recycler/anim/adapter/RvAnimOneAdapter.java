package com.kiwilss.dagger.basetext.recycler.anim.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kiwilss.dagger.R;

import java.util.List;

/**
 * FileName: RvAnimOneAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/11
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvAnimOneAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public RvAnimOneAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_toutiao_two_title,item);
    }
}
