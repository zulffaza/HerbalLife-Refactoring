package com.herballife.main.catalog;

import com.herballife.main.models.CatalogDataManager;

import java.sql.Blob;

public class CatalogPresenter implements CatalogContract.Presenter {

    private CatalogContract.View view;
    private CatalogContract.Model model;

    public CatalogPresenter(CatalogContract.View view) {
        this.view = view;
        model = new CatalogDataManager();
    }


    @Override
    public void setView(CatalogContract.View view) {
        view.showTumbuhan(/*Param*/);
    }

    @Override
    public void setDetailView(CatalogContract.View view) {

    }

    @Override
    public void submitTumbuhan(String nama, String kegunaan, Blob image) {
        model.setTumbuhan(nama, kegunaan, image);
    }
}
