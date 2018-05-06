package com.ibm.mystore.ui.item.fragment;

import com.ibm.mystore.data.network.ItemService;
import com.ibm.mystore.data.network.response.ItemsResponse;

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
        subscription = service.getItems()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ItemsResponse>() {

                    @Override
                    public void onCompleted() {
                        //
                    }

                    @Override
                    public void onError(Throwable e) {
                        view.showMessage("Error : " + e.getMessage());
                    }

                    @Override
                    public void onNext(ItemsResponse itemsResponse) {
                        if(itemsResponse != null) {

                        } else {

                        }
                    }

                });
    }
}
