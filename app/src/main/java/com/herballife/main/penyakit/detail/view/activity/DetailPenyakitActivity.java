package com.herballife.main.penyakit.detail.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.R;
import com.herballife.main.model.Penyakit;
import com.herballife.main.penyakit.detail.presenter.DetailPenyakitViewModel;
import com.herballife.main.penyakit.detail.view.fragment.DetailPenyakitFragment;
import com.herballife.main.penyakit.view.fragment.PenyakitFragment;
import com.herballife.main.util.ActivityUtils;

public class DetailPenyakitActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        Penyakit penyakit = getIntent().getParcelableExtra(PenyakitFragment.PENYAKIT_EXTRAS_NAME);
        DetailPenyakitFragment detailPenyakitFragment = DetailPenyakitFragment.newInstance(penyakit);
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                detailPenyakitFragment, R.id.fl_detail_penyakit);

        new DetailPenyakitViewModel(detailPenyakitFragment);
    }
}
