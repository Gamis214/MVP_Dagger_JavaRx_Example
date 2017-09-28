package com.example.gamis214.mvp_dagger_example.mainscreen;

import com.example.gamis214.mvp_dagger_example.utils.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aditya on 11-May-16.
 */
@Module
public class MainScreenModule {
    private final MainScreenContract.View mView;


    public MainScreenModule(MainScreenContract.View mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mView;
    }
}
