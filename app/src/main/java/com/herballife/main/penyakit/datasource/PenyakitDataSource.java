package com.herballife.main.penyakit.datasource;

import com.herballife.main.model.Penyakit;

import java.util.List;

public interface PenyakitDataSource {

    interface LoadPenyakitCallback {

        void onLoadSuccess(List<Penyakit> penyakits);
        void onLoadFailed(String message);
    }

    void loadPenyakit(LoadPenyakitCallback loadPenyakitCallback);
}
