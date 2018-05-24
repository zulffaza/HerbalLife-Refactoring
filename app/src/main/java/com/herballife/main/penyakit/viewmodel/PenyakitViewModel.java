package com.herballife.main.penyakit.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;

import java.util.List;

public class PenyakitViewModel implements PenyakitContract.ViewModel {

    private PenyakitRepository mPenyakitRepository;

    private PenyakitContract.View mView;

    public final ObservableField<List<Penyakit>> penyakits = new ObservableField<>();

    public PenyakitViewModel(PenyakitRepository penyakitRepository, PenyakitContract.View view) {
        mPenyakitRepository = penyakitRepository;
        mView = view;

        mView.setViewModel(this);
    }

    public void moveToSearchActivity(View view) {
        mView.moveToSearchActivity();
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mPenyakitRepository.loadPenyakit(new PenyakitRepositroyCallback());
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

    private class PenyakitRepositroyCallback implements PenyakitDataSource.LoadPenyakitCallback {

        @Override
        public void onLoadSuccess(List<Penyakit> penyakits) {
            PenyakitViewModel.this.penyakits.set(penyakits);
        }

        @Override
        public void onLoadFailed(String message) {
            mView.showToast(message);
        }
    }
}
