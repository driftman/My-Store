package com.ibm.mystore.di.module;

import com.ibm.mystore.data.network.MyStoreInterceptor;

import java.io.File;
import java.io.IOException;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

@Module
public class NetworkModule {

    private Cache cache;

    public NetworkModule(File cacheFile) {
        this.cache = new Cache(cacheFile, 10 * 1024 * 1024);
    }

    @Provides @Singleton String provideBaseUrl() {
        return "https://ws.ibm.com/";
    }

    @Provides @Singleton MyStoreInterceptor provideInterceptor() {
        return new MyStoreInterceptor();
    }

    @Provides @Singleton OkHttpClient provideOkHttpClient(MyStoreInterceptor interceptor) {
        return new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(interceptor)
                .build();
    }

    @Provides @Singleton GsonConverterFactory provideGSONConverterFactory() {
        return GsonConverterFactory.create();
    }

    @Provides @Singleton RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory() {
        return RxJavaCallAdapterFactory.create();
    }

    @Provides @Singleton Retrofit provideRetrofit(String baseUrl,
                                                   OkHttpClient client,
                                                   GsonConverterFactory gson,
                                                   RxJavaCallAdapterFactory rxJava) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(client)
                .addConverterFactory(gson)
                .addCallAdapterFactory(rxJava)
                .build();

    }

}
