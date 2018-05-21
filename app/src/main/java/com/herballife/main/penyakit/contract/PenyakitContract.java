package com.herballife.main.penyakit.contract;

import android.content.Intent;

import com.herballife.main.base.BasePresenter;
import com.herballife.main.base.BaseView;
import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitContract {

    interface View extends BaseView<Presenter> {

        void showpenyakit(List<Penyakit> penyakitList);
        void moveActivity(Intent intent);

    }

    interface Presenter extends BasePresenter {

        void getpenyakit();
        void moveActivity(Intent intent);

    }

}
