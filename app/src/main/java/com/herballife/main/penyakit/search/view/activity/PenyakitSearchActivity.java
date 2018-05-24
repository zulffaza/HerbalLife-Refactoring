package com.herballife.main.penyakit.search.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.R;
import com.herballife.main.penyakit.search.viewmodel.PenyakitSearchViewModel;
import com.herballife.main.penyakit.search.view.fragment.PenyakitSearchFragment;
import com.herballife.main.util.ActivityUtils;
import com.herballife.main.util.Injection;

public class PenyakitSearchActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit_search);

        PenyakitSearchFragment penyakitSearchFragment = PenyakitSearchFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                penyakitSearchFragment, R.id.fl_penyakit_search);

        new PenyakitSearchViewModel(Injection.providePenyakitRepository(this),
                penyakitSearchFragment);
    }
}

