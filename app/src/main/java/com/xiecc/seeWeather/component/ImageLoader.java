package com.xiecc.seeWeather.component;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by HugoXie on 16/4/30.
 *
 * Email: Hugo3641@gamil.com
 * GitHub: https://github.com/xcc3641
 * 图片加载类,统一适配(方便换库,方便管理)
 */
public class ImageLoader {

    public static void load(Context context, @DrawableRes int imageRes, ImageView view) {
        Glide.with(context).load(imageRes).crossFade().into(view);
    }

    public static void loadAndDiskCache(Context context, @DrawableRes int imageRes, ImageView view) {
        Glide.with(context).load(imageRes).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(view);
    }

    public static void clear(Context context){
        Observable.just(1)
            .observeOn(Schedulers.io())
            .subscribe(integer -> {
                Glide.get(context).clearMemory();
                Glide.get(context).clearDiskCache();
            });
    }
}
