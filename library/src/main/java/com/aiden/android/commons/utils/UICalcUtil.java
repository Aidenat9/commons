package com.aiden.android.commons.utils;

import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @author sunwei
 * email：tianmu19@gmail.com
 * date：2019/6/22 19:28
 * package：com.youtoo.publics
 * version：1.0
 * <p>description：              </p>
 */
public final class UICalcUtil {

    public static float dp2px(float dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }
    public static float sp2px(float dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dpValue, Resources.getSystem().getDisplayMetrics());
    }

    public static int getScreenWidth(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 屏幕宽度剩下距离
     */
    public static float getScreenWidthRemain(Context context, float minusDp) {
        float density = context.getApplicationContext().getResources().getDisplayMetrics().density;
        return (float) (getScreenWidth(context) - (minusDp * density + 0.5));
    }

    /**
     * 得到距离的比例的结果
     *
     * @param ratio    比例
     * @param distance 距离
     * @return
     */
    public static float getRatioDistance(float ratio, float distance) {
        if (ratio == 0f || distance == 0f) {
            return 0.0f;
        }
        return ratio * distance;
    }

}
