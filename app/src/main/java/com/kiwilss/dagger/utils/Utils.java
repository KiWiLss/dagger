package com.kiwilss.dagger.utils;

import android.graphics.Rect;
import android.view.View;

/**
 * FileName: Utils
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/12
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class Utils {

    /**
     * 检测制定View是否被遮住显示不全
     * @return
     */
    public static boolean isCover(View view) {
        boolean cover = false;
        Rect rect = new Rect();
        cover = view.getGlobalVisibleRect(rect);
        if (cover) {
            if (rect.width() >= view.getMeasuredWidth() && rect.height() >= view.getMeasuredHeight()) {
                return !cover;
            }
        }
        return true;
    }

}
