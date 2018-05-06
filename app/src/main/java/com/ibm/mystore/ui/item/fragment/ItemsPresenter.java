package com.ibm.mystore.ui.item.fragment;

import android.os.Bundle;

import com.ibm.mystore.R;
import com.ibm.mystore.data.network.ItemService;
import com.ibm.mystore.data.network.model.Item;
import com.ibm.mystore.data.network.response.ItemsResponse;

import java.util.ArrayList;
import java.util.List;

import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class ItemsPresenter<V extends ItemsContract.IItemsView> implements ItemsContract.IItemsPresenter<V> {

    private ItemService service;

    private Subscription subscription;

    private V view;

    public ItemsPresenter(ItemService service) {
        this.service = service;
    }

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
        // Check if we already have saved instance state holding a previously loaded
        // list of items
        Bundle bundle = view.getSavedInstanceState();
        if(bundle != null && bundle.get(ItemsFragment.ITEMS) != null) {
            ArrayList<Item> items = bundle.getParcelableArrayList(ItemsFragment.ITEMS);
            view.setItems(items);
        } else {
            subscription = service.getItems()
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Subscriber<ItemsResponse>() {

                        @Override
                        public void onCompleted() {
                            // completed ...
                        }

                        @Override
                        public void onError(Throwable e) {
                            view.showMessage(R.string.network_error);
                        }

                        @Override
                        public void onNext(ItemsResponse itemsResponse) {
                            if(itemsResponse != null && itemsResponse.getData() != null) {
                                view.setItems(itemsResponse.getData());
                            } else {
                                view.showMessage(R.string.network_error);
                            }
                        }

                    });
        }
    }
}
