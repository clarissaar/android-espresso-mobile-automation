package com.mytaxi.app.dependencies.module;

import android.content.Context;

import com.mytaxi.app.utils.storage.SharedPrefStorage;

import dagger.Module;
import dagger.Provides;

@Module
public class SharedPrefStorageModule {

    private Context mContext;

    public SharedPrefStorageModule(Context context) {
        mContext = context;
    }

    @Provides
    SharedPrefStorage provideSharedPrefStorage() {
        return new SharedPrefStorage(mContext);
    }

}
