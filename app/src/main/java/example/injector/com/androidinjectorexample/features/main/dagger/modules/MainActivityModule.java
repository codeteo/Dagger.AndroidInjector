package example.injector.com.androidinjectorexample.features.main.dagger.modules;

import android.app.Activity;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;
import example.injector.com.androidinjectorexample.features.main.MainActivity;
import example.injector.com.androidinjectorexample.features.main.dagger.components.MainActivitySubComponent;

@Module(subcomponents = MainActivitySubComponent.class)
public abstract class MainActivityModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
        bindMainActivityInjectorFactory(MainActivitySubComponent.Builder builder);

}
