package com.herballife.main.catalog.viewmodel;

import android.databinding.ObservableField;

import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.catalog.datasource.CatalogDataSource;
import com.herballife.main.catalog.datasource.CatalogRepository;
import com.herballife.main.model.Catalog;

import java.util.List;

public class CatalogViewModel implements CatalogContract.ViewModel {

    private final CatalogContract.View mView;

    private final CatalogRepository mCatalogRepository;

    public final ObservableField<List<Catalog>> catalogs = new ObservableField<>();

    public CatalogViewModel(CatalogRepository catalogRepository, CatalogContract.View view) {
        mCatalogRepository = catalogRepository;
        mView = view;

        mView.setViewModel(this);
    }

    @Override
    public void onCreate() {
        // Do nothing
    }

    @Override
    public void onStart() {
        mCatalogRepository.loadCatalog(new CatalogRepositoryCallback());
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

    private class CatalogRepositoryCallback implements CatalogDataSource.LoadCatalogCallback {

        @Override
        public void onLoadSuccess(List<Catalog> catalogs) {
            CatalogViewModel.this.catalogs.set(catalogs);
        }

        @Override
        public void onLoadFailed(String message) {
            mView.showToast(message);
        }
    }
}
