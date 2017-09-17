package example.injector.com.androidinjectorexample.dagger.components;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjectionModule;
import example.injector.com.androidinjectorexample.MyApplication;
import example.injector.com.androidinjectorexample.dagger.builder.ActivityBuilderModule;
import example.injector.com.androidinjectorexample.dagger.modules.ApplicationModule;
import example.injector.com.androidinjectorexample.dagger.modules.NetworkModule;

@Singleton
@Component( modules = {
        AndroidInjectionModule.class,
        ActivityBuilderModule.class,
        ApplicationModule.class,
        NetworkModule.class})
public interface ApplicationComponent {

    void inject(MyApplication application);

    @Component.Builder
    interface Builder {

        @BindsInstance
        Builder application(MyApplication application);

        ApplicationComponent build();
    }

}

