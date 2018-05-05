package com.ibm.mystore.ui.item;

import com.ibm.mystore.data.network.model.Item;
import com.ibm.mystore.ui.base.BaseContract;

import java.util.List;

/**
 * Created by abk on 05/05/2018.
 */

public class ItemContract {

    public interface IItemPresenter<V extends IItemView> extends BaseContract.IMvpPresenter<V> {

    }

    public interface IItemView extends BaseContract.IMvpView {
        void setItems(List<Item> items);
    }
}
