package com.example.gamis214.mvp_dagger_example;

import android.app.Application;

import com.example.gamis214.mvp_dagger_example.data.component.DaggerNetComponent;
import com.example.gamis214.mvp_dagger_example.data.component.NetComponent;
import com.example.gamis214.mvp_dagger_example.data.module.AppModule;
import com.example.gamis214.mvp_dagger_example.data.module.NetModule;

/**
 * Created by gamis214 on 19/09/17.
 */
public class MainApplication extends Application {

    private NetComponent netComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        netComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("https://jsonplaceholder.typicode.com/"))
                .build();

    }

    public NetComponent getNetComponent(){
        return this.netComponent;
    }

}
