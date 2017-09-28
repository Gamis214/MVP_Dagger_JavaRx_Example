package com.example.gamis214.mvp_dagger_example.data.module;

import android.content.Context;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by gamis214 on 19/09/17.
 */
@Module
public class AppModule {

    Context application;

    public AppModule(Context application){
        this.application = application;
    }

    @Provides
    @Singleton
    Context provideApplication(){
        return this.application;
    }

}
