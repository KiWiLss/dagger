package com.kiwilss.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.adapter.MainAdapter;
import com.kiwilss.dagger.adapter.MainAdapter.Type;

import java.util.ArrayList;
import java.util.List;

/**
 * FileName: GlideTestActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/13
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class GlideTestActivity extends AppCompatActivity {
    private android.support.v7.widget.RecyclerView rvglidetestlist;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_test);
        this.rvglidetestlist = (RecyclerView) findViewById(R.id.rv_glide_test_list);

        rvglidetestlist.setLayoutManager(new LinearLayoutManager(this));

        List<Type> dataSet = new ArrayList<>();
        dataSet.add(Type.Mask);
        dataSet.add(Type.NinePatchMask);
        dataSet.add(Type.CropTop);
        dataSet.add(Type.CropCenter);
        dataSet.add(Type.CropBottom);
        dataSet.add(Type.CropSquare);
        dataSet.add(Type.CropCircle);
        dataSet.add(Type.ColorFilter);
        dataSet.add(Type.Grayscale);
        dataSet.add(Type.RoundedCorners);
        dataSet.add(Type.Blur);
        dataSet.add(Type.SupportRSBlur);
        dataSet.add(Type.Toon);
        dataSet.add(Type.Sepia);
        dataSet.add(Type.Contrast);
        dataSet.add(Type.Invert);
        dataSet.add(Type.Pixel);
        dataSet.add(Type.Sketch);
        dataSet.add(Type.Swirl);
        dataSet.add(Type.Brightness);
        dataSet.add(Type.Kuawahara);
        dataSet.add(Type.Vignette);

        rvglidetestlist.setAdapter(new MainAdapter(this, dataSet));
    }
}
