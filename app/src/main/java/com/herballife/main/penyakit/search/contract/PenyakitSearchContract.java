package com.herballife.main.penyakit.search.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitSearchContract {

    interface View extends BaseView<Presenter> {

        void showPenyakits(List<Penyakit> penyakits);

        void showToast(String message);

        void showSelection(String penyakit);

        void moveIntoDetailPenyakit(Penyakit penyakit);
    }

    interface Presenter extends BasePresenter {

        List<String> getPenyakitNames(List<Penyakit> penyakits);

        void changeSelection(String penyakit);

        Penyakit getPenyakitFromName(List<Penyakit> penyakits, String name);

        void moveIntoDetailPenyakit(Penyakit penyakit);
    }
}
