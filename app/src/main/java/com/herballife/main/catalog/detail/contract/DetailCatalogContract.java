package com.herballife.main.catalog.detail.contract;

import com.herballife.main.base.BaseViewModel;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Catalog;

public interface DetailCatalogContract {

    interface View extends BaseView<ViewModel> {

        void showCatalog();
    }

    interface ViewModel extends BaseViewModel {

        void onStart(Catalog catalog);
    }
}
