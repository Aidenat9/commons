package com.aiden.android.commons.utils;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * Bug：IndexOutOfBoundsException: Inconsistency detected. Invalid view holder adapter的解决方案
 * 嵌套在viewpager里面。只要对应的相邻的缓存页面有个数据为空的就会闪退，并且报这个错，100%必现
 * <p>
 * 解决方法：集合数据一旦发生改变，立马得调用notifyDataSetChanged();，我就是因为再调用list.clear(),
 * 方法后没有及时调用 notifyDataSetChanged()方法，导致的，现在已经解决，希望能给犯同样错误的小伙伴带来帮助
 */
public class WrapContentLinearLayoutManager extends LinearLayoutManager {
    public WrapContentLinearLayoutManager(Context context) {
        super(context);
    }

    public WrapContentLinearLayoutManager(Context context, int orientation, boolean reverseLayout) {
        super(context, orientation, reverseLayout);
    }

    public WrapContentLinearLayoutManager(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        try {
            super.onLayoutChildren(recycler, state);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
