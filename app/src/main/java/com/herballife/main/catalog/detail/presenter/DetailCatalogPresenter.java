package com.herballife.main.catalog.detail.presenter;

import com.herballife.main.catalog.detail.contract.DetailCatalogContract;

public class DetailCatalogPresenter implements DetailCatalogContract.Presenter {

    private final DetailCatalogContract.View mView;

    public DetailCatalogPresenter(DetailCatalogContract.View view) {
        mView = view;
        mView.setPresenter(this);
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
}
