package com.kiwilss.dagger.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;

import static com.bumptech.glide.request.RequestOptions.bitmapTransform;

/**
 * FileName: GlideUtils
 *
 * @author : Lss kiwilss
 * e-mail : kiwilss@163.com
 * time   : 2018/7/13
 * desc   : ${DESCRIPTION}
 * Description: ${DESCRIPTION}
 */
public class GlideUtils {

    private GlideUtils(){}

    private static class GlideUtilsSingle{
        private static final GlideUtils GLIDE_UTILS = new GlideUtils();
    }

    public static GlideUtils getInstance(){
        return GlideUtilsSingle.GLIDE_UTILS;
    }

    /**
     * 一般的加载
     */
    public void loadImg(Context context, String url, ImageView view){
        Glide.with(context).load(url).into(view);
    }

    /**
     * 加载图片带占位图
     */
    public void loadImg(Context context, String url, ImageView view,int placeholderId){
        RequestOptions options = new RequestOptions().placeholder(placeholderId);
        Glide.with(context).load(url).apply(options).into(view);
    }
    /**
     * 加载图片带加载错误图片
     */
    public void loadImgError(Context context, String url, ImageView view,int errorId){
        RequestOptions options = new RequestOptions().error(errorId);
        Glide.with(context).load(url).apply(options).into(view);
    }
    /**
     * 加载图片带,占位图,加载错误图片
     */
    public void loadImg(Context context, String url,
                                        ImageView view,int placeholderId,int errorId){
        RequestOptions options = new RequestOptions()
                .placeholder(placeholderId).error(errorId);
        Glide.with(context).load(url).apply(options).into(view);
    }
    /**
     * 一般的加载,圆形图
     */
    public void loadCircleImg(Context context,String url,ImageView view){
            RequestOptions options = new RequestOptions().circleCrop();
            Glide.with(context).load(url).apply(options).into(view);
    }

    /**
     * 一般的加载,圆形图,带占位图
     */
    public void loadCircleImg(Context context,String url,ImageView view,int placeholderId){
        RequestOptions options = new RequestOptions().placeholder(placeholderId).circleCrop();
        Glide.with(context).load(url).apply(options).into(view);
    }
    /**
     * 一般的加载,圆形图,带加载错误图
     */
    public void loadCircleImgError(Context context,String url,ImageView view,int errorId){
        RequestOptions options = new RequestOptions().error(errorId).circleCrop();
        Glide.with(context).load(url).apply(options).into(view);
    }
    /**
     * 一般的加载,圆形图,带,占位图,加载错误图
     */
    public void loadCircleImg(Context context,String url,ImageView view,int placeholder,int errorId){
        RequestOptions options = new RequestOptions().placeholder(placeholder).error(errorId).circleCrop();
        //Glide.with(context).load(url).apply(options).into(view);
        load(context,url,view,options);
    }

