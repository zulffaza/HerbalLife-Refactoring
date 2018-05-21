package com.herballife.main.catalog.dao;

import android.support.annotation.NonNull;

import java.util.List;

public class CatalogRepository implements CatalogDataSource{

    private static CatalogRepository sInstance = null;

    private CatalogDataSource mCatalogDataSource;

    private CatalogRepository(CatalogDataSource mCatalogDataSource) {
        this.mCatalogDataSource = mCatalogDataSource;
    }

    public static CatalogRepository getInstance(CatalogDataSource catalogDataSource){
        if (sInstance == null)
            sInstance = new CatalogRepository(catalogDataSource);

        return sInstance;
    }

    @Override
    public void loadCatalog(@NonNull LoadCatalogsCallback loadCatalogsCallback) {
        mCatalogDataSource.loadCatalog(loadCatalogsCallback);
    }
}
