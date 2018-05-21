package com.herballife.main.splashscreen;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.util.ActivityUtils;
import com.herballife.main.R;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        SplashScreenFragment splashScreenFragment = SplashScreenFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                splashScreenFragment, R.id.fl_splash_screen);
    }
}