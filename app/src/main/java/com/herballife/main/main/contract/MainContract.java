package com.herballife.main.main.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;

public interface MainContract {

    interface View extends BaseView<Presenter> {

        void moveToSearchActivity();

        void moveToCatalogActivity();

        void showHelpPopup();

        void showExitConfirmationPopup();
    }

    interface Presenter extends BasePresenter {

        void moveToSearchActivity();

        void moveToCatalogActivity();

        void showHelpPopup();

        void showExitConfirmationPopup();
    }
}
