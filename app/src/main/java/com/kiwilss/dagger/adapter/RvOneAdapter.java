package com.kiwilss.dagger.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

/**
 * FileName: RvOneAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/21
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvOneAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public RvOneAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        //helper.setText(R.id.tv_item_rv_one_tv,item);
    }
}
