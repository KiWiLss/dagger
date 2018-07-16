package com.kiwilss.dagger.model;

import android.content.Context;
import android.support.annotation.NonNull;

import com.bumptech.glide.Glide;
import com.bumptech.glide.Registry;
import com.bumptech.glide.annotation.GlideModule;
import com.bumptech.glide.module.AppGlideModule;

/**
 * FileName: MyAppGlideModule
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/13
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
@GlideModule
public class MyAppGlideModule extends AppGlideModule{

    @Override
    public void registerComponents(@NonNull Context context, @NonNull Glide glide, @NonNull Registry registry) {
        //添加拦截器到Glide
//        OkHttpClient.Builder builder = new OkHttpClient.Builder();
//        builder.addInterceptor(new ProgressInterceptor());
//        OkHttpClient okHttpClient = builder.build();
//
//        //原来的是  new OkHttpUrlLoader.Factory()；
//        registry.replace(GlideUrl.class, InputStream.class, new OkHttpUrlLoader.Factory(okHttpClient));

    }

    @Override
    public boolean isManifestParsingEnabled() {
        return false;
    }
}
