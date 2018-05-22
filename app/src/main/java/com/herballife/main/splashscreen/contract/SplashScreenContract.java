package com.herballife.main.splashscreen.contract;

import com.herballife.main.base.BaseViewModel;
import com.herballife.main.base.BaseView;

import java.util.concurrent.atomic.AtomicInteger;

public interface SplashScreenContract {

    interface View extends BaseView<ViewModel> {

        void sendMessage(AtomicInteger progress);

        void moveToMainActivity();
    }

    interface ViewModel extends BaseViewModel {

        void onStart(Runnable runnable);

        void doBackgroundProcess() throws InterruptedException;

        void setProgressText(AtomicInteger progress);

        void updateProgressBar();

        void moveToMainActivity();
    }
}
