package com.herballife.main.penyakit.search.presenter;

import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.datasource.PenyakitDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;
import com.herballife.main.penyakit.search.contract.PenyakitSearchContract;

import java.util.ArrayList;
import java.util.List;

public class PenyakitSearchPresenter implements PenyakitSearchContract.Presenter {

    private PenyakitSearchContract.View mView;

    private PenyakitRepository mPenyakitRepository;

    private List<Penyakit> mPenyakits;

    public PenyakitSearchPresenter(PenyakitRepository penyakitRepository,
                                   PenyakitSearchContract.View view) {
        mPenyakitRepository = penyakitRepository;
        mView = view;

        mView.setPresenter(this);
    }

    @Override
    public void changeSelection(String name) {
        mView.showSelection(name);
    }

    @Override
    public void moveIntoDetailPenyakit(String name) {
        Penyakit penyakit = getPenyakitFromName(name);

        if (isFound(penyakit))
            mView.moveIntoDetailPenyakit(penyakit);
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

    private Penyakit getPenyakitFromName(String name) {
        for (Penyakit penyakit : mPenyakits) {
            if (penyakit.getName().equals(name))
                return penyakit;
        }

        return null;
    }

    private Boolean isFound(Penyakit penyakit) {
        return penyakit != null;
    }

    private class PenyakitRepositoryCallback implements PenyakitDataSource.LoadPenyakitCallback {

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
