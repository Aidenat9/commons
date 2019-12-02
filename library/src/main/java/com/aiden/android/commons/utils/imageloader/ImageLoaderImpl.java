package com.aiden.android.commons.utils.imageloader;

import android.support.annotation.NonNull;
import android.widget.ImageView;

/**
 * @author sunwei
 * email：tianmu19@gmail.com
 * date：2019/5/16 16:56
 * package：com.youtu.weex.utils.imageloader
 * version：1.0
 * <p>description：     加载图片器实现类,记得在app初始化         </p>
 * 记住在app中初始化  ImageLoaderImpl.init(new IImageLoader() {
 *             @Override
 *             public void load
 */
public class ImageLoaderImpl implements IImageLoader{

    private static IImageLoader imageLoader;
    private static ImageLoaderImpl imageLoaderImpl;

    public static void init(IImageLoader imageLoader2){
        imageLoader = imageLoader2;

    }

    private ImageLoaderImpl() {
    }

    public static ImageLoaderImpl getInstance() {
        if (imageLoader == null) {
            throw new NullPointerException("必须在入口初始化imageLoader加载器引擎");
        }
        if(null==imageLoaderImpl){
            synchronized (ImageLoaderImpl.class){
                if(null==imageLoaderImpl) {
                    imageLoaderImpl = new ImageLoaderImpl();
                }
            }
        }
        return imageLoaderImpl;
    }



    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl) {
        imageLoader.load(imageView,imageUrl);
    }

    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int width, int height) {
        imageLoader.load(imageView,imageUrl,width,height);
    }

    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int errorImage, int width, int height) {
        imageLoader.load(imageView,imageUrl,errorImage,width,height);
    }

    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int defaultImage, int errorImage, int width, int height) {
        imageLoader.load(imageView,imageUrl,defaultImage,errorImage,width,height);
    }

    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int defaultImage, int errorImage, int width, int height, @NonNull Object transformation) {
        imageLoader.load(imageView,imageUrl,defaultImage,errorImage,width,height,transformation);
    }

    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int errorImage, int width, int height, @NonNull Object transformation) {
        imageLoader.load(imageView,imageUrl,errorImage,width,height,transformation);
    }

    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl, int width, int height, @NonNull Object transformation) {
        imageLoader.load(imageView,imageUrl,width,height,transformation);
    }

    @Override
    public void load(@NonNull ImageView imageView, @NonNull Object imageUrl, @NonNull Object transformation) {
        imageLoader.load(imageView,imageUrl,transformation);
    }
}
