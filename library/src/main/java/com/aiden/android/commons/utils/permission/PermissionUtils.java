package com.aiden.android.commons.utils.permission;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;

import com.aiden.android.commons.R;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Permission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author sunwei
 *         邮箱：tianmu19@gmail.com
 *         时间：2019/1/10 10:35
 *         包名：com.github.tianmu19.baselibrary.utils.permission
 *         <p>description:    权限判断类        </p>
 */

public class PermissionUtils {
    private static final PermissionUtils ourInstance = new PermissionUtils();

    public static PermissionUtils getInstance() {
        return ourInstance;
    }

    private PermissionUtils() {
    }

    /**
     * 存储
     */
    public void checkStoragePermission(Context context, @NonNull final IPermissionCallback callback) {
        checkXPermission(context, callback, Permission.Group.STORAGE);
    }

    /**
     * 相机
     */
    public void checkCameraPermission(Context context, @NonNull final IPermissionCallback callback) {
        checkXPermission(context, callback, Permission.CAMERA);
    }

    /**
     * location
     */
    public void checkLocationPermission(Context context, @NonNull final IPermissionCallback callback) {
        checkXPermission(context, callback, Permission.Group.LOCATION);
    }

    /**
     * 电话
     */
    public void checkCallPermission(Context context, @NonNull  final IPermissionCallback callback) {
        checkXPermission(context, callback, Permission.CALL_PHONE);
    }

    /**
     * 手机imei
     */
    public void checkPhoneStatePermission(Context context, @NonNull final IPermissionCallback callback) {
        checkXPermission(context, callback, Permission.READ_PHONE_STATE);
    }

    /**
     * 单个权限
     */
    private void checkXPermission(final Context context, final IPermissionCallback callback, String... groups) {
        if (null == context) return;
        AndPermission.with(context).runtime()
                .permission(groups)
                .rationale(new Rationale<List<String>>() {
                    @Override
                    public void showRationale(Context context, List<String> data, final RequestExecutor executor) {
                        //tip
                        List<String> permissionNames = Permission.transformText(context, data);
                        String permissionText = TextUtils.join(",", permissionNames);
                        String please_open_permission = context.getResources().getString(R.string.you_haved_denied_permission_recently);
                        String targetTips = String.format(please_open_permission, permissionText);
                        SpannableString spannableString = formatTips(context, targetTips);
                        AlertDialog.Builder builder = new AlertDialog.Builder(context);
                        builder.setTitle(context.getResources().getString(R.string.title_tip)).setMessage(spannableString)
                                .setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        executor.execute();
                                    }
                                })
                                .setNegativeButton(context.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        executor.cancel();
                                    }
                                }).setCancelable(false).show();
                    }
                })
                .onGranted(new Action<List<String>>() {
                    @Override
                    public void onAction(List<String> data) {
                        if (null != callback) {
                            callback.onGranted();
                        }
                    }
                }).onDenied(new Action<List<String>>() {
            @Override
            public void onAction(List<String> deniedPermissions) {
                if (AndPermission.hasAlwaysDeniedPermission(context, deniedPermissions)) {
                    //tip
                    List<String> permissionNames = Permission.transformText(context, deniedPermissions);
                    String permissionText = TextUtils.join(",", permissionNames);
                    String please_open_permission = context.getResources().getString(R.string.please_open_these_permissions);
                    String targetTips = String.format(please_open_permission, permissionText);
                    SpannableString spannableString = formatTips(context, targetTips);
                    // 这些权限被用户总是拒绝。
                    AlertDialog.Builder builder = new AlertDialog.Builder(context);
                    builder.setTitle(context.getResources().getString(R.string.title_tip)).setMessage(spannableString)
                            .setPositiveButton(context.getResources().getString(R.string.ok), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    try {
                                        gotoAppDetailIntent((Activity) context);
                                    } catch (Exception e) {
                                        e.printStackTrace();
                                    }
                                    dialog.dismiss();
                                }
                            })
                            .setNegativeButton(context.getResources().getString(R.string.cancel), new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            }).setCancelable(false).show();
                }
                if (null != callback) {
                    callback.onDenied();
                }
            }
        }).start();

    }
    /**
     * 跳转到应用详情界面
     */
    public static void gotoAppDetailIntent(Activity activity) {
        Intent intent = new Intent();
        intent.setAction(android.provider.Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
        intent.setData(Uri.parse("package:" + activity.getPackageName()));
        activity.startActivity(intent);
    }

    private SpannableString formatTips(Context context, String targetTips) {
        SpannableString spannableString = new SpannableString(targetTips);
        spannableString.setSpan(new ForegroundColorSpan(context.getResources().getColor(R.color.color_permissions))
                , targetTips.indexOf("["), targetTips.indexOf("]") + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new StyleSpan(android.graphics.Typeface.BOLD)
                , targetTips.indexOf("["), targetTips.indexOf("]") + 1, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        return spannableString;
    }

    /**
     * 权限组
     */
    private void checkXPermission(Context context, final IPermissionCallback callback, String[]... groups) {
        if (null == context) return;
        List<String> permissionList = new ArrayList<>();
        for (String[] group : groups) {
            permissionList.addAll(Arrays.asList(group));
        }
        String[] permissions = permissionList.toArray(new String[permissionList.size()]);
        checkXPermission(context, callback, permissions);
    }

}
