package com.herballife.main.catalog.detail.viewmodel;

import android.databinding.ObservableField;

import com.herballife.main.catalog.detail.contract.DetailCatalogContract;
import com.herballife.main.model.Catalog;

public class DetailCatalogViewModel implements DetailCatalogContract.ViewModel {

    private final DetailCatalogContract.View mView;

    public final ObservableField<Catalog> catalog = new ObservableField<>();

    public final ObservableField<String> name = new ObservableField<>();

    public final ObservableField<String> use = new ObservableField<>();

    public final ObservableField<Byte[]> image = new ObservableField<>();

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
        if (isCatalogSet(catalog)) {
            setCatalog(catalog);
            setFields();
        }
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

    private void setCatalog(Catalog catalog) {
        this.catalog.set(catalog);
    }

    private void setFields() {
        String use = mView.getUseTitle() + " " + catalog.get().getUse();

        this.name.set(catalog.get().getName());
        this.use.set(use);
        this.image.set(catalog.get().getImage());
    }
}
