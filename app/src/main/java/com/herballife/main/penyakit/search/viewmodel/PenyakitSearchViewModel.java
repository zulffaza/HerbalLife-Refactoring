package com.herballife.main.penyakit.search.viewmodel;

import android.databinding.ObservableField;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;
import com.herballife.main.penyakit.search.contract.PenyakitSearchContract;

import java.util.List;

public class PenyakitSearchViewModel implements PenyakitSearchContract.ViewModel {

    private PenyakitSearchContract.View mView;

    private PenyakitRepository mPenyakitRepository;

    public final ObservableField<List<Penyakit>> penyakits = new ObservableField<>();

    public final ObservableField<String> selection = new ObservableField<>();

    public PenyakitSearchViewModel(PenyakitRepository penyakitRepository,
                                   PenyakitSearchContract.View view) {
        mPenyakitRepository = penyakitRepository;
        mView = view;

        mView.setViewModel(this);
    }

    public void changeSelection(CharSequence s, int start, int before, int count) {
        selection.set(s.toString());
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mPenyakitRepository.loadPenyakit(new PenyakitRepositoryCallback());
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

    private class PenyakitRepositoryCallback implements PenyakitDataSource.LoadPenyakitCallback {

        @Override
        public void onLoadSuccess(List<Penyakit> penyakits) {
            PenyakitSearchViewModel.this.penyakits.set(penyakits);
        }

        @Override
        public void onLoadFailed(String message) {
            mView.showToast(message);
        }
    }
}
