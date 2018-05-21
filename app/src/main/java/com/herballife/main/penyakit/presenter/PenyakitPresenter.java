package com.herballife.main.penyakit.presenter;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.contract.PenyakitContract;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;

import java.util.ArrayList;
import java.util.List;

public class PenyakitPresenter implements PenyakitContract.Presenter {

    private PenyakitRepository mPenyakitRepository;

    private PenyakitContract.View mView;

    public PenyakitPresenter(PenyakitRepository penyakitRepository, PenyakitContract.View view) {
        mPenyakitRepository = penyakitRepository;
        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public List<String> getPenyakitNames(List<Penyakit> penyakits) {
        List<String> names = new ArrayList<>();

        for (Penyakit penyakit : penyakits)
            names.add(penyakit.getName());

        return names;
    }

    @Override
    public void moveToDetailActivity(Penyakit penyakit) {
        mView.moveToDetailActivity(penyakit);
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
            mView.showPenyakit(penyakits);
        }

        @Override
        public void onLoadFailed(String message) {
            mView.showToast(message);
        }
    }
}
