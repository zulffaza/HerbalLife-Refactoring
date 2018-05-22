package com.herballife.main.penyakit.search.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitSearchContract {

    interface View extends BaseView<Presenter> {

        void showPenyakits(List<String> penyakitNames);

        void showToast(String message);

        void showSelection(String name);

        void moveIntoDetailPenyakit(Penyakit penyakit);
    }

    interface Presenter extends BasePresenter {

        void changeSelection(String name);

        void moveIntoDetailPenyakit(String name);
    }
}
