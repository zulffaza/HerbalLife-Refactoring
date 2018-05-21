package com.herballife.main.splashscreen.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;

public interface SplashScreenContract {

    interface View extends BaseView<Presenter> {

        void startBackgroudProcess();
        void moveMainActivity();

    }

    interface Presenter extends BasePresenter {

        void startBackgroudProcess();
        void moveMainActivity();

    }
}
