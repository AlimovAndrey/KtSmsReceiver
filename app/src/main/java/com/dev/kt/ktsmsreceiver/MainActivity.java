package com.dev.kt.ktsmsreceiver;

import android.Manifest;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.dev.kt.ktsmsreceiver.utils.DeviceManager;
import com.dev.kt.ktsmsreceiver.utils.PermissionHelper;
import com.dev.kt.ktsmsreceiver.utils.SmsService;
import com.dev.kt.ktsmsreceiver.utils.StoragePref;
import com.tbruyelle.rxpermissions.RxPermissions;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.container_permission)
    View mViewPermission;

    @BindView(R.id.container_main)
    View mViewMain;

    @BindView(R.id.text_view_status)
    TextView mTextViewStatus;

    @BindView(R.id.button_disable)
    Button mButtonDisable;

    @BindView(R.id.button_enable)
    Button mButtonEnable;

    @OnClick(R.id.button_disable)
    void onClickButtonDisable() {
        stopService(new Intent(MainActivity.this, SmsService.class));
        changeViewToEnableService();
    }

    @OnClick(R.id.button_enable)
    void onClickButtonEnable() {
        Intent mServiceIntent = new Intent(MainActivity.this, SmsService.class);
        startService(mServiceIntent);

        changeViewToDisableService();
    }

    @OnClick(R.id.button_allow_permission)
    void onClickPermission() {
        askPermission();
    }

    private RxPermissions mRxPermissions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mRxPermissions = new RxPermissions(this);

        if (!PermissionHelper.hasSMSPermission(this)) {
            askPermission();
        } else {
            if (DeviceManager.isServiceRunning(this, SmsService.class)) {
                changeViewToDisableService();
            } else {
                changeViewToEnableService();
            }
        }

    }

    private void askPermission() {
        mRxPermissions
                .request(Manifest.permission.RECEIVE_SMS)
                .subscribe(granted -> {
                    if (granted) {
                        mViewPermission.setVisibility(View.GONE);
                        mViewMain.setVisibility(View.VISIBLE);
                    } else {
                        mViewPermission.setVisibility(View.VISIBLE);
                        mViewMain.setVisibility(View.GONE);
                    }
                });
    }

    // better use some kind of MVP architecture but project too small
    private void changeViewToEnableService() {
        StoragePref.setServiceStarted(MainActivity.this, false);
        mTextViewStatus.setText(getString(R.string.main_service_is_offline));

        mButtonDisable.setVisibility(View.INVISIBLE);
        mButtonEnable.setVisibility(View.VISIBLE);
    }

    private void changeViewToDisableService() {
        StoragePref.setServiceStarted(MainActivity.this, true);
        mTextViewStatus.setText(getString(R.string.main_service_is_online));

        mButtonDisable.setVisibility(View.VISIBLE);
        mButtonEnable.setVisibility(View.INVISIBLE);
    }
}











