package com.herballife.main.catalog.dao;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.NonNull;

import com.herballife.main.R;

import java.util.ArrayList;
import java.util.Arrays;

public class CatalogLocalRepository implements CatalogDataSource {

    private static CatalogLocalRepository sInstance = null;

    private Context mContext;

    private CatalogLocalRepository(Context mContext) {
        this.mContext = mContext;
    }

    public static CatalogLocalRepository getInstance(Context context){
        if (sInstance == null)
            sInstance = new CatalogLocalRepository(context);

        return sInstance;
    }

    @Override
    public void loadCatalog(@NonNull LoadCatalogsCallback loadCatalogsCallback) {
        try {
            String[] catalogArray = mContext.getResources().getStringArray(R.array.catalog_array);
            ArrayList<String> catalogs = new ArrayList<>(Arrays.asList(catalogArray));

            loadCatalogsCallback.onLoadSuccess(catalogs);
        } catch (Resources.NotFoundException e){
            String message = mContext.getString(R.string.catalog_error);
            loadCatalogsCallback.onLoadFailed(message);
        }
    }
}
