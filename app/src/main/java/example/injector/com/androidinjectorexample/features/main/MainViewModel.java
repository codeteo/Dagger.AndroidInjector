package example.injector.com.androidinjectorexample.features.main;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import example.injector.com.androidinjectorexample.data.api.GithubService;
import timber.log.Timber;

/**
 * ViewModel for {@link MainActivity}
 */

public class MainViewModel extends ViewModel {

    private GithubService service;

    @Inject
    public MainViewModel(GithubService service) {
        this.service = service;
        Timber.i("inject MainViewModel");
    }

    void doSomething() {
        Timber.i("Do something");
    }
}
