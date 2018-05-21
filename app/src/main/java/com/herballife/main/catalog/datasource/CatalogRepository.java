package com.herballife.main.catalog.datasource;

public class CatalogRepository implements CatalogDataSource {

    private static CatalogRepository sInstance = null;

    private CatalogDataSource mCatalogDataSource;

    private CatalogRepository(CatalogDataSource catalogDataSource) {
        mCatalogDataSource = catalogDataSource;
    }

    public static CatalogRepository getInstance(CatalogDataSource catalogDataSource) {
        if (sInstance == null)
            sInstance = new CatalogRepository(catalogDataSource);

        return sInstance;
    }

    @Override
    public void loadCatalog(LoadCatalogCallback loadCatalogCallback) {
        mCatalogDataSource.loadCatalog(loadCatalogCallback);
    }
}
