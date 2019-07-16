package com.mytaxi.app.dependencies.module;

import com.mytaxi.app.utils.PermissionHelper;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PermissionModule {

    @Singleton
    @Provides
    PermissionHelper providePermissionHelper() {
        return new PermissionHelper();
    }

}
