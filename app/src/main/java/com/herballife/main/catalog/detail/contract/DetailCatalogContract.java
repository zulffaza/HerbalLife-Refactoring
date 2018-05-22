package com.herballife.main.catalog.detail.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Catalog;

public interface DetailCatalogContract {

    interface View extends BaseView<Presenter> {

        void showCatalog();
    }

    interface Presenter extends BasePresenter {

        void onStart(Catalog catalog);
    }
}
