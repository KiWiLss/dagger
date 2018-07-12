package com.kiwilss.dagger.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.TextView;

/**
 * FileName: MyTextView
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/12
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {

    public static final String TAG = "MMM";

    public MyTextView(Context context) {
        super(context);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility==VISIBLE){
            //可见
            Log.e(TAG, "onWindowVisibilityChanged: "+visibility);
        }else {
            //不可见
            Log.e(TAG, "onWindow------VisibilityChanged: "+visibility);
        }
    }

    public boolean isCover() {
        boolean cover = false;
        Rect rect = new Rect();
        cover = getGlobalVisibleRect(rect);
        if (cover) {
            if (rect.width() >= getMeasuredWidth() && rect.height() >= getMeasuredHeight()) {
                return !cover;
            }
        }
        return true;
    }
}
