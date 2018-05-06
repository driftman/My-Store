package com.ibm.mystore.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.ibm.mystore.R;


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
    public void showMessage(int resourceId) {
        showToast(getString(resourceId));
    }

    private void showToast(String msg) {
        Toast.makeText(getApplicationContext(), TAG + ": " + msg, Toast.LENGTH_LONG)
                .show();
    }
}
