package com.herballife.main.catalog.contract;

import com.herballife.main.base.BaseViewModel;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Catalog;

public interface CatalogContract {

    interface View extends BaseView<ViewModel> {

        void showToast(String message);

        void moveToDetailActivity(Catalog catalog);
    }

    interface ViewModel extends BaseViewModel {

    }

    interface ItemViewModel extends BaseViewModel {

    }
}
