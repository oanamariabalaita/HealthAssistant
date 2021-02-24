package com.example.healthassistant.core.di.modules;

import com.example.healthassistant.presentation.MainActivity;
import com.example.healthassistant.presentation.di.modules.FragmentBuildersModule;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainActivityModule_ContributeMainActivity.MainActivitySubcomponent.class)
public abstract class MainActivityModule_ContributeMainActivity {
    private MainActivityModule_ContributeMainActivity() {
    }

    @Binds
    @IntoMap
    @ClassKey(MainActivity.class)
    abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
            MainActivitySubcomponent.Factory builder);

    @Subcomponent(modules = FragmentBuildersModule.class)
    public interface MainActivitySubcomponent extends AndroidInjector<MainActivity> {
        @Subcomponent.Factory
        interface Factory extends AndroidInjector.Factory<MainActivity> {
        }
    }
}
