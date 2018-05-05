package com.ibm.mystore.di.module;

import android.content.Context;

import com.ibm.mystore.MainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Soufiane ELBAZ on 05/05/2018.
 */

@Module
public class ApplicationModule {

    private final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides @Singleton Context provideApplication() {
        return this.application;
    }
}
