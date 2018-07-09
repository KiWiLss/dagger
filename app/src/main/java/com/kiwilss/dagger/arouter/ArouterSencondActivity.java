package com.kiwilss.dagger.arouter;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.kiwilss.dagger.Constance;
import com.kiwilss.dagger.R;
import com.kiwilss.dagger.model.ManualBean;

/**
 * FileName: ArouterSencondActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/9
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
@Route(path = Constance.ACTIVITY_URL_SECOND)
public class ArouterSencondActivity extends AppCompatActivity {

    public static final String TAG = "MMM";
    @Autowired(name = "key")
    String name;
    @Autowired()
    int age;
    @Autowired(name = "test")
    ManualBean mManualBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arouter_second);
        ARouter.getInstance().inject(this);
        Log.e(TAG, "onCreate: "+name+"||"+age+"||"+mManualBean.toString());




    }

    public void finishResult(View view) {
        setResult(RESULT_OK);
        finish();
    }
}
