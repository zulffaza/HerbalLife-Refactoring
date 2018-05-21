package com.herballife.main.penyakit.datasource;

public class PenyakitRepository implements PenyakitDataSource {

    private static PenyakitRepository sInstance = null;

    private PenyakitDataSource mPenyakitDataSource;

    private PenyakitRepository(PenyakitDataSource penyakitDataSource) {
        mPenyakitDataSource = penyakitDataSource;
    }

    public static PenyakitRepository getInstance(PenyakitDataSource penyakitDataSource) {
        if (sInstance == null)
            sInstance = new PenyakitRepository(penyakitDataSource);

        return sInstance;
    }

    @Override
    public void loadPenyakit(LoadPenyakitCallback loadPenyakitCallback) {
        mPenyakitDataSource.loadPenyakit(loadPenyakitCallback);
    }
}
