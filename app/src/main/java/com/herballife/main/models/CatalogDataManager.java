package com.herballife.main.models;

import com.herballife.main.catalog.CatalogContract;

import java.sql.Blob;

public class CatalogDataManager implements CatalogContract.Model {

    private Catalog catalog;

    public CatalogDataManager() {
    }

    @Override
    public void setTumbuhan(String nama, String kegunaan, Blob image) {

        catalog = new Catalog(nama, kegunaan, image);

    }

    @Override
    public String getTumbuhan() {
        return catalog.getName() ;
    }
}
