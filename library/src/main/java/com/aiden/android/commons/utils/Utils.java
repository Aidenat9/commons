package com.aiden.android.commons.utils;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.TypedValue;

import java.math.BigDecimal;

/**
 * @author sunwei
 * email：tianmu19@gmail.com
 * date：2019/8/28 14:45
 * package：me.tmgg.viewsdemoapp.utils
 * version：1.0
 * <p>description：              </p>
 */
public class Utils {
    public static float dp2px(float dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, Resources.getSystem().getDisplayMetrics());
    }

    public static float getScreenHeight() {
        DisplayMetrics displayMetrics = Resources.getSystem().getDisplayMetrics();
        return displayMetrics.heightPixels;
    }

    public static Bitmap getBitmap(Resources res, int resId, int width) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, options);
        options.inJustDecodeBounds = false;
        options.inDensity = options.outWidth;
        options.inTargetDensity = width;
        return BitmapFactory.decodeResource(res, resId, options);
    }

    /**
     * 留一位小数
     * @param data
     * @return
     */
    public static String getAccurateInts(String data) {

        if (TextUtils.isEmpty(data)) {
            return "0";
        }
        BigDecimal bigDecimal = new BigDecimal(data);
        bigDecimal = bigDecimal.multiply(new BigDecimal(10));
        return bigDecimal.setScale(1, BigDecimal.ROUND_HALF_UP).toString();
    }
}
