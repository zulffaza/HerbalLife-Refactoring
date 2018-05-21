package com.herballife.main.splashscreen.presenter;

import android.os.Handler;
import android.os.Message;

import com.herballife.main.splashscreen.contract.SplashScreenContract;

import java.util.concurrent.atomic.AtomicInteger;

public class SplashScreenPresenter implements SplashScreenContract.Presenter {

    private static final Integer INITIAL_PROGRESS = 0;
    private static final Integer MAX_PROGRESS = 5;
    private static final Integer SLEEP_TIME = 1000;

    private final SplashScreenContract.View mView;

    public SplashScreenPresenter(SplashScreenContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void handleProgressBar(Handler handler, Boolean isRunning) throws InterruptedException {
        AtomicInteger progress = new AtomicInteger(INITIAL_PROGRESS);

        for (Integer i = INITIAL_PROGRESS; i < MAX_PROGRESS && isRunning; i++) {
            Thread.sleep(SLEEP_TIME);
            handler.sendMessage(createMessage(handler, progress));
        }
    }

    @Override
    public void moveToMainActivity() {
        mView.moveToMainActivity();
    }

    @Override
    public void onCreate() {
        mView.setRunningIsFalse();
    }

    @Override
    public void onStart() {
        mView.setProgressBarInitialValue();
        mView.setRunningIsTrue();
        mView.startBackgroundProcess();
    }

    @Override
    public void onResume() {
        // Do nothing
    }

    @Override
    public void onPause() {
        // Do nothing
    }

    @Override
    public void onStop() {
        mView.setRunningIsFalse();
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }

    private Message createMessage(Handler handler, AtomicInteger progress) {
        Message message = handler.obtainMessage();
        message.obj = progress;

        return message;
    }
}
