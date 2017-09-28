package com.example.gamis214.mvp_dagger_example.data.component;

import com.example.gamis214.mvp_dagger_example.data.module.AppModule;
import com.example.gamis214.mvp_dagger_example.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by gamis214 on 19/09/17.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();

}
