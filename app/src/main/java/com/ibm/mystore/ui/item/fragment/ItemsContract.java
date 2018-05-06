package com.ibm.mystore.ui.item.fragment;

import com.ibm.mystore.data.network.model.Item;
import com.ibm.mystore.di.component.ItemComponent;
import com.ibm.mystore.ui.base.BaseContract;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by abk on 06/05/2018.
 */

public class ItemsContract {

    public interface IItemsPresenter<V extends ItemsContract.IItemsView> extends BaseContract.IMvpPresenter<V> {

    }

    public interface IItemsView extends BaseContract.IMvpView {
        void showLoading();
        void hideLoading();
        void setItems(ArrayList<Item> items);
    }

}
