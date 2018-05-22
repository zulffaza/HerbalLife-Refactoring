package com.herballife.main.splashscreen.util;

import android.os.Handler;
import android.os.Message;

import com.herballife.main.splashscreen.contract.SplashScreenContract;

import java.util.concurrent.atomic.AtomicInteger;

public class SplashScreenHandler extends Handler {

    private SplashScreenContract.Presenter mPresenter;

    public SplashScreenHandler(SplashScreenContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void handleMessage(Message msg) {
        AtomicInteger progress = (AtomicInteger) msg.obj;

        mPresenter.setProgressText(progress);
        mPresenter.updateProgressBar();
    }
}
