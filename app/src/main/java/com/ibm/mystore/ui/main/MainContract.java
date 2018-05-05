package com.ibm.mystore.ui.main;


import com.ibm.mystore.ui.base.BaseContract;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class MainContract {

    public interface IMainPresenter<V extends IMainView> extends BaseContract.IMvpPresenter<V> {

    }

    public interface IMainView extends BaseContract.IMvpView {

    }
}
