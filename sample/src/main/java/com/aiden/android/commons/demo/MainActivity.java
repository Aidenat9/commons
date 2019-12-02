package com.aiden.android.commons.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.aiden.android.commons.ui.Views;
import com.aiden.android.commons.utils.ToastUtil;
import com.aiden.android.commons.utils.permission.IPermissionCallback;
import com.aiden.android.commons.utils.permission.PermissionUtils;
import com.hjq.toast.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Views.find(this, R.id.test).setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d("tag","点击");
                    }
                }
        );
        //
        ToastUtils.init(getApplication());
        PermissionUtils.getInstance().checkCameraPermission(this, new IPermissionCallback() {
            @Override
            public void onGranted() {
                ToastUtil.show("granted");
            }

            @Override
            public void onDenied() {
                ToastUtil.show("onDenied");
            }
        });
    }

}
