package example.injector.com.androidinjectorexample.features.main.dagger.modules;

import android.arch.lifecycle.ViewModelProvider;

import dagger.Module;
import dagger.Provides;
import example.injector.com.androidinjectorexample.ViewModelProviderFactory;
import example.injector.com.androidinjectorexample.dagger.ActivityScope;
import example.injector.com.androidinjectorexample.data.api.GithubService;
import example.injector.com.androidinjectorexample.features.main.MainViewModel;

@Module
public class MainActivityModule {

    @Provides
    @ActivityScope
    MainViewModel providesMainViewModel(GithubService service) {
        return new MainViewModel(service);
    }

    @Provides
    @ActivityScope
    ViewModelProvider.Factory providesMainViewModelProvider(MainViewModel mainViewModel) {
        return new ViewModelProviderFactory<>(mainViewModel);
    }

}
