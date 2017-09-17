package example.injector.com.androidinjectorexample.dagger.builder;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;
import example.injector.com.androidinjectorexample.dagger.ActivityScope;
import example.injector.com.androidinjectorexample.features.main.MainActivity;
import example.injector.com.androidinjectorexample.features.main.dagger.modules.MainActivityModule;

@Module
public abstract class ActivityBuilderModule {

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity bindMainActivity();

}
