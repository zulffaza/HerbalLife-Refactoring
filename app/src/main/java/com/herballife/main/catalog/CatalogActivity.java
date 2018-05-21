package com.herballife.main.catalog;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.herballife.main.R;
import com.herballife.main.util.ActivityUtils;

public class CatalogActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        CatalogFragment catalogFragment = CatalogFragment.newInstance();
        ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                catalogFragment, R.id.fl_catalog);
    }
}