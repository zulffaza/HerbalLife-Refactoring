package com.herballife.main.penyakit.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitContract {

    interface View extends BaseView<Presenter> {

        void showPenyakits(List<String> penyakitNames);

        void showToast(String message);

        void moveToDetailActivity(Penyakit penyakit);

        void moveToSearchActivity();
    }

    interface Presenter extends BasePresenter {

        void moveToDetailActivity(Integer position);

        void moveToSearchActivity();
    }

}
