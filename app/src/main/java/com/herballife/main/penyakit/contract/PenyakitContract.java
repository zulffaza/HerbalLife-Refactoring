package com.herballife.main.penyakit.contract;

import com.herballife.main.base.BaseViewModel;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

public interface PenyakitContract {

    interface View extends BaseView<ViewModel> {

        void showToast(String message);

        void moveToDetailActivity(Penyakit penyakit);

        void moveToSearchActivity();
    }

    interface ViewModel extends BaseViewModel {

    }

    interface RowViewModel extends BaseViewModel {

        void moveToDetailActivity();
    }
}
