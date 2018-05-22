package com.herballife.main.penyakit.detail.presenter;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.detail.contract.DetailPenyakitContract;

public class DetailPenyakitViewModel implements DetailPenyakitContract.ViewModel {

    private final DetailPenyakitContract.View mView;

    public DetailPenyakitViewModel(DetailPenyakitContract.View view) {
        mView = view;
        mView.setViewModel(this);
    }

    @Override
    public void moveToCatalogActivity() {
        mView.moveToCatalogActivity();
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        // Do nothing
    }

    @Override
    public void onStart(Penyakit penyakit) {
        if (isPenyakitSet(penyakit))
            mView.showPenyakit();
    }

    @Override
    public void onResume() {
        // Do nothing
    }

    @Override
    public void onPause() {
        // Do nothing
    }

    @Override
    public void onStop() {
        // Do nothing
    }

    @Override
    public void onDestroy() {
        // Do nothing
    }

    private Boolean isPenyakitSet(Penyakit penyakit) {
        return penyakit != null;
    }
}
