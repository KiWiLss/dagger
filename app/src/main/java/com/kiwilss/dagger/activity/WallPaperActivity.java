package com.kiwilss.dagger.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.kiwilss.dagger.R;
import com.kiwilss.dagger.utils.GlideUtils;

/**
 * FileName: WallPaperActivity
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/13
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class WallPaperActivity extends AppCompatActivity {
    private android.widget.ImageView ivwallpapericon;
    private android.widget.Button btnwallpaperget;
    private android.widget.Button btnwallpapersetR;
    private android.widget.Button btnwallpaperchoice;
    private Button btnwallpaperglide;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallpaper);
        this.btnwallpaperglide = (Button) findViewById(R.id.btn_wallpaper_glide);
        this.btnwallpaperchoice = (Button) findViewById(R.id.btn_wallpaper_choice);
        this.btnwallpapersetR = (Button) findViewById(R.id.btn_wallpaper_setR);
        this.btnwallpaperget = (Button) findViewById(R.id.btn_wallpaper_get);
        this.ivwallpapericon = (ImageView) findViewById(R.id.iv_wallpaper_icon);


        btnwallpapersetR.setOnClickListener(view -> {
            //该方法可以直接将图片置为壁纸，对于所有平台的Android系统都使用，但无法裁剪/调整图片。
//            try {
//                WallpaperManager wpm = (WallpaperManager)getSystemService(
//                        Context.WALLPAPER_SERVICE);
//                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image1);
//                if (wpm != null) {
//                    wpm.setBitmap(bitmap);
//                    Log.i("xzy", "wallpaper not null");
//                }
//            } catch (IOException e) {
//                Log.e("MMM", "Failed to set wallpaper: " + e);
//            }

          //进入图库选择壁纸
//            final Intent pickWallpaper = new Intent(Intent.ACTION_SET_WALLPAPER);
//            Intent chooser = Intent.createChooser(pickWallpaper, "选择壁纸");
//            startActivity(chooser);
        });
        String url = "http://guolin.tech/book.png";
        btnwallpaperget.setOnClickListener(view -> {
            //Glide.with(WallPaperActivity.this).load(url).into(ivwallpapericon);
            //占位图
//            RequestOptions requestOptions = new RequestOptions();
//            requestOptions.placeholder(R.drawable.image3);
//            Glide.with(WallPaperActivity.this)
//                    .load(url).apply(requestOptions).into(ivwallpapericon);
            //清楚缓存,显示占位图
//            RequestOptions requestOptions = new RequestOptions();
//            requestOptions.placeholder(R.drawable.image3)
//            .diskCacheStrategy(DiskCacheStrategy.NONE);
//            Glide.with(WallPaperActivity.this)
//                    .load(url).apply(requestOptions).into(ivwallpapericon);
            //异常占位符
            //RequestOptions requestOptions = new RequestOptions();
//            requestOptions
//                    .transform(new BlurTransformation())
//                    .placeholder(R.drawable.image3)
//                    .error(R.drawable.image9)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE);

//
//            MultiTransformation multi = new MultiTransformation(
//                    new BlurTransformation(25),
//                    new RoundedCornersTransformation
//                            (128, 0, RoundedCornersTransformation.CornerType.BOTTOM));

//            requestOptions
//                    .transform(new CircleCrop())
//                    .placeholder(R.drawable.image3)
//                    .error(R.drawable.image9)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE);

//            requestOptions
//                    .transform(new RoundedCornersTransformation(Utils.dip2px(this,10),0))
//                    .placeholder(R.drawable.image3)
//                    .error(R.drawable.image9)
//                    .diskCacheStrategy(DiskCacheStrategy.NONE);
//
//            Glide.with(WallPaperActivity.this)
//                    .load(url).apply(requestOptions).into(ivwallpapericon);


            GlideUtils.getInstance().loadCircleImg(WallPaperActivity.this,url,ivwallpapericon);
            //GlideUtils.getInstance().loadSquareImg(WallPaperActivity.this,url,ivwallpapericon);
        });


        btnwallpaperchoice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(WallPaperActivity.this,
                        GlideTestActivity.class));
            }
        });

        btnwallpaperglide.setOnClickListener(view -> {
            startActivity(new Intent(WallPaperActivity.this,
                    GlideKuActivity.class));
        });

    }
}
