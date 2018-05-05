package com.ibm.mystore.data.network;

import com.ibm.mystore.data.network.response.ItemsResponse;

import rx.Observable;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class ItemService {

    private final RestApi restApi;

    public ItemService(RestApi restApi) {
        this.restApi = restApi;
    }

    public Observable<ItemsResponse> getItems() {
        return restApi.getItems();
    }

}
