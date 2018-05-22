package com.herballife.main.splashscreen.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;

import java.util.concurrent.atomic.AtomicInteger;

public interface SplashScreenContract {

    interface View extends BaseView<Presenter> {

        void setProgressBarValue(Integer progress);

        void sendMessage(AtomicInteger progress);

        void setProgressText(String text);

        void incrementProgressBar(Integer progress);

        void moveToMainActivity();
    }

    interface Presenter extends BasePresenter {

        void onStart(Runnable runnable);

        void doBackgroundProcess() throws InterruptedException;

        void setProgressText(AtomicInteger progress);

        void updateProgressBar();

        void moveToMainActivity();
    }
}
