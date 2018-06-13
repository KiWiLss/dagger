package com.kiwilss.dagger.basetext;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import com.kiwilss.dagger.R;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * FileName: TextViewActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/13
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class TextViewActivity extends AppCompatActivity {
    private android.widget.TextView tvtextviewtv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_textview);
        this.tvtextviewtv = (TextView) findViewById(R.id.tv_textview_tv);


        startRask();
    }

    @SuppressLint("HandlerLeak")
    Handler mHandler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            int what = msg.what;
            Object obj = msg.obj;
            Bundle data = msg.getData();
            String stringUrl = data.getString("stringUrl");
            tvtextviewtv.setText(stringUrl);

        }
    };

    public void startRask(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    url = new URL("http://lol.qq.com/web201310/info-heros.shtml");
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                try {
                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                    if(httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {

                        InputStreamReader is = new InputStreamReader(httpURLConnection.getInputStream());
                        int i = 0;
                        StringBuffer sb = new StringBuffer();
                        while ((i = is.read()) != -1 ) {
                            sb.append((char) i);
                        }
//                        Log.d("TAG",sb.toString());
                        Message msg = new Message();
                        Bundle bundle = new Bundle();
                        byte[] bytes = sb.toString().getBytes("utf-8");
                        String str = new String(bytes);
                        bundle.putString("stringUrl", str);
                        msg.setData(bundle);
                        msg.what = 0x123;
                        mHandler.sendMessage(msg);

                    } else {
                        Log.e("MMM" ,httpURLConnection.getResponseCode() +"");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }

}
