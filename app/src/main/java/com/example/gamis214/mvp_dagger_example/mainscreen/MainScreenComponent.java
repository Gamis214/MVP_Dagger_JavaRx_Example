package com.example.gamis214.mvp_dagger_example.mainscreen;




import com.example.gamis214.mvp_dagger_example.data.component.NetComponent;
import com.example.gamis214.mvp_dagger_example.utils.CustomScope;

import dagger.Component;

/**
 * Created by Aditya on 11-May-16.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject(MainActivity activity);
}
