package com.kiwilss.dagger.basetext.scroll;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.HorizontalScrollView;

import com.kiwilss.dagger.R;

/**
 * FileName: HorizontalActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/12
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class HorizontalActivity extends AppCompatActivity {
    private android.widget.Button btnhorizontalone;
    private android.widget.Button btnhorizontaltwo;
    private android.widget.Button btnhorizontalthree;
    private android.widget.Button btnhorizontalfour;
    private android.widget.Button btnhorizontalfive;
    private android.widget.Button btnhorizontalsix;
    private android.widget.Button btnhorizontalseven;
    private android.widget.Button btnhorizontaleight;
    private android.widget.Button btnhorizontalnine;
    private android.widget.Button btnhorizontalten;
    private android.widget.HorizontalScrollView hsvhorizontalouter;
    private Button btnhorizontaltest;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_horizontal);
        this.btnhorizontaltest = (Button) findViewById(R.id.btn_horizontal_test);
        this.hsvhorizontalouter = (HorizontalScrollView) findViewById(R.id.hsv_horizontal_outer);
        this.btnhorizontalten = (Button) findViewById(R.id.btn_horizontal_ten);
        this.btnhorizontalnine = (Button) findViewById(R.id.btn_horizontal_nine);
        this.btnhorizontaleight = (Button) findViewById(R.id.btn_horizontal_eight);
        this.btnhorizontalseven = (Button) findViewById(R.id.btn_horizontal_seven);
        this.btnhorizontalsix = (Button) findViewById(R.id.btn_horizontal_six);
        this.btnhorizontalfive = (Button) findViewById(R.id.btn_horizontal_five);
        this.btnhorizontalfour = (Button) findViewById(R.id.btn_horizontal_four);
        this.btnhorizontalthree = (Button) findViewById(R.id.btn_horizontal_three);
        this.btnhorizontaltwo = (Button) findViewById(R.id.btn_horizontal_two);
        this.btnhorizontalone = (Button) findViewById(R.id.btn_horizontal_one);


        btnhorizontalsix.setOnClickListener(view -> {
            int width = hsvhorizontalouter.getWidth();
            //Log.e("MMM", "onCreate: "+btnhorizontalsix.getX()+"|||"+btnhorizontalsix.getWidth());
            int v = (int) (btnhorizontalsix.getX() + btnhorizontalsix.getWidth() / 2);
            Log.e("MMM", "onCreate: screen--->" + width + "|||" + v + "|||" + (v - width / 2)
                    + "||" + btnhorizontalsix.getX());
            hsvhorizontalouter.scrollTo((v - width / 2), 0);
        });

        btnhorizontaltest.setOnClickListener(view -> {
            startActivity(new Intent(HorizontalActivity.this,RecyclerHorizontalActivity.class));
            //Log.e("MMM", "onCreate: "+btnhorizontaltest.getX()+"||"+btnhorizontaltest.getLeft());
        });
    }
}
