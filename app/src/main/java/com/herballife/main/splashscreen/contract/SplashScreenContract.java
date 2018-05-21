package com.herballife.main.splashscreen.contract;

import android.os.Handler;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;

public interface SplashScreenContract {

    interface View extends BaseView<Presenter> {

        void setRunningIsFalse();

        void setProgressBarInitialValue();

        void setRunningIsTrue();

        void startBackgroundProcess();

        void moveToMainActivity();
    }

    interface Presenter extends BasePresenter {

        void handleProgressBar(Handler handler, Boolean isRunning) throws InterruptedException;

        void moveToMainActivity();
    }
}
