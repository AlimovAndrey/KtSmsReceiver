package com.dev.kt.ktsmsreceiver.ui;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import com.dev.kt.ktsmsreceiver.R;
import com.dev.kt.ktsmsreceiver.utils.DialogHelper;
import com.dev.kt.ktsmsreceiver.utils.StoragePref;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SettingsActivity extends AppCompatActivity {

    @BindView(R.id.text_view_ftp)
    TextView mTextViewFtp;

    @BindView(R.id.text_view_path_ftp)
    TextView mTextViewPathFtp;

    @BindView(R.id.text_view_login)
    TextView mTextViewLogin;

    @BindView(R.id.text_view_password)
    TextView mTextViewPassword;

    @BindView(R.id.checkbox_password)
    CheckBox mCheckBoxPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        ButterKnife.bind(this);

        setTitle(getString(R.string.settings_title));

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        mTextViewFtp.setText(StoragePref.getHostName());
        mTextViewPathFtp.setText(StoragePref.getPath());
        mTextViewLogin.setText(StoragePref.getLogin());
        mTextViewPassword.setText(StoragePref.getPassword());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick({R.id.container_ftp,
            R.id.container_path_ftp,
            R.id.container_login,
            R.id.container_password,
            R.id.checkbox_password})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.container_ftp:
                DialogHelper.showEditFtpDialog(SettingsActivity.this, StoragePref.getHostName(),
                        note -> {
                            StoragePref.setHostName(note);
                            mTextViewFtp.setText(note);
                        });
                break;
            case R.id.container_path_ftp:
                DialogHelper.showEditPathFtpDialog(SettingsActivity.this, StoragePref.getPath(),
                        note -> {
                            StoragePref.setPath(note);
                            mTextViewPathFtp.setText(note);
                        });
                break;
            case R.id.container_login:
                DialogHelper.showEditLoginDialog(SettingsActivity.this, StoragePref.getLogin(),
                        note -> {
                            StoragePref.setLogin(note);
                            mTextViewLogin.setText(note);
                        });
                break;
            case R.id.container_password:
                DialogHelper.showEditPasswordDialog(SettingsActivity.this, StoragePref.getPassword(),
                        note -> {
                            StoragePref.setPassword(note);
                            mTextViewPassword.setText(note);
                        });
                break;
            case R.id.checkbox_password:
                if (mCheckBoxPassword.isChecked()) {
                    mTextViewPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    mTextViewPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                break;
        }
    }
}
