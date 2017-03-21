package com.dev.kt.ktsmsreceiver.utils;

import android.content.Context;

import com.dev.kt.ktsmsreceiver.R;
import com.dev.kt.ktsmsreceiver.ui.dialog.DialogListener;
import com.dev.kt.ktsmsreceiver.ui.dialog.EditDialog;

/**
 * Created by Андрей on 20.03.2017.
 */

public class DialogHelper {

    public static void showEditFtpDialog(Context context, String prev, DialogListener listener) {
        EditDialog editDialog = new EditDialog(context, prev, listener);
        editDialog.setTitle(context.getString(R.string.dialog_title_ftp));
        editDialog.show();
    }

    public static void showEditPathFtpDialog(Context context, String prev, DialogListener listener) {
        EditDialog editDialog = new EditDialog(context, prev, listener);
        editDialog.setTitle(context.getString(R.string.dialog_title_path_ftp));
        editDialog.show();
    }

    public static void showEditLoginDialog(Context context, String prev, DialogListener listener) {
        EditDialog editDialog = new EditDialog(context, prev, listener);
        editDialog.setTitle(context.getString(R.string.dialog_title_login));
        editDialog.show();
    }

    public static void showEditPasswordDialog(Context context, String prev, DialogListener listener) {
        EditDialog editDialog = new EditDialog(context, prev, listener);
        editDialog.setTitle(context.getString(R.string.dialog_title_password));
        editDialog.show();
    }

}
