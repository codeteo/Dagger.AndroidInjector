package example.injector.com.androidinjectorexample.features.main.dagger.components;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import example.injector.com.androidinjectorexample.dagger.ActivityScope;
import example.injector.com.androidinjectorexample.features.main.MainActivity;
import example.injector.com.androidinjectorexample.features.main.dagger.modules.MainActivityModule;

@ActivityScope
@Subcomponent(modules = MainActivityModule.class)
public interface MainActivitySubComponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    public abstract class Builder extends AndroidInjector.Builder<MainActivity> {
    }

}
