package com.kiwilss.dagger.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.kiwilss.dagger.R;
import com.kiwilss.dagger.utils.GlideUtils;


/**
 * FileName: GlideKuActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/13
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class GlideKuActivity extends AppCompatActivity {

    View draggableView;
    String url1 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1497688355699&di=ea69a930b82ce88561c635089995e124&imgtype=0&src=http%3A%2F%2Fcms-bucket.nosdn.127.net%2Ff84e566bcf654b3698363409fbd676ef20161119091503.jpg";
    String url2 = "http://img1.imgtn.bdimg.com/it/u=4027212837,1228313366&fm=23&gp=0.jpg";
    String url3 = "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1529402445474&di=b5da3b2f6a466e618e1e32d4dd2bda4d&imgtype=0&src=http%3A%2F%2F2b.zol-img.com.cn%2Fproduct%2F133_500x2000%2F801%2Fce21ke76FRh4A.jpg";
    String gif1 = "http://img.zcool.cn/community/01e97857c929630000012e7e3c2acf.gif";
    String gif2 = "http://5b0988e595225.cdn.sohucs.com/images/20171202/a1cc52d5522f48a8a2d6e7426b13f82b.gif";
    String gif3 = "http://img.zcool.cn/community/01d6dd554b93f0000001bf72b4f6ec.jpg";
    public static final String cat = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/resources/cat.jpg";
    public static final String cat_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/resources/cat_thumbnail.jpg";
    public static final String girl = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/resources/girl.jpg";
    public static final String girl_thumbnail = "https://raw.githubusercontent.com/sfsheng0322/GlideImageView/master/resources/girl_thumbnail.jpg";
    private android.widget.ImageView ivglidekuone;
    String url = "http://guolin.tech/book.png";
    String mImageUrl = new String("https://raw.githubusercontent.com/JessYanCoding/MVPArmsTemplate/master/art/step.png");
    private ImageView ivglidekutwo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide_ku);
        this.ivglidekutwo = (ImageView) findViewById(R.id.iv_glide_ku_two);
        this.ivglidekuone = (ImageView) findViewById(R.id.iv_glide_ku_one);


//        OkHttpClient okHttpClient = ProgressManager.getInstance().with(new OkHttpClient.Builder())
//                .build();
        GlideUtils.getInstance().loadImg(this, url, ivglidekuone);
//        ProgressManager.getInstance().addResponseListener(url, new ProgressListener() {
//            @Override
//            public void onProgress(ProgressInfo progressInfo) {
//                Log.e("MMM", "onProgress: " + progressInfo.getPercent());
//            }
//
//            @Override
//            public void onError(long id, Exception e) {
//                Log.e("MMM", "onError: " + e.getMessage());
//            }
//        });
//        ivglidekutwo.setOnClickListener(view -> {
//
////            RequestOptions requestOptions = new RequestOptions()
////                    .placeholder(R.drawable.image9).diskCacheStrategy(DiskCacheStrategy.NONE);
//            Glide.with(GlideKuActivity.this)
//                    .load(url)
//                  //.apply(requestOptions)
//                    .into(ivglidekuone);
//        });
//

//        ProgressInterceptor.addListener(url, new ProgressListener() {
//            @Override
//            public void onProgress(int progress) {
//                Log.e("MMM", "onProgress: "+progress );
//            }
//        });

        RequestOptions options = new RequestOptions()
                .skipMemoryCache(true)
                .diskCacheStrategy(DiskCacheStrategy.NONE);

       // Glide.with(this)
                //.load(url)
                //.apply(options)
//                .listener(new RequestListener<Drawable>() {
//                    @Override
//                    public boolean onLoadFailed(@Nullable GlideException e,
//                                                Object model, Target<Drawable> target, boolean isFirstResource) {
//                        ProgressInterceptor.removeListener(url);
//                        //bar.setVisibility(View.GONE);
//                        return false;
//                    }
//
//                    @Override
//                    public boolean onResourceReady(Drawable resource, Object model,
//                                                   Target<Drawable> target, DataSource dataSource, boolean isFirstResource) {
//                        ProgressInterceptor.removeListener(url);
//                        //bar.setVisibility(View.GONE);
//                        return false;
//                    }
//                })
                //.into(ivglidekuone);


    }
}
