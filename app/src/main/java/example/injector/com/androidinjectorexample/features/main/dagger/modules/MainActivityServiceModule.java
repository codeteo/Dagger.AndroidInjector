package example.injector.com.androidinjectorexample.features.main.dagger.modules;

import dagger.Module;
import dagger.Provides;
import example.injector.com.androidinjectorexample.dagger.ActivityScope;
import example.injector.com.androidinjectorexample.data.api.GithubService;
import retrofit2.Retrofit;

/**
 * Dagger Module to provide {@link GithubService}
 */

@Module
public class MainActivityServiceModule {

    @ActivityScope
    @Provides
    GithubService providesGithubService(Retrofit retrofit) {
        return retrofit.create(GithubService.class);
    }

}
