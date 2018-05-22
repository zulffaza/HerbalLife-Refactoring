package com.herballife.main.catalog.detail.presenter;

import com.herballife.main.catalog.detail.contract.DetailCatalogContract;
import com.herballife.main.model.Catalog;

public class DetailCatalogViewModel implements DetailCatalogContract.ViewModel {

    private final DetailCatalogContract.View mView;

    public DetailCatalogViewModel(DetailCatalogContract.View view) {
        mView = view;
        mView.setViewModel(this);
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
    public void onStart(Catalog catalog) {
        if (isCatalogSet(catalog))
            mView.showCatalog();
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

    private Boolean isCatalogSet(Catalog catalog) {
        return catalog != null;
    }
}
