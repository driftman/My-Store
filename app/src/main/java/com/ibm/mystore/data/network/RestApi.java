package com.ibm.mystore.data.network;


import com.ibm.mystore.data.network.response.ItemsResponse;

import retrofit2.http.GET;

import rx.Observable;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */
public interface RestApi {

    @GET("items")
    Observable<ItemsResponse> getItems();

}
