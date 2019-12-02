package com.aiden.android.commons.utils;

import android.view.Gravity;

import com.hjq.toast.IToastStyle;
import com.hjq.toast.ToastUtils;

/**
 * TODO: 2018/11/2 解决重复toast问题
 */

/**
 * @author sunwei
 * email：tianmu19@gmail.com
 * date：2019/12/2 16:31
 * version：1.0
 * <p>description：记得要初始化   </p>
 *         ToastUtils.init(getApplication());
 */

public class ToastUtil {

    public static void show(String msg){
        ToastUtils.initStyle(new DefaultToastStyle());
        ToastUtils.show(msg);
    }
    public static void showCenter(String msg){
        ToastUtils.initStyle(new CenterToastStyle());
        ToastUtils.show(msg);
    }

    private static class DefaultToastStyle implements IToastStyle {

        @Override
        public int getGravity() {
            return Gravity.BOTTOM;
        }

        @Override
        public int getXOffset() {
            return 0;
        }

        @Override
        public int getYOffset() {
            int offSetY = (int) DisplayUtils.dp2px(64);
            if(offSetY<100)offSetY = 128;
            return offSetY;
        }

        @Override
        public int getZ() {
            return 3;
        }

        @Override
        public int getCornerRadius() {
            return 2;
        }

        @Override
        public int getBackgroundColor() {
            return 0Xe0333333;
        }

        @Override
        public int getTextColor() {
            return 0XFFFFFFFF;
        }

        @Override
        public float getTextSize() {
            return 15;
        }

        @Override
        public int getMaxLines() {
            return 2;
        }

        @Override
        public int getPaddingLeft() {
            return 15;
        }

        @Override
        public int getPaddingTop() {
            return 7;
        }

        @Override
        public int getPaddingRight() {
            return 15;
        }

        @Override
        public int getPaddingBottom() {
            return 7;
        }
    }
    private static class CenterToastStyle implements IToastStyle {

        @Override
        public int getGravity() {
            return Gravity.BOTTOM;
        }

        @Override
        public int getXOffset() {
            return 0;
        }

        @Override
        public int getYOffset() {
            int offSetY = (int) DisplayUtils.dp2px(64);
            if(offSetY<100)offSetY = 128;
            return offSetY;
        }

        @Override
        public int getZ() {
            return 3;
        }

        @Override
        public int getCornerRadius() {
            return 2;
        }

        @Override
        public int getBackgroundColor() {
            return 0Xe0333333;
        }

        @Override
        public int getTextColor() {
            return 0XFFFFFFFF;
        }

        @Override
        public float getTextSize() {
            return 15;
        }

        @Override
        public int getMaxLines() {
            return 2;
        }

        @Override
        public int getPaddingLeft() {
            return 15;
        }

        @Override
        public int getPaddingTop() {
            return 7;
        }

        @Override
        public int getPaddingRight() {
            return 15;
        }

        @Override
        public int getPaddingBottom() {
            return 7;
        }
    }
}
