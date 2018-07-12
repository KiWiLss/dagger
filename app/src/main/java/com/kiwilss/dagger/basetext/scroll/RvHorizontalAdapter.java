package com.kiwilss.dagger.basetext.scroll;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kiwilss.dagger.R;

import java.util.List;

/**
 * FileName: RvHorizontalAdapter
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/12
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvHorizontalAdapter extends BaseQuickAdapter<String,BaseViewHolder> {
    public RvHorizontalAdapter(int layoutResId, @Nullable List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_wx_pull_title,item);
    }
}
