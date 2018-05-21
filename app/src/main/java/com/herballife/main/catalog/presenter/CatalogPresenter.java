package com.herballife.main.catalog.presenter;

import android.support.annotation.NonNull;

import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.catalog.dao.CatalogDataSource;
import com.herballife.main.catalog.dao.CatalogRepository;
import com.herballife.main.catalog.model.Catalog;
import com.herballife.main.catalog.view.fragment.CatalogFragment;


import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class CatalogPresenter implements CatalogContract.Presenter {

    private final CatalogContract.View mView;
    private CatalogRepository mCatalogRepository;

    public CatalogPresenter(CatalogContract.View mView, CatalogRepository catalogRepository) {
        this.mView = mView;
        this.mCatalogRepository = catalogRepository;

        mView.setPresenter(this);
    }

    public CatalogPresenter(CatalogRepository catalogRepository, CatalogFragment catalogFragment) {
        mView = null;
    }


    @Override
    public void getCatalog() {
        mCatalogRepository.loadCatalog(new CatalogDataSource.LoadCatalogsCallback() {
            @Override
            public void onLoadSuccess(@NonNull List<String> catalog) {
                mView.showCatalog(catalog);
            }

            @Override
            public void onLoadFailed(@NonNull String message) {
                mView.showToastMessage(message);
            }
        });
        // ambil data dari model



    }

    @Override
    public void getDetailCatalog() {

    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onStart() {

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
