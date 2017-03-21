package com.dev.kt.ktsmsreceiver.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

import com.dev.kt.ktsmsreceiver.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Андрей on 20.03.2017.
 */

public class EditDialog extends Dialog {

    @BindView(R.id.text_view_title)
    TextView mTextViewTitle;

    @BindView(R.id.edit_text_input)
    EditText mEditTextInput;

    private DialogListener mListener;

    private String mTitle;
    private String mContent;

    public EditDialog(Context context, String content, DialogListener listener) {
        super(context);
        this.mContent = content;
        this.mListener = listener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_edit_text);
        ButterKnife.bind(this);

        mEditTextInput.setText(mContent);

        if (mTitle != null && mTitle.length() != 0) {
            mTextViewTitle.setText(mTitle);
        }

    }

    @OnClick({R.id.button_cancel, R.id.button_save})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_cancel:
                dismiss();
                break;
            case R.id.button_save:
                String note = mEditTextInput.getText().toString().trim();
                if (validate(note)) {
                    mListener.onSuccess(note);
                    dismiss();
                } else {
                    mEditTextInput.setError("Incorrect value");
                }
                break;
        }
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    private boolean validate(String note) {
        if (note != null && !note.equals("") && note.length() > 0 ) {
            return true;
        }
        return false;
    }
}








