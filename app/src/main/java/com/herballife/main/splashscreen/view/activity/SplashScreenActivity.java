package com.herballife.main.splashscreen.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.R;
import com.herballife.main.splashscreen.presenter.SplashScreenPresenter;
import com.herballife.main.splashscreen.view.fragment.SplashScreenFragment;
import com.herballife.main.util.ActivityUtils;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SplashScreenFragment splashScreenFragment = SplashScreenFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                splashScreenFragment, R.id.fl_splash_screen);

        new SplashScreenPresenter(splashScreenFragment);

    }
}
