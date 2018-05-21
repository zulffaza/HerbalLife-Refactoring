package com.herballife.main.util;

import android.content.Context;

import com.herballife.main.penyakit.datasource.PenyakitRepository;
import com.herballife.main.penyakit.datasource.local.PenyakitLocalDataSource;

public class Injection {

    public static PenyakitRepository providePenyakitRepository(Context context) {
        return PenyakitRepository.getInstance(PenyakitLocalDataSource.getInstance(context));
    }
}
