package com.ibm.mystore.di.module;

import com.ibm.mystore.data.network.ItemService;
import com.ibm.mystore.data.network.RestApi;
import com.ibm.mystore.di.ItemsScope;
import com.ibm.mystore.ui.item.ItemContract;
import com.ibm.mystore.ui.item.ItemPresenter;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */


@Module
public class ItemModule {


    public ItemModule() {}

    @Provides @ItemsScope
    public ItemService provideUserService(Retrofit retrofit) {
        return new ItemService(retrofit.create(RestApi.class));
    }

    @Provides @ItemsScope
    ItemContract.IItemPresenter provideMainPresenter(ItemService service) {
        return new ItemPresenter(service);
    }

}
