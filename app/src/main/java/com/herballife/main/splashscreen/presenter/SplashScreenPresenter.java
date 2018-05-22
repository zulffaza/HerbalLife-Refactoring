package com.herballife.main.splashscreen.presenter;

import com.herballife.main.splashscreen.contract.SplashScreenContract;

import java.util.concurrent.atomic.AtomicInteger;

public class SplashScreenPresenter implements SplashScreenContract.Presenter {

    private static final Integer INITIAL_PROGRESS = 0;

    private static final Integer MAX_PROGRESS = 5;

    private static final Integer SLEEP_TIME = 1000;

    private static final Integer INCREMENT_PROGRESS = 20;

    private final SplashScreenContract.View mView;

    private Boolean mIsRunning;

    public SplashScreenPresenter(SplashScreenContract.View view) {
        this.mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void doBackgroundProcess() throws InterruptedException {
        AtomicInteger progress = new AtomicInteger(INITIAL_PROGRESS);

        for (Integer i = INITIAL_PROGRESS; i < MAX_PROGRESS && mIsRunning; i++) {
            Thread.sleep(SLEEP_TIME);
            mView.sendMessage(progress);
        }
    }

    @Override
    public void setProgressText(AtomicInteger progress) {
        String text = progress.addAndGet(INCREMENT_PROGRESS) + "% Completed";
        mView.setProgressText(text);
    }

    @Override
    public void updateProgressBar() {
        mView.incrementProgressBar(INCREMENT_PROGRESS);
    }

    @Override
    public void moveToMainActivity() {
        mView.moveToMainActivity();
    }

    @Override
    public void onCreate() {
        mIsRunning = Boolean.FALSE;
    }

    @Override
    public void onStart() {
        // Do nothing
    }

    @Override
    public void onStart(Runnable runnable) {
        mIsRunning = Boolean.TRUE;
        mView.setProgressBarValue(INITIAL_PROGRESS);

        startBackgroundProcess(runnable);
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
        mIsRunning = Boolean.FALSE;
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }

    private void startBackgroundProcess(Runnable runnable) {
        new Thread(runnable).start();
    }
}
