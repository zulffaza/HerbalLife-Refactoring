package com.herballife.main.catalog.viewmodel;

import android.databinding.ObservableField;
import android.view.View;

import com.herballife.main.catalog.contract.CatalogContract;
import com.herballife.main.model.Catalog;

public class CatalogItemViewModel implements CatalogContract.ItemViewModel {

    public final ObservableField<Catalog> catalog = new ObservableField<>();

    public final ObservableField<String> name = new ObservableField<>();

    private CatalogContract.View mView;

    public CatalogItemViewModel(CatalogContract.View view, Catalog catalog) {
        mView = view;
        this.catalog.set(catalog);
        this.name.set(this.catalog.get().getName());
    }

    public void moveToDetailActivity(View view) {
        mView.moveToDetailActivity(catalog.get());
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
