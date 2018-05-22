package com.herballife.main.main.contract;

import com.herballife.main.base.BaseViewModel;
import com.herballife.main.base.BaseView;

public interface MainContract {

    interface View extends BaseView<ViewModel> {

        void moveToSearchActivity();

        void moveToCatalogActivity();

        void showHelpPopup();

        void showExitConfirmationPopup();
    }

    interface ViewModel extends BaseViewModel {

        void moveToSearchActivity();

        void moveToCatalogActivity();

        void showHelpPopup();

        void showExitConfirmationPopup();
    }
}
