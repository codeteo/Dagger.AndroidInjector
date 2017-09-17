package example.injector.com.androidinjectorexample.dagger.modules;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.injector.com.androidinjectorexample.Constants;
import example.injector.com.androidinjectorexample.utils.BaseUrlInterceptor;
import okhttp3.HttpUrl;

@Module()
public class ApplicationModule {

    private static final HttpUrl PRODUCTION_API_BASE_URL = HttpUrl.parse(Constants.BASE_URL);

    @Provides
    @Singleton
    Context providesContext(Application application) {
        return application;
    }

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    HttpUrl providesBaseUrl() {
        return PRODUCTION_API_BASE_URL;
    }

    @Provides
    @Singleton
    static BaseUrlInterceptor providesBaseUrlInterceptor() {
        return new BaseUrlInterceptor(Constants.BASE_URL);
    }

}
