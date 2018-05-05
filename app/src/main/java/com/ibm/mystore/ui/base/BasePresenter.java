package com.ibm.mystore.ui.base;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class BasePresenter <V extends BaseContract.IMvpView> implements BaseContract.IMvpPresenter<V> {

    private V view;

    public BasePresenter() {}

    @Override
    public void onAttach(V view) {
        this.view = view;
    }

    @Override
    public void onDetach() {
        this.view = null;
    }

    @Override
    public void onViewInitialized() {

    }

}
