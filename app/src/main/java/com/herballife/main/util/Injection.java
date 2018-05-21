package com.herballife.main.util;

import android.content.Context;

import com.herballife.main.catalog.datasource.CatalogRepository;
import com.herballife.main.catalog.datasource.local.CatalogLocalDataSource;
import com.herballife.main.penyakit.datasource.PenyakitRepository;
import com.herballife.main.penyakit.datasource.local.PenyakitLocalDataSource;

public class Injection {

    public static PenyakitRepository providePenyakitRepository(Context context) {
        return PenyakitRepository.getInstance(PenyakitLocalDataSource.getInstance(context));
    }

    public static CatalogRepository provideCatalogRepository(Context context) {
        return CatalogRepository.getInstance(CatalogLocalDataSource.getInstance(context));
    }
}
