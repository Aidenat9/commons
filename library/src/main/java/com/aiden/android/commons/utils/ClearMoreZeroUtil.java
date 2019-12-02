package com.aiden.android.commons.utils;

import android.text.TextUtils;

import java.math.BigDecimal;

/**
 * @author sunwei
 *         邮箱：tianmu19@gmail.com
 *         时间：2018/11/29 9:15
 *         包名：com.youtoo.publics
 *         <p>description:   去除多余的0         </p>
 */

public class ClearMoreZeroUtil {
    private static String res;

    public static String subZeroAndDot(String s) {
        try {
            if (s.indexOf(".") > 0) {
                s = s.replaceAll("0+?$", "");//去掉多余的0
                s = s.replaceAll("[.]$", "");//如最后一位是.则去掉
            }
        } catch (Exception e) {
            e.printStackTrace();
            return s;
        }
        return s;
    }

    /**
     * 四舍五入
     *
     * @param decimalPointNum 小数位数
     * @return
     */
    public static String getDecimal(String s, int decimalPointNum) {
        if (TextUtils.isEmpty(s)) {
            return "0";
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(s);
            res = bigDecimal.setScale(decimalPointNum, BigDecimal.ROUND_HALF_UP).toString();
        } catch (Exception e) {
            e.printStackTrace();
            return s;
        }
        return res;
    }
}
