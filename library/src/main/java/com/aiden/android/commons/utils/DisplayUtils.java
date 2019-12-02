package com.aiden.android.commons.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;

import com.aiden.android.commons.klogutil.KLog;
import com.gyf.immersionbar.ImmersionBar;

public class DisplayUtils {
    /**
     * 将px值转换为dp值
     */
    public static int px2dp(float pxValue) {
        final float scale = Resources.getSystem().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dp值转换为px值
     */
    public static float dp2px(float dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpValue, Resources.getSystem().getDisplayMetrics());
    }
    /**
     * 将px值转换为sp值
     */
    public static int px2sp( float pxValue) {
        final float fontScale = Resources.getSystem().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / fontScale + 0.5f);
    }

    /**
     * 将sp值转换为px值
     */
    public static float sp2px(float dpValue) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, dpValue, Resources.getSystem().getDisplayMetrics());
    }
    public static int getScreenWidth(Context context) {
        return context.getApplicationContext().getResources().getDisplayMetrics().widthPixels;
    }

    /**
     * 获取屏幕宽度
     */
    public static int getScreenWidthPixels(Activity context) {
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        KLog.e("屏幕宽度getWindowManager：" + metric.widthPixels);
        return metric.widthPixels;
    }

    public static int getScreenWidthPixel(Context context) {
        Resources resources = context.getApplicationContext().getResources();
        DisplayMetrics dm = resources.getDisplayMetrics();
        int width3 = dm.widthPixels;
        KLog.e("屏幕宽度resources：" + width3);
        return width3;
    }

    /**
     * 获取屏幕高度
     */
    public static int getScreenHeightPixels(Activity context) {
        int screenHeight = 0;
        DisplayMetrics metric = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(metric);
        boolean b = ImmersionBar.hasNavigationBar(context);
        if (b) {
            screenHeight = metric.heightPixels + ImmersionBar.getNavigationBarHeight(context) + 13;
            KLog.e("导航栏高度：" + ImmersionBar.getNavigationBarHeight(context));
        } else {
            screenHeight = metric.heightPixels;
        }
        KLog.e("屏幕高度：" + screenHeight);
        return screenHeight;
    }

    public static int getDisplayHeight(Activity context) {
        //获取正确尺寸 （此方法要求最低api为17，即安卓4.2，4.2之前获取请参看以下获取屏幕尺寸的方法）
        //此种必须在继承了window的布局中获取才能得到值
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            Point point = new Point();
            WindowManager windowManager = context.getWindowManager();
            windowManager.getDefaultDisplay().getSize(point);
            windowManager.getDefaultDisplay().getRealSize(point);
            KLog.e("屏幕真实宽高w：" + point.x + " h:" + point.y);
            return point.y;
        } else {
            //无刘海屏及导航栏手机，直接获取高度
            DisplayMetrics metric = context.getResources().getDisplayMetrics();
            KLog.e("屏幕：" + metric.heightPixels);
            KLog.e("屏幕：" + metric.widthPixels);
            return metric.heightPixels;
        }
    }


    /**
     * 判断是否是全面屏
     */
    private volatile static boolean mHasCheckAllScreen;
    private volatile static boolean mIsAllScreenDevice;

    public static boolean isAllScreenDevice(Context context) {
        if (mHasCheckAllScreen) {
            return mIsAllScreenDevice;
        }
        mHasCheckAllScreen = true;
        mIsAllScreenDevice = false;
        // 低于 API 21的，都不会是全面屏。。。
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            return false;
        }
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        if (windowManager != null) {
            Display display = windowManager.getDefaultDisplay();
            Point point = new Point();
            display.getRealSize(point);
            float width, height;
            if (point.x < point.y) {
                width = point.x;
                height = point.y;
            } else {
                width = point.y;
                height = point.x;
            }
            if (height / width >= 1.97f) {
                mIsAllScreenDevice = true;
            }
        }
        return mIsAllScreenDevice;
    }

}
