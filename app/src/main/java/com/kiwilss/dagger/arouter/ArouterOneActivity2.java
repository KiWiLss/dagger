package com.kiwilss.dagger.arouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.kiwilss.dagger.Constance;
import com.kiwilss.dagger.R;
import com.kiwilss.dagger.model.ManualBean;

/**
 * FileName: ArouterOneActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */

@Route(path = Constance.ACTIVITY_URL_ONE2)
public class ArouterOneActivity2 extends AppCompatActivity {


    @Autowired(name = "name")
    String name;
    @Autowired()
    int age;
    @Autowired(name = "test")
    ManualBean mManualBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter);

        //获取路由参数
        //Toast.makeText(this, name+"--"+age+"--"+mManualBean.toString(), Toast.LENGTH_SHORT).show();
        Log.e("MMM", "onCreate: "+name );

    }
}
