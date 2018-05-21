package com.herballife.main.penyakit.presenter;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;

import java.util.List;

public class PenyakitPresenter implements PenyakitContract.Presenter {

    private List<Penyakit> penyakitList;

    private PenyakitRepository mPenyakitRepository;
    private PenyakitContract.View mView;

    public PenyakitPresenter(PenyakitRepository mPenyakitRepository, PenyakitContract.View mView) {
        this.mPenyakitRepository = mPenyakitRepository;
        this.mView = mView;

        mView.setPresenter(this);
    }

    @Override
    public void movetoDetailActivity(Penyakit penyakit) {
        mView.movetoDetailActivity(penyakit);
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {
        mPenyakitRepository.loadPenyakit(new PenyakitRepositroyCallback());
    }

    @Override
    public void onResume() {

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void onDestroy() {

    }


    private class PenyakitRepositroyCallback implements PenyakitDataSource.LoadPenyakitCallback {
        @Override
        public void onLoadSuccess(List<Penyakit> penyakits) {
            mView.showpenyakit(penyakits);
        }

        @Override
        public void onLoadFailed(String message) {
            mView.showToast(message);
        }
    }
}
