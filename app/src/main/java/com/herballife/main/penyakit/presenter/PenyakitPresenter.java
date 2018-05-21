package com.herballife.main.penyakit.presenter;

import android.content.Intent;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;
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

    public PenyakitPresenter(PenyakitContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void getpenyakit() {

    }

    @Override
    public void moveActivity(Intent intent) {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {
        mView.showpenyakit(penyakitList);
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
}
