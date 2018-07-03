package com.kiwilss.dagger.basetext;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.kiwilss.dagger.R;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * FileName: WebviewActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/6/13
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class WebviewActivity extends AppCompatActivity {
    private WebView mWebView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        this.mWebView = findViewById(R.id.wv);

        settings();

        mWebView.setWebViewClient(new WebViewClient(){


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("MMM", "shouldOverrideUrlLoading: "+url);
                if (!TextUtils.isEmpty(url)) {
                    view.loadUrl(url);
                }
                return super.shouldOverrideUrlLoading(view, url);
            }

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                Log.e("MMM", "onPageFinished: "+url);

//                if (TextUtils.equals(url,"https://creditcardapp.bankcomm.com/member/apply/status/inquiry.html")) {
//
//                    startRask();
//
//                }


//                // 获取页面内容
                view.loadUrl("javascript:window.java_obj.showSource("
                        + "document.getElementsByTagName('html')[0].innerHTML);");

                // 获取解析<meta name="share-description" content="获取到的值">
                view.loadUrl("javascript:window.java_obj.showDescription("
                        + "document.querySelector('meta[name=\"share-description\"]').getAttribute('content')"
                        + ");");
                super.onPageFinished(view, url);
            }

            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
                super.onReceivedError(view, request, error);
            }
        });
        //mWebView.loadUrl("http://list.iqiyi.com/www/2/-------------24-1-1-iqiyi--.html");
        mWebView.loadUrl("https://creditcardapp.bankcomm.com/member/apply/status/inquiry.html?from=groupmessage");


    }


    public void startRask(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                URL url = null;
                try {
                    //url = new URL("http://lol.qq.com/web201310/info-heros.shtml");
                    url = new URL("https://creditcardapp.bankcomm.com/member/apply/status/inquiry.html");
                    //url = new URL("https://creditcardapp.bankcomm.com/member/apply/status/inquiry.html?from=groupmessage");
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
                        Log.e("MMM", "run: "+str);
                        SharedPreferences sp = getSharedPreferences("default", Context.MODE_PRIVATE);

                        SharedPreferences.Editor edit = sp.edit();
                        edit.putString("html",str);
                        edit.apply();

                        msg.setData(bundle);
                        msg.what = 0x123;
                        //mHandler.sendMessage(msg);

                    } else {
                        Log.e("MMM" ,httpURLConnection.getResponseCode() +"");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();


    }





    public static final String TAG = "MMM";
    public final class InJavaScriptLocalObj
    {

        @JavascriptInterface
        public void showSource(String html) {
            //Log.e(TAG, "showSource: "+html);
            if (html.length() > 4000) {
                for (int i = 0; i < html.length(); i += 4000) {
                    //当前截取的长度<总长度则继续截取最大的长度来打印
                    if (i + 4000 < html.length()) {
                        Log.e("MMM" + i, html.substring(i, i + 4000));
                    } else {
                        //当前截取的长度已经超过了总长度，则打印出剩下的全部信息
                        Log.e("MMM" + i, html.substring(i, html.length()));
                    }
                }
            } else {
                //直接打印
                Log.e("MMM", html);
            }

            boolean contains = html.contains("很抱歉，目前未查询到相关记录");
            //true就代表有这句话
            int i = html.indexOf("很抱歉，目前未查询到相关记录");
            //i!= -1,就代表有这段话
            Log.e(TAG, "showSource: --------------------------------------"+contains+"||||"+i );
        }

        @JavascriptInterface
        public void showDescription(String str) {
            Log.e(TAG, "showDescription: "+str );
        }
    }

    @SuppressLint({"SetJavaScriptEnabled", "AddJavascriptInterface"})
    private void settings(){
        // 开启JavaScript支持
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new InJavaScriptLocalObj(), "java_obj");
        // 设置WebView是否支持使用屏幕控件或手势进行缩放，默认是true，支持缩放
        mWebView.getSettings().setSupportZoom(true);
        // 设置WebView是否使用其内置的变焦机制，该机制集合屏幕缩放控件使用，默认是false，不使用内置变焦机制。
        mWebView.getSettings().setBuiltInZoomControls(true);
        // 设置是否开启DOM存储API权限，默认false，未开启，设置为true，WebView能够使用DOM storage API
        mWebView.getSettings().setDomStorageEnabled(true);
        // 触摸焦点起作用.如果不设置，则在点击网页文本输入框时，不能弹出软键盘及不响应其他的一些事件。
        mWebView.requestFocus();
        // 设置此属性,可任意比例缩放,设置webview推荐使用的窗口
        mWebView.getSettings().setUseWideViewPort(true);
        // 设置webview加载的页面的模式,缩放至屏幕的大小
        mWebView.getSettings().setLoadWithOverviewMode(true);
    }
}
