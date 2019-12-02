package com.aiden.android.commons.utils;

import android.view.View;
import android.webkit.WebView;

/**
 * @author sunwei
 * 邮箱：tianmu19@gmail.com
 * 时间：2018/5/18 0018 下午 12:02
 * 包名：com.youtoo.publics
 * <p>description: 释放webview内存，销毁 (测试后：可以销毁97%左右内存)</p>
 */

public class WebViewReleaseMemoryUtil {
    private WebViewReleaseMemoryUtil() {
        throw new UnsupportedOperationException("不能初始化此类。");
    }

    public static void ReleaseMemoryAndDestory(WebView webView) {
        if (webView != null) {
            try {
                webView.stopLoading();
                webView.removeAllViews();
                webView.setDownloadListener(null);
                webView.addOnLayoutChangeListener(null);
                webView.clearHistory();
                webView.setVisibility(View.GONE);
                webView.loadUrl("about:blank");
                webView.getSettings().setJavaScriptEnabled(false);
                webView.destroy();
                webView = null;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
