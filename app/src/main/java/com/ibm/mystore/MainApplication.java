package com.ibm.mystore;

import android.app.Application;

import com.ibm.mystore.di.component.ApplicationComponent;
import com.ibm.mystore.di.component.DaggerApplicationComponent;
import com.ibm.mystore.di.component.ItemComponent;
import com.ibm.mystore.di.module.ApplicationModule;
import com.ibm.mystore.di.module.ItemModule;
import com.ibm.mystore.di.module.NetworkModule;

import java.io.File;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

public class MainApplication extends Application {


    ApplicationComponent applicationComponent;
    ItemComponent itemComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initApplicationComponent();
    }

    private void initApplicationComponent() {
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .networkModule(new NetworkModule(new File(getCacheDir(), "responses")))
                .build();

    }

    public ItemComponent plusItemComponent() {
        if(itemComponent == null) {
            itemComponent = applicationComponent
                    .plusItemComponent(new ItemModule());
        }
        return itemComponent;
    }


}
