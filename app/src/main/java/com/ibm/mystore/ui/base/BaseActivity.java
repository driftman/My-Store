package com.ibm.mystore.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;


/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseContract.IMvpView {

    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void showMessage(String msg) {
        showToast(msg);
    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), TAG + ": " + msg, Toast.LENGTH_LONG)
                .show();
    }
}
