package com.herballife.main.catalog.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Catalog;

import java.util.List;

public interface CatalogContract {

    interface View extends BaseView<Presenter> {

        void showCatalogs(List<Catalog> catalogs);

        void showToast(String message);

        void moveToDetailActivity(Catalog catalog);
    }

    interface Presenter extends BasePresenter {

        void moveToDetailActivity(Catalog catalog);
    }
}
