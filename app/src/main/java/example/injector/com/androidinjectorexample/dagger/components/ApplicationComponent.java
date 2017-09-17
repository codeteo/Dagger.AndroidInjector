package example.injector.com.androidinjectorexample.dagger.components;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import example.injector.com.androidinjectorexample.MyApplication;
import example.injector.com.androidinjectorexample.dagger.modules.ApplicationModule;
import example.injector.com.androidinjectorexample.dagger.modules.NetworkModule;
import example.injector.com.androidinjectorexample.features.main.dagger.modules.MainActivityModule;

@Singleton
@Component( modules = {
        AndroidInjectionModule.class,
        ApplicationModule.class,
        NetworkModule.class,
        MainActivityModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(MyApplication application);

        ApplicationComponent build();
    }

}

