package com.aiden.android.commons.interfa;

/**
 * @author sunwei
 * email：tianmu19@gmail.com
 * date：2019/5/25 9:47
 * package：com.youtu.weex.interfa
 * version：1.0
 * <p>description：              </p>
 */
public interface IResultListener {
    void resultSuccess(String msg);
    void resultError(String errorMsg);
}
