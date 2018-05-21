package com.herballife.main.catalog.dao;

import android.support.annotation.NonNull;

import java.util.List;

public interface CatalogDataSource {

    interface LoadCatalogsCallback{

        void onLoadSuccess(@NonNull List<String> catalog);
        void onLoadFailed(@NonNull String message);

    }

    void loadCatalog(@NonNull CatalogRepository.LoadCatalogsCallback loadCatalogsCallback);

}
