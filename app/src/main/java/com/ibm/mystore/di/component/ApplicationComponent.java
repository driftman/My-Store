package com.ibm.mystore.di.component;

import com.ibm.mystore.di.module.ApplicationModule;
import com.ibm.mystore.di.module.ItemModule;
import com.ibm.mystore.di.module.NetworkModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by abk on 31/03/2018.
 */

@Singleton
@Component(modules = {ApplicationModule.class, NetworkModule.class})
public interface ApplicationComponent {

    ItemComponent plusItemComponent(ItemModule itemModule);

}
