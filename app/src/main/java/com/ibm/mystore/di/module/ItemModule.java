package com.ibm.mystore.di.module;

import android.content.Context;

import com.ibm.mystore.data.network.ItemService;
import com.ibm.mystore.data.network.RestApi;
import com.ibm.mystore.di.ItemsScope;
import com.ibm.mystore.ui.item.adapter.ItemsAdapter;
import com.ibm.mystore.ui.item.fragment.ItemsContract;
import com.ibm.mystore.ui.item.fragment.ItemsPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */


@Module
public class ItemModule {

    @Provides @ItemsScope ItemService provideUserService(Retrofit retrofit) {
        return new ItemService(retrofit.create(RestApi.class));
    }

    @Provides @ItemsScope ItemsContract.IItemsPresenter provideMainPresenter(ItemService service) {
        return new ItemsPresenter(service);
    }

}
