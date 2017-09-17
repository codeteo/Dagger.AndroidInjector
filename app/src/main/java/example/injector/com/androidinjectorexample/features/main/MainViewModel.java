package example.injector.com.androidinjectorexample.features.main;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import timber.log.Timber;

/**
 * ViewModel for {@link MainActivity}
 */

public class MainViewModel extends ViewModel {

    @Inject
    public MainViewModel() {
        Timber.i("inject MainViewModel");
    }

    void doSomething() {
        Timber.i("Do something");
    }
}
