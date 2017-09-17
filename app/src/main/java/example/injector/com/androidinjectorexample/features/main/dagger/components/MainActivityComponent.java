package example.injector.com.androidinjectorexample.features.main.dagger.components;

import javax.inject.Singleton;

import dagger.Component;
import example.injector.com.androidinjectorexample.features.main.dagger.modules.MainActivityModule;

/**
 * Dagger Component builds all provided dependencies from {@link dagger.Module}s
 * and exposes dependencies downstream.
 */

@Singleton
@Component( modules = {MainActivityModule.class })
public interface MainActivityComponent {

}
