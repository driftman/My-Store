package com.ibm.mystore.di.component;

import android.content.Context;

import com.elbaz.mydaggerapplication.di.module.ApplicationModule;
import com.elbaz.mydaggerapplication.di.module.NetworkModule;
import com.elbaz.mydaggerapplication.di.module.UserModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by abk on 31/03/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    UserComponent plusUserComponent(UserModule userModule);
}
