package com.ibm.mystore.ui.base;

import android.os.Bundle;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class BaseContract {

    public interface IMvpView {

        void showMessage(int resourceId);

        Bundle getSavedInstanceState();

    }

    public interface IMvpPresenter<V extends IMvpView> {

        void onAttach(V view);

        void onDetach();

        void onViewInitialized();

    }

}
