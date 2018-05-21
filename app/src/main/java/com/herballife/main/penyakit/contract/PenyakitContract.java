package com.herballife.main.penyakit.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitContract {

    interface View extends BaseView<Presenter> {

        void showPenyakit(List<Penyakit> penyakits);

        void showToast(String message);

        void moveToDetailActivity(Penyakit penyakit);

        void moveToSearchActivity();
    }

    interface Presenter extends BasePresenter {

        List<String> getPenyakitNames(List<Penyakit> penyakits);

        void moveToDetailActivity(Penyakit penyakit);

        void moveToSearchActivity();
    }

}
