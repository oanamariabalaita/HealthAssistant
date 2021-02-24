package com.example.healthassistant.core.di.modules;

import com.example.healthassistant.presentation.di.PerFragment;
import com.example.healthassistant.presentation.features.intro.IntroFragment;

import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
        subcomponents = FragmentBuildersModule_ContributeIntroFragment.IntroFragmentSubcomponent.class
)
public abstract class FragmentBuildersModule_ContributeIntroFragment {
  private FragmentBuildersModule_ContributeIntroFragment() {
  }

  @Binds
  @IntoMap
  @ClassKey(IntroFragment.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
          IntroFragmentSubcomponent.Factory builder);

  @Subcomponent
  @PerFragment
  public interface IntroFragmentSubcomponent extends AndroidInjector<IntroFragment> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<IntroFragment> {
    }
  }
}