    private void load(Context context, String url, ImageView view, RequestOptions options){
        Glide.with(context).load(url).apply(options).into(view);
    }
    /**
     * 一般的加载,正方形
     */
    public void loadSquareImg(Context context,String url,ImageView view){
        Glide.with(context).load(url)
                .apply(bitmapTransform(new CropSquareTransformation()))
                .into(view);
    }
    /**
     * 一般的加载,正方形,占位图
     */
    public void loadSquareImg(Context context,String url,ImageView view,int placeholderId){
        Glide.with(context).load(url)
                .apply(bitmapTransform(new CropSquareTransformation()).placeholder(placeholderId))
                .into(view);
    }
    /**
     * 一般的加载,正方形,错误图
     */
    public void loadSquareImgError(Context context,String url,ImageView view,int errorId){
        Glide.with(context).load(url)
                .apply(bitmapTransform(new CropSquareTransformation()).error(errorId))
                .into(view);
    }
    /**
     * 一般的加载,正方形,错误图,占位图
     */
    public void loadSquareImg(Context context,String url,ImageView view,int errorId,int placeholderId){
        Glide.with(context).load(url)
                .apply(bitmapTransform
                        (new CropSquareTransformation()).placeholder(placeholderId).error(errorId))
                .into(view);
    }
    /**
     * 一般的加载,圆角
     */
    public void loadRoundeImg(Context context,String url,ImageView view
            ,int radius,RoundedCornersTransformation.CornerType cornerType){
        Glide.with(context).load(url)
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0,
                        cornerType)))
                .into(view);
    }

    /**
     * 一般的加载,圆角,占位图
     */
    public void loadRoundeImg(Context context,String url,ImageView view
            ,int radius,RoundedCornersTransformation.CornerType cornerType,int placeholderId){
        Glide.with(context).load(url)
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0,
                        cornerType)).placeholder(placeholderId))
                .into(view);
    }
    /**
     * 一般的加载,圆角,占位图
     */
    public void loadRoundeImgError(Context context,String url,ImageView view
            ,int radius,RoundedCornersTransformation.CornerType cornerType,int errorId){
        Glide.with(context).load(url)
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0,
                        cornerType)).error(errorId))
                .into(view);
    }
    /**
     * 一般的加载,圆角,占位图
     */
    public void loadRoundeImg(Context context,String url,ImageView view
            ,int radius,RoundedCornersTransformation.CornerType cornerType,int errorId,int placeholderId){
        Glide.with(context).load(url)
                .apply(bitmapTransform(new RoundedCornersTransformation(radius, 0,
                        cornerType)).placeholder(placeholderId).error(errorId))
                .into(view);
    }


    /**
     *简单加载本地图片
     */
    public void loadResource(Context context,ImageView imageView,int resourceId){
        Glide.with(context).load(resourceId).into(imageView);
    }
    /**
     *简单加载本地圆形图片
     */
    public void loadResourceCircle(Context context,ImageView imageView,int resourceId){
        RequestOptions options = new RequestOptions().circleCrop();
        Glide.with(context).load(resourceId).apply(options).into(imageView);
    }
    /**
     *简单加载本地圆形图片,占位图
     */
    public void loadResourceCircle(Context context,ImageView imageView,int resourceId,int placeholder){
        RequestOptions options = new RequestOptions().placeholder(placeholder).circleCrop();
        Glide.with(context).load(resourceId).apply(options).into(imageView);
    }

    /**
     *简单加载本地圆形图片,错误图
     */
    public void loadResourceCircleError(Context context,ImageView imageView,int resourceId,int errorId){
        RequestOptions options = new RequestOptions().error(errorId).circleCrop();
        Glide.with(context).load(resourceId).apply(options).into(imageView);
    }
    /**
     *简单加载本地圆形图片,错误图,占位图
     */
    public void loadResourceCircle(Context context,ImageView imageView,int resourceId,int errorId,int placeholderId){
        RequestOptions options = new RequestOptions().placeholder(placeholderId).error(errorId).circleCrop();
        Glide.with(context).load(resourceId).apply(options).into(imageView);
    }
    /**
     *简单加载本地图片,占位图
     */
    public void loadResource(Context context, ImageView imageView, int resourceId, int placeholderId){
        RequestOptions requestOptions = new RequestOptions().placeholder(placeholderId);
        Glide.with(context).load(resourceId).apply(requestOptions).into(imageView);
    }
    /**
     *简单加载本地图片,错误图
     */
    public void loadResourceError(Context context, ImageView imageView, int resourceId, int errorId){
        RequestOptions requestOptions = new RequestOptions().error(errorId);
        Glide.with(context).load(resourceId).apply(requestOptions).into(imageView);
    }
    /**
     *简单加载本地图片,占位图,错误图
     */
    public void loadResource(Context context, ImageView imageView,
                             int resourceId, int placeholderId,int errorId){
        RequestOptions requestOptions = new RequestOptions()
                .placeholder(placeholderId).error(errorId);
        Glide.with(context).load(resourceId).apply(requestOptions).into(imageView);
    }

    /**
     *简单加载本地图片 ,圆角
     */
    public void loadImgResourceRound(Context context,int resource,ImageView img,
                                     int round,RoundedCornersTransformation.CornerType cornerType){
        if (img!=null){
            RequestOptions requestOptions = new RequestOptions()
                    .transform(new RoundedCornersTransformation(round,0,
                            cornerType));
            Glide.with( context).load(resource).apply(requestOptions).into(img);
        }
    }

    /**清理磁盘缓存
     */
    public static void GuideClearDiskCache(Context mContext) {
        //理磁盘缓存 需要在子线程中执行
        Glide.get(mContext).clearDiskCache();
    }

    /**清理内存缓存
     */
    public static void GuideClearMemory(Context mContext) {
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(mContext).clearMemory();
    }

    /**
     * 清理所有缓存,在子线程中执行
     */
    public void clear(Context context){
        //理磁盘缓存 需要在子线程中执行
        Glide.get(context).clearDiskCache();
        //清理内存缓存  可以在UI主线程中进行
        Glide.get(context).clearMemory();
    }

}
