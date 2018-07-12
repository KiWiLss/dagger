package com.kiwilss.dagger.basetext.scroll;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.utils.Utils;
import com.kiwilss.dagger.widget.MyTextView;

/**
 * FileName: ScrollActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/12
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class ScrollActivity extends AppCompatActivity {
    private android.widget.TextView tvscrollone;
    private android.widget.TextView tvscrolltwo;
    private android.widget.TextView tvscrollthree;
    private android.widget.ScrollView svscrollouter;
    private com.kiwilss.dagger.widget.MyTextView mtvscrollfour;
    private com.kiwilss.dagger.widget.MyTextView mtvscrollfive;
    private android.widget.LinearLayout llscrollouter;
    private android.widget.Button btnscrollclick;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll);
        this.btnscrollclick = (Button) findViewById(R.id.btn_scroll_click);
        this.llscrollouter = (LinearLayout) findViewById(R.id.ll_scroll_outer);
        this.mtvscrollfive = (MyTextView) findViewById(R.id.mtv_scroll_five);
        this.mtvscrollfour = (MyTextView) findViewById(R.id.mtv_scroll_four);
        this.svscrollouter = (ScrollView) findViewById(R.id.sv_scroll_outer);
        this.tvscrollthree = (TextView) findViewById(R.id.tv_scroll_three);
        this.tvscrolltwo = (TextView) findViewById(R.id.tv_scroll_two);
        this.tvscrollone = (TextView) findViewById(R.id.tv_scroll_one);


        svscrollouter.getViewTreeObserver().addOnScrollChangedListener
                (new ViewTreeObserver.OnScrollChangedListener() {
                    @Override
                    public void onScrollChanged() {


                        boolean one = Utils.isCover(tvscrollone);

                        boolean three = Utils.isCover(tvscrollthree);

                        boolean four = mtvscrollfour.isCover();

                        Log.e("MMM", "onScrollChanged: " + one + "||" + three + "||" + four);
                    }
                });


    }


    public void scrollFourListener(View view) {
        //滚动到底部
        //svscrollouter.scrollTo(0, llscrollouter.getMeasuredHeight()-svscrollouter.getHeight());
//        svscrollouter.fullScroll(ScrollView.FOCUS_DOWN);
//        //滚动到顶部：
//        svscrollouter.fullScroll(ScrollView.FOCUS_UP);
        Log.e("MMM", "run: ---------" + tvscrollone.getHeight() + "||" + tvscrollone.getMeasuredHeight()
                + "|||" + mtvscrollfour.getHeight());

        //svscrollouter.scrollTo(0,tvscrollone.getHeight());
        //滚动到第二个布局
        svscrollouter.scrollTo(0, btnscrollclick.getHeight()+tvscrollone.getHeight());
        //滚到第四个布局
        svscrollouter.scrollTo(0, btnscrollclick.getHeight()+tvscrollone.getHeight()
        +tvscrollthree.getHeight()+tvscrolltwo.getHeight());
        //滚动到自动控件位置
//        tvscrollthree.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//
//                svscrollouter.scrollTo(0,tvscrollone.getHeight());
//
//                Log.e("MMM", "run: "+tvscrollone.getHeight()+"||"+tvscrollone.getMeasuredHeight()
//                +"|||"+mtvscrollfour.getHeight());
//            }
//        }, 200);


    }
}
