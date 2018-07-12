package com.kiwilss.dagger.basetext.recycler.anim;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.animation.OvershootInterpolator;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.basetext.recycler.anim.adapter.RvAnimOneAdapter;

import java.util.ArrayList;

import jp.wasabeef.recyclerview.adapters.AlphaInAnimationAdapter;
import jp.wasabeef.recyclerview.animators.SlideInLeftAnimator;

/**
 * FileName: RvAnimOneActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/11
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class RvAnimOneActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvlinearlist;
    private ArrayList<String> mData;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear);
        this.rvlinearlist = (RecyclerView) findViewById(R.id.rv_linear_list);

        initData();
        initAdapter();

    }


    private void initAdapter() {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rvlinearlist.setLayoutManager(linearLayoutManager);

        RvAnimOneAdapter adapter = new RvAnimOneAdapter(R.layout.item_toutiao_two, mData);
        //rvlinearlist.setAdapter(adapter);

        //默认渐变
        //adapter.openLoadAnimation();
        //其他已有的动画
        //adapter.openLoadAnimation(BaseQuickAdapter.SCALEIN);
        //adapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_BOTTOM);
        //是否只执行一次
        //adapter.isFirstOnly(false);
        //自定义动画
//        adapter.openLoadAnimation(new BaseAnimation() {
//            @Override
//            public Animator[] getAnimators(View view) {
//                return new Animator[0];
//            }
//        });

        //ObjectAnimator.ofFloat(rvlinearlist,"alpha",0f,1f,0f,1f);


        //第三方库动画
        //设置单个item动画
        rvlinearlist.setItemAnimator(new SlideInLeftAnimator());
        //设置整个动画
        AlphaInAnimationAdapter alphaInAnimationAdapter = new AlphaInAnimationAdapter(adapter);
        alphaInAnimationAdapter.setFirstOnly(true);
        alphaInAnimationAdapter.setDuration(500);
        alphaInAnimationAdapter.setInterpolator(new OvershootInterpolator(5f));
        rvlinearlist.setAdapter(alphaInAnimationAdapter);

    }




    private void initData() {
        mData = new ArrayList<>();
        mData.add("关注");
        mData.add("推荐");
        mData.add("热点");
        mData.add("世界杯");
        mData.add("军事");
        mData.add("国际");
        mData.add("问答");
        mData.add("视频");
        mData.add("图片");
        mData.add("娱乐");
        mData.add("科技");
        mData.add("国风");
        mData.add("地理");
        mData.add("地球仪");
        mData.add("本地");
        mData.add("房产");
        mData.add("直播");
        mData.add("时尚");
        mData.add("小说");
        mData.add("历史");
        mData.add("育儿");
        mData.add("搞笑");
        mData.add("美食");
        mData.add("养生");
        mData.add("电影");
        mData.add("手机");
        mData.add("旅游");
    }
}
