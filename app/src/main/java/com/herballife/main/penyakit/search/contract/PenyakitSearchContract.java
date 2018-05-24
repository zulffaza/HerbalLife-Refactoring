package com.herballife.main.penyakit.search.contract;

import com.herballife.main.base.BaseView;
import com.herballife.main.base.BaseViewModel;
import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitSearchContract {

    interface View extends BaseView<ViewModel> {

        void showToast(String message);

        void moveToDetailActivity(Penyakit penyakit);
    }

    interface ViewModel extends BaseViewModel {

    }

    interface ItemViewModel extends BaseViewModel {

    }
}
