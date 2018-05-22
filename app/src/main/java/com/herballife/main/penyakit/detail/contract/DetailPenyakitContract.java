package com.herballife.main.penyakit.detail.contract;

import com.herballife.main.base.BaseViewModel;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

public interface DetailPenyakitContract {

    interface View extends BaseView<ViewModel> {

        void showPenyakit();

        void moveToCatalogActivity();
    }

    interface ViewModel extends BaseViewModel {

        void onStart(Penyakit penyakit);

        void moveToCatalogActivity();
    }
}
