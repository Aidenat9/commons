package com.aiden.android.commons.utils;

import android.animation.Animator;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

import org.jetbrains.annotations.NotNull;

/**
 * @author sunwei
 * email：tianmu19@gmail.com
 * date：2019/10/29 16:32
 * package：com.youtoo.publics
 * version：1.0
 * <p>description：    揭露动画          </p>
 */
public class RevealAnimUtil {
    private static final RevealAnimUtil ourInstance = new RevealAnimUtil();

    public static RevealAnimUtil getInstance() {
        return ourInstance;
    }

    private RevealAnimUtil() {
    }

    /**
     *
     * @param revealView 揭露view
     * @param reversed 是否隐藏动画
     * @param cx 圆心x
     * @param cy 圆心y
     * @return
     */
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public Animator createRevealAnimator(@NotNull View revealView, boolean reversed, int cx, int cy,float smallRadius, Animator.AnimatorListener animatorListener) {
        float hypot = (float) Math.hypot(revealView.getHeight(), revealView.getWidth());
        float startRadius = reversed ? hypot:smallRadius;
        float endRadius = reversed ? smallRadius : hypot;
        Animator animator = ViewAnimationUtils.createCircularReveal(
                revealView, cx, cy,
                startRadius,
                endRadius);
        animator.setDuration(700);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        if (reversed)
            animator.addListener(animatorListener);
        return animator;
    }
}
