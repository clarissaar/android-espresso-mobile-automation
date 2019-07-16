package com.mytaxi.app.dependencies.component;

import com.mytaxi.app.activities.AuthenticatedActivity;
import com.mytaxi.app.activities.AuthenticationActivity;
import com.mytaxi.app.activities.MainActivity;
import com.mytaxi.app.dependencies.module.NetworkModule;
import com.mytaxi.app.dependencies.module.PermissionModule;
import com.mytaxi.app.dependencies.module.SharedPrefStorageModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class, PermissionModule.class, SharedPrefStorageModule.class})
public interface AppComponent {

    void inject(AuthenticatedActivity activity);

    void inject(MainActivity activity);

    void inject(AuthenticationActivity activity);

}
