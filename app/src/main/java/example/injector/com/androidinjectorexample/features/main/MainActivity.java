package example.injector.com.androidinjectorexample.features.main;

import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import javax.inject.Inject;

import dagger.android.AndroidInjection;
import example.injector.com.androidinjectorexample.R;

public class MainActivity extends AppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelProvider;

    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewModel = ViewModelProviders.of(this, viewModelProvider)
                .get(MainViewModel.class);

        viewModel.doSomething();
    }

}
