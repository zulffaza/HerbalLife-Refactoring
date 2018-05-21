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

    public PenyakitSearchPresenter(PenyakitRepository penyakitRepository,
                                   PenyakitSearchContract.View view) {
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
    public void changeSelection(String penyakit) {
        mView.showSelection(penyakit);
    }

    @Override
    public Penyakit getPenyakitFromName(List<Penyakit> penyakits, String name) {
        for (Penyakit penyakit : penyakits) {
            if (penyakit.getName().equals(name))
                return penyakit;
        }

        return null;
    }

    @Override
    public void moveIntoDetailPenyakit(Penyakit penyakit) {
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

    private Boolean isFound(Penyakit penyakit) {
        return penyakit != null;
    }

    private class PenyakitRepositoryCallback implements PenyakitDataSource.LoadPenyakitCallback {

        @Override
        public void onLoadSuccess(List<Penyakit> penyakits) {
            mView.showPenyakits(penyakits);
        }

        @Override
        public void onLoadFailed(String message) {
            mView.showToast(message);
        }
    }
}
