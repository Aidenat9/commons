package com.aiden.android.commons.utils;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SimpleItemAnimator;

/**
 * @author sunwei
 * 邮箱：tianmu19@gmail.com
 * 时间：2018/11/11 21:48
 * 包名：com.youtoo.housekeeper.utils
 * <p>description:            </p>
 */
public class RecyclerViewAnimUtil {
    private static final RecyclerViewAnimUtil ourInstance = new RecyclerViewAnimUtil();

    public static RecyclerViewAnimUtil getInstance() {
        return ourInstance;
    }

    private RecyclerViewAnimUtil() {
    }
    /**
     * 关闭默认局部刷新动画
     */
    public void closeDefaultAnimator(RecyclerView mRvCustomer) {
        if(null==mRvCustomer)return;
        try {
            mRvCustomer.getItemAnimator().setAddDuration(0);
            mRvCustomer.getItemAnimator().setChangeDuration(0);
            mRvCustomer.getItemAnimator().setMoveDuration(0);
            mRvCustomer.getItemAnimator().setRemoveDuration(0);
            ((SimpleItemAnimator) mRvCustomer.getItemAnimator()).setSupportsChangeAnimations(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
