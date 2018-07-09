package com.kiwilss.dagger.adapter;

import com.chad.library.adapter.base.BaseItemDraggableAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.kiwilss.dagger.R;

import java.util.List;

/**
 * FileName: RvItemTouchAdapter2
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvItemTouchAdapter2 extends BaseItemDraggableAdapter<String,BaseViewHolder> {


    public RvItemTouchAdapter2(int layoutResId, List<String> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, String item) {
        helper.setText(R.id.tv_item_rv_linear_text,item);
    }
}
