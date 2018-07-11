package com.kiwilss.dagger.wxpull;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.ColorRes;
import android.support.annotation.DimenRes;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.kiwilss.dagger.MyApplication;

import java.util.List;

public class UIHelper {

    /**
     * dp转px
     */
    public static int dip2px(float dpValue) {
        float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static boolean hasEmpty(List<TextView> edits) {
        for (TextView editText : edits) {
            if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasEmpty(TextView... edits) {
        for (TextView editText : edits) {
            if (TextUtils.isEmpty(editText.getText().toString().trim())) {
                return true;
            }
        }
        return false;
    }

    public static boolean hasEmpty(ImageView[] edits) {
        for (ImageView imageView : edits) {
            if (TextUtils.isEmpty(imageView.getTag().toString().trim())) {
                return true;
            }
        }
        return false;
    }


    public static void setRightDrawable(TextView textView, int draw) {
        Drawable drawable = UIHelper.getDrawable(draw);
        try {
            assert drawable != null;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(null, null, drawable, null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void setTopDrawable(TextView textView, int draw) {
        Drawable drawable = UIHelper.getDrawable(draw);
        try {
            assert drawable != null;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(null, drawable, null, null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void setLeftDrawable(TextView textView, int draw) {
        Drawable drawable = UIHelper.getDrawable(draw);
        try {
            assert drawable != null;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(drawable, null, null, null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    public static void setLeftDrawable(TextView textView, Drawable drawable) {
        try {
            assert drawable != null;
            drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
            textView.setCompoundDrawables(drawable, null, null, null);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    /**
     * 资源ID获取String
     */
    public static String getString(int stringId) {
        Context context = MyApplication.getContext();
        if (context != null) {
            return context.getString(stringId);
        }
        return " ";
    }

    public static String getString(int stringId, Object... formatArgs) {
        Context context = MyApplication.getContext();
        if (context != null) {
            return context.getString(stringId, formatArgs);
        }
        return "";
    }

    /**
     * 获取尺寸
     */
    public static int getDimension(@DimenRes int dimenRes) {
        return (int) MyApplication.getContext().getResources().getDimension(dimenRes);
    }

    /**
     * 获取颜色
     */
    public static int getColor(@ColorRes int color) {
        return ContextCompat.getColor(MyApplication.getContext(), color);
    }

    /**
     * 字符串转16进制整数
     */
    public static int getColor(String color) {
        if (TextUtils.isEmpty(color) || !Validator.checkColor(color)) {
            return 0;
        }
        return Color.parseColor(color);
    }

    /**
     * 字符串转16进制整数,带默认值
     */
    public static int getColor(String color, String defaultColor) {
        if (TextUtils.isEmpty(color) || !Validator.checkColor(color)) {
            return getColor(defaultColor);
        }
        return Color.parseColor(color);
    }

    public static int getColor(String color, @ColorRes int defaultColor) {
        if (TextUtils.isEmpty(color) || !Validator.checkColor(color)) {
            return getColor(defaultColor);
        }
        return Color.parseColor(color);
    }


    /**
     * 获取Drawable
     */
    public static Drawable getDrawable(int drawable) {
        return ContextCompat.getDrawable(MyApplication.getContext(), drawable);
    }

    public static View inflaterLayout(Context context, @LayoutRes int layoutRes) {
        LayoutInflater inflater = LayoutInflater.from(context);
        return inflater.inflate(layoutRes, null);
    }

    /**
     * HTML颜色
     */
    public static String setHtmlColor(String color, String content) {
        if (TextUtils.isEmpty(color)) return content;
        return String.format(Htmls.color, color, content);
    }

    /**
     * 圆角Drawable
     *
     * @param radius 圆角
     * @param color  填充颜色
     */
    public static GradientDrawable getShapeDrawable(int radius, @ColorInt int color) {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(color);
        gd.setCornerRadius(radius);
        return gd;
    }

    public static void clipContent(String content) {
        ClipboardManager cm = (ClipboardManager) ContextHelper.getAppContext().getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData mClipData = ClipData.newPlainText("Label", content);
        if (cm != null) {
            cm.setPrimaryClip(mClipData);
        }
    }

    public static String getClipContent() {
        ClipboardManager cm = (ClipboardManager) ContextHelper.getAppContext().getSystemService(Context.CLIPBOARD_SERVICE);
        if (cm != null && cm.getPrimaryClipDescription().hasMimeType(
                ClipDescription.MIMETYPE_TEXT_PLAIN)) {
            ClipData cdText = cm.getPrimaryClip();
            ClipData.Item item = cdText.getItemAt(0);
            return item.getText().toString();
        }
        return "";
    }
}
