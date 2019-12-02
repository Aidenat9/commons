package com.aiden.android.commons.utils.imageloader;

import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * @author sunwei
 * email：tianmu19@gmail.com
 * date：2019/5/16 16:48
 * package：com.youtu.weex.utils.imageloader
 * version：1.0
 * <p>description：    加载图片接口          </p>
 */
public interface IImageLoader {
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl);
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int width, int height);
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int errorImage, int width, int height);
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int defaultImage, int errorImage, int width, int height);
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int defaultImage, int errorImage, int width, int height, @NonNull Object transformation);
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int errorImage, int width, int height, @NonNull Object transformation);
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int width, int height, @NonNull Object transformation);
    void load(@NonNull ImageView imageView, @NonNull Object imageUrl, @NonNull Object transformation);
}
