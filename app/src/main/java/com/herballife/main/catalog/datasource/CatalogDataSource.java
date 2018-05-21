package com.herballife.main.catalog.datasource;

import com.herballife.main.model.Catalog;

import java.util.List;

public interface CatalogDataSource {

    interface LoadCatalogCallback {

        void onLoadSuccess(List<Catalog> catalogs);

        void onLoadFailed(String message);
    }

    void loadCatalog(LoadCatalogCallback loadCatalogCallback);
}
