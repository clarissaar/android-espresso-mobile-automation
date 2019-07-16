package com.mytaxi.app.dependencies.module;

import com.mytaxi.app.utils.network.HttpClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class NetworkModule {

    @Singleton
    @Provides
    HttpClient provideHttpClient() {
        return new HttpClient();
    }

}
