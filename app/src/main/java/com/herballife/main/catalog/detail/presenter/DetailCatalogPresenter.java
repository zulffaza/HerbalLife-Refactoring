package com.herballife.main.catalog.detail.presenter;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.herballife.main.catalog.detail.contract.DetailCatalogContract;
import com.herballife.main.model.Catalog;

public class DetailCatalogPresenter implements DetailCatalogContract.Presenter {

    private final DetailCatalogContract.View mView;

    public DetailCatalogPresenter(DetailCatalogContract.View view) {
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public Bitmap createBitmapFromByteArray(byte[] image) {
        return BitmapFactory.decodeByteArray(image, 0, image.length);
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
