package com.herballife.main.penyakit.detail.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

public interface DetailPenyakitContract {

    interface View extends BaseView<Presenter> {

        void showPenyakit();

        void moveToCatalogActivity();
    }

    interface Presenter extends BasePresenter {

        void onStart(Penyakit penyakit);

        void moveToCatalogActivity();
    }
}
