package com.herballife.main.penyakit.presenter;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;

import java.util.ArrayList;
import java.util.List;

public class PenyakitViewModel implements PenyakitContract.ViewModel {

    private PenyakitRepository mPenyakitRepository;

    private PenyakitContract.View mView;

    private List<Penyakit> mPenyakits;

    public PenyakitViewModel(PenyakitRepository penyakitRepository, PenyakitContract.View view) {
        mPenyakitRepository = penyakitRepository;
        mView = view;

        mView.setViewModel(this);
    }

    @Override
    public void moveToDetailActivity(Integer position) {
        mView.moveToDetailActivity(mPenyakits.get(position));
    }

    @Override
    public void moveToSearchActivity() {
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
            List<String> penyakitNames = getPenyakitNames(penyakits);
            mView.showPenyakits(penyakitNames);

            mPenyakits = penyakits;
        }

        @Override
        public void onLoadFailed(String message) {
            mView.showToast(message);
        }

        private List<String> getPenyakitNames(List<Penyakit> penyakits) {
            List<String> names = new ArrayList<>();

            for (Penyakit penyakit : penyakits)
                names.add(penyakit.getName());

            return names;
        }
    }
}
