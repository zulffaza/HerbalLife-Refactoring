package com.herballife.main.splashscreen.presenter;

import com.herballife.main.splashscreen.contract.SplashScreenContract;

public class SplashScreenPresenter implements SplashScreenContract.Presenter {

    private final SplashScreenContract.View mSplashView;

    public SplashScreenPresenter(SplashScreenContract.View splashView) {
        this.mSplashView = splashView;
        mSplashView.setPresenter(this);

    }

    @Override
    public void startBackgroudProcess() {

    }

    @Override
    public void moveMainActivity() {
        mSplashView.moveMainActivity();
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {
        mSplashView.startBackgroudProcess();

    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }
}
