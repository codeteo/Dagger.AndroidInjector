package example.injector.com.androidinjectorexample.features.main;

import android.arch.lifecycle.ViewModel;

import javax.inject.Inject;

import example.injector.com.androidinjectorexample.data.api.GithubService;
import example.injector.com.androidinjectorexample.data.entities.User;
import example.injector.com.androidinjectorexample.utils.schedulers.BaseSchedulerProvider;
import rx.Observable;

/**
 * ViewModel for {@link MainActivity}
 */

public class MainViewModel extends ViewModel {

    private GithubService service;
    private BaseSchedulerProvider schedulerProvider;

    @Inject
    public MainViewModel(GithubService service, BaseSchedulerProvider schedulerProvider) {
        this.service = service;
        this.schedulerProvider = schedulerProvider;
    }

    Observable<User> doSomething() {
        return service.getUser("jakeWharton")
                .subscribeOn(schedulerProvider.io())
                .observeOn(schedulerProvider.androidMainThread());
    }
}
