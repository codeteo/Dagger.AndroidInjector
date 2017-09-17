package example.injector.com.androidinjectorexample.dagger.modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import example.injector.com.androidinjectorexample.utils.BaseUrlInterceptor;
import example.injector.com.androidinjectorexample.utils.schedulers.BaseSchedulerProvider;
import example.injector.com.androidinjectorexample.utils.schedulers.SchedulerProvider;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Dagger Module with network dependencies.
 */

@Module
public class NetworkModule {

    private static final int CONNECTION_TIMEOUT = 15;

    public NetworkModule() {
    }

    @Provides
    @Singleton
    Gson providesGson() {
        return new GsonBuilder()
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttpClient(BaseUrlInterceptor baseUrlInterceptor) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        final OkHttpClient.Builder client = new OkHttpClient.Builder();
        client.retryOnConnectionFailure(true);
        client.addInterceptor(interceptor);
        client.addInterceptor(baseUrlInterceptor);
        client.connectTimeout(CONNECTION_TIMEOUT, TimeUnit.SECONDS);

        return client.build();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(HttpUrl baseUrl, OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .client(client)
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    @Provides
    @Singleton
    BaseSchedulerProvider baseSchedulerProvider() {
        return SchedulerProvider.getInstance();
    }

}
