package com.herballife.main.penyakit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.R;
import com.herballife.main.penyakit.presenter.PenyakitPresenter;
import com.herballife.main.util.ActivityUtils;

public class PenyakitActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_penyakit);

        PenyakitFragment penyakitFragment = PenyakitFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                penyakitFragment, R.id.fl_penyakit);

        new PenyakitPresenter(penyakitFragment);
    }
}
