package com.herballife.main.penyakit.contract;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitContract {

    interface View extends BaseView<Presenter> {

        void showpenyakit(List<Penyakit> penyakitList);
        void showToast(String message);
        void movetoDetailActivity(Penyakit penyakit);

    }

    interface Presenter extends BasePresenter {

        void movetoDetailActivity(Penyakit penyakit);

    }

}
