package example.injector.com.androidinjectorexample.data.api;

import java.util.List;

import example.injector.com.androidinjectorexample.data.entities.Repo;
import example.injector.com.androidinjectorexample.data.entities.User;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;


public interface GithubService {

    @GET("/users/{user}")
    Observable<User> getUser(@Path("user") String user);

    @GET("users/{user}/repos")
    Observable<List<Repo>> listRepos(@Path("user") String user);

}
