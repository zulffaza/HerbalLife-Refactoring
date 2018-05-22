package com.herballife.main.penyakit.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.R;
import com.herballife.main.penyakit.presenter.PenyakitViewModel;
import com.herballife.main.penyakit.view.fragment.PenyakitFragment;
import com.herballife.main.util.ActivityUtils;
import com.herballife.main.util.Injection;

public class PenyakitActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit);

        PenyakitFragment penyakitFragment = PenyakitFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                penyakitFragment, R.id.fl_penyakit);

        new PenyakitViewModel(Injection.providePenyakitRepository(this),
                penyakitFragment);
    }
}
