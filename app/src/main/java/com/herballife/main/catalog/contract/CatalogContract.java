package com.herballife.main.catalog.contract;


import android.support.annotation.NonNull;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.catalog.model.Catalog;

import java.util.List;

public interface CatalogContract {

    interface View extends BaseView<Presenter>{

        void showToastMessage(@NonNull String message);
        void showCatalog(List<String> catalog);
        void showDetailCatalog(List<Catalog> catalog);

    }

    interface Presenter extends BasePresenter{

        void getCatalog();
        void getDetailCatalog();
    }
}
